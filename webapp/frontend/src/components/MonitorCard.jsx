import React, { useEffect, useState } from 'react';
import ApexCharts from 'apexcharts';
import ReactApexChart from 'react-apexcharts';
import Chart from "react-apexcharts";
import axios from "axios";
import "./MonitorCard.css";
const MonitorCard=(props)=>{
    const[data,setData]=useState(0);
    const fetchData = async () => {
        const response = await fetch(`https://srdv.stackroute.io/${props.url}`);
        const data1 = await response.json();


        var dataLength=data1.length;
        console.log(data1);
        console.log(dataLength);
        setData(dataLength)
      };
        
          useEffect(() => {
            const interval = setInterval(() => {
                // console.log('This will run every second!');
                fetchData();
              }, 700);
              return () => clearInterval(interval);
            // fetchData();

            }, []);
       
        return(
            <>
          
            <div id="main">
               
                <p className='sentdata'>{props.title}</p>
                <div className="datamain">
                {data}
                </div>
            </div>
            </>
        )
        }
                              
export default MonitorCard;


