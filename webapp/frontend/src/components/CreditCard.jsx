import React from "react";
import Chart1 from "./chart1";
const CreditCard = () =>{
    return (
        <>
    //display chart with country vs avg credit score data
    <Chart1 url="country_vs_credit" name="Average Credit Score" yComponentName="averageCreditScore" title="Country vs Average Credit Score"/>

        
        </>
    );
};

export default CreditCard;