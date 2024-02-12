export const fetchPerson = async(id) => {
    const API = apiURL()
   
    try {
      let res = await axios.get(`${API}/person/:person_id`);

      return res.data.person;
    } catch (error) {
      console.log(error`error`)
    }
  }

  export const fetchCompanies = async ( id, data ) => {
    const API = apiURL()
    try {
      let res = await axios.get(`${API}/company/:id`)
        return res.data.company;
    } catch (error) {
        console.log(error`error`);
    }


}
export const fetchCompanyContacts = async ( id, data ) => {
  const API = apiURL()
  try {
    let res = await axios.get(`${API}/person/:company_id`)
      return res.data.user.userPic;
  } catch (error) {
      console.log(error`error`);
  }

  
}

export const createCompanyName = async (dataObj) => {
    try {
      const res = await axios.post(API + `/company/:company_name`, dataObj);
      return res;
    } catch (error) {
      console.log(error`Company name is required with maximum length of 50`);
    }
  };

  export const createCompanyAddress = async (dataObj) => {
    try {
      const res = await axios.post(API + `/company/:address`, dataObj);
      return res;
    } catch (error) {
      console.log(error`Full mailing address is required with maximum length of 50`);
    }
  };

  export const createCompanyPhone = async (dataObj) => {
    try {
      const res = await axios.post(API + `/company/:phone`, dataObj);
      return res;
    } catch (error) {
      console.log(error`Phone number is required with maximum length of 50`);
    }
  };
  export const createCompanyWebsite = async (dataObj) => {
    try {
      const res = await axios.post(API + `/company/:website`, dataObj);
      return res;
    } catch (error) {
      console.log(error`Website is required with maximum length of 50`);
    }
  };
  

  export const createFirstName = async (dataObj) => {
    try {
      const res = await axios.post(API + `/person/:first_name`, dataObj);
      return res;
    } catch (error) {
      console.log(error`First name is required with maximum length of 50`);
    }
  };

  export const createLastName = async (dataObj) => {
    try {
      const res = await axios.post(API + `/person/:last_name`, dataObj);
      return res;
    } catch (error) {
      console.log(error`Last name is required with maximum length of 50`);
    }
  };

  export const createEmailAddress = async (dataObj) => {
    try {
      const res = await axios.post(API + `/person/:email_address`, dataObj);
      return res;
    } catch (error) {
      console.log(error`Email address is required with maximum length of 50`);
    }
  };

  export const createStreetAddress = async (dataObj) => {
    try {
      const res = await axios.post(API + `/person/:street_address`, dataObj);
      return res;
    } catch (error) {
      console.log(error`Street address is required with maximum length of 50`);
    }
  };

  export const createCity = async (dataObj) => {
    try {
      const res = await axios.post(API + `/person/:city`, dataObj);
      return res;
    } catch (error) {
      console.log(error`City is required with maximum length of 50`);
    }
  };

  export const createState = async (dataObj) => {
    try {
      const res = await axios.post(API + `/person/:state`, dataObj);
      return res;
    } catch (error) {
      console.log(error`State is required with maximum length of 2`);
    }
  };

  export const createZipCode = async (dataObj) => {
    try {
      const res = await axios.post(API + `/person/:zip_code`, dataObj);
      return res;
    } catch (error) {
      console.log(error`Zip code is required with maximum length of 5`);
    }
  };