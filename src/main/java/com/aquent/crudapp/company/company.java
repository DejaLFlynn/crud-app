package com.aquent.crudapp.company;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The company entity corresponding to the "company" table in the database.
 */
public class Company {

    private Integer companyId;

    @NotNull
    @Size(min = 1, max = 50, message = "Company name is required with maximum length of 50")
    private String companyName;

    @NotNull
    @Size(min = 1, max = 50, message = "Website is required with maximum length of 50")
    private String website;

    @NotNull
    @Size(min = 1, max = 50, message = "Phone number is required with maximum length of 50")
    private String phone;

    @NotNull
    @Size(min = 1, max = 50, message = "Full mailing address is required with maximum length of 50")
    private String mailing_address;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMailingAddress() {
        return mailing_address;
    }

    public void setMailingAddress(String mailing_address) {
        this.mailing_address = mailing_address;
    }
    //returns list of contacts from company 
    // public void setContactList() {
    //     return companyId;
    // }
}
