import React from "react";
import Chart1 from "./chart1";

const Salary = () =>{
    return (
        <>
        //display chart with country vs avg Salary
          <Chart1 url="country_vs_salary" name="Average Salary" yComponentName="averageSalary" title="Country vs  Average Salary"/>

        
        </>
    );
};

export default Salary;