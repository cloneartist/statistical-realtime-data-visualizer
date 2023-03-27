import React from "react";
import Chart1 from "./chart1";
const Customer = () =>{
    return (
        <>

        //display chart with country vs no. of customer data
              <Chart1 url="country_vs_customers" name="No. of customers" yComponentName="numberOfCustomers" title="Country vs Number Of Customers"/>

        
        
        </>
    );
};

export default Customer;