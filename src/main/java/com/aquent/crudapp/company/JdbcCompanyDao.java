package com.aquent.crudapp.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring JDBC implementation of {@link CompanyDao}.
 */
@Component
public class JdbcCompanyDao implements CompanyDao {

    private static final String SQL_LIST_COMPANIES = "SELECT * FROM company ORDER BY company_id, company_name";
    private static final String SQL_READ_COMPANY = "SELECT * FROM company WHERE company_id = :companyId";
    private static final String SQL_DELETE_COMPANY = "DELETE FROM company WHERE company_id = :companyId";
    private static final String SQL_UPDATE_COMPANY = "UPDATE company SET (company_name, website, phone, mailing_address)"
                                                  + " = (:companyName, :website, :phone, :mailingAddress)"
                                                  + " WHERE company_id = :companyId";
    private static final String SQL_CREATE_COMPANY = "INSERT INTO company (company_name, website, phone, mailing_address)"
                                                  + " VALUES (:companyName, :website, :phone, :mailingAddress)";
    private static final String SQL_LIST_CONTACTS = "SELECT (person.person_id, person.first_name, person.last_name FROM person JOIN company ON (person.person_id = company_id) ";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JdbcCompanyDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Company> listCompanies() {
        return namedParameterJdbcTemplate.getJdbcOperations().query(SQL_LIST_COMPANIES, new CompanyRowMapper());
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Company readCompany(Integer companyId) {
        return namedParameterJdbcTemplate.queryForObject(SQL_READ_COMPANY, Collections.singletonMap("companyId", companyId), new CompanyRowMapper());
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
    public void deleteCompany(Integer companyId) {
        namedParameterJdbcTemplate.update(SQL_DELETE_COMPANY, Collections.singletonMap("companyId", companyId));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
    public void updateCompany(Company company) {
        namedParameterJdbcTemplate.update(SQL_UPDATE_COMPANY, new BeanPropertySqlParameterSource(company));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
    public Integer createCompany(Company company) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(SQL_CREATE_COMPANY, new BeanPropertySqlParameterSource(company), keyHolder);
        return keyHolder.getKey().intValue();
    }

    //Joins both tables at the person id to be available in a list on company page 
    // @Override
    // @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    // public List<Company> listContactList() {
    //     return namedParameterJdbcTemplate.getJdbcOperations().query(SQL_LIST_CONTACTS, new CompanyRowMapper());
    // }
    /**
     * Row mapper for company records. multiple companies whole row
     */
    private static final class CompanyRowMapper implements RowMapper<Company> {

        @Override
        public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
            Company company = new Company();
            company.setCompanyId(rs.getInt("company_id"));
            company.setCompanyName(rs.getString("company_name"));
            company.setWebsite(rs.getString("website"));
            company.setPhone(rs.getString("phone"));
            company.setMailingAddress(rs.getString("mailing_address"));
            // company.setContactList(rs.getInt("company_id")); // setting the contact list in row mapper

           
            return company;
        }
    }
}
