
import React, { useEffect, useState } from 'react';
import Chart from "react-apexcharts";

const Chart1 = (props) => {
  
  const [yComponent, setnumberOfCustomers] = useState([]);
  const [name, setname] = useState([]);

  useEffect(() => {
    const getData = async () => {
        //API URL
    const url = 'http://localhost:8080/'+props.url;
    
    try {

      const response = await fetch(url);
      const data = await response.json();
      console.log(data);
      
      console.log()
      setnumberOfCustomers(data?.map((item) => item[props.yComponentName]));
      (data?.map((item) => console.log(item[props.yComponentName])));
      // console.log(numberOfCustomers);
      setname(data?.map((item) => item.name));    
      

    } catch (error) {
        console.log(error);
    }
    
  };

    getData();
  }, []);


  const series = [ 
    //data on the y-axis
    {
      name: props.name,
      data: yComponent
    }
  ];

  // let options_for_customers;
  let options;

      
  if(props.yComponentName=="numberOfCustomers"){
    options = { 
     
     title:{
      text:props.title,
      align:'center'
     },
      chart: { id: 'bar-chart'},
      xaxis: {
        categories: name
      },

      
    
      yaxis: [
        {
          labels: {
            formatter: function(val) {
              return val.toFixed(0);
            }
          }
        }
      ]
        
  
      }
  }else{
    options = { 
     
     title:{
      text:props.title,
      align:'center',
      // fontSize:'200px'
     },
      chart: { id: 'bar-chart'},
      xaxis: {
        categories: name
      }
  }
  
  };

  return (
    <div>
      <Chart
        options={options}
        series={series}
        type="bar"
        width="800"
      />
      
    </div>
  )
}

export default Chart1;
