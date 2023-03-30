import React from "react";
import "../components/chart1.css";
import MonitorCard from "./MonitorCard";

const Monitor = () =>{
    return (
        <>
        <h1> Space </h1>
        <div className="row">
        <div className="col-4">
                {/* <RadialChart url="8090/sent_log" name="sent log" packet_status="sent"/>  
                    */}
                      <h3 className='heading2'>Monitoring KAFKA Pipeline : Ingestion & Analytics</h3>
            <hr></hr>
            
            <div>
                    <MonitorCard  url="sent_log" name="sent log" packet_status="sent" title="Sent From Ingestion Service"></MonitorCard>
                    <img className='sendimg' src='https://cdn-icons-png.flaticon.com/512/4697/4697980.png'></img>
                    <MonitorCard  url="receive_log" name="receive log" packet_status="received" title="Received By Analytics Service"></MonitorCard>
                    </div>
        </div>
             <div className="col-4">
                
             </div>
</div>
   
        </>
        
    );
};



export default Monitor;