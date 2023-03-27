
import React, { useEffect, useState } from 'react';
import Chart from "react-apexcharts";
import '../components/chart1.css';
const Chart1 = (props) => {
  
  const [yComponent, setnumberOfCustomers] = useState([]);
  const [name, setname] = useState([]);

  useEffect(() => {
    const getData = async () => {
        //API URL
    const url = 'http://localhost:8091/'+props.url;
    
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
    
    {
      name: props.name,
      data: yComponent
    }
  ];

  // let options_for_customers;
  let options;

      //chart data for country vs no. of customers
  if(props.yComponentName=="numberOfCustomers"){
    
    options = { 
      plotOptions: {
        bar: {
          columnWidth: 50,
          distributed: true,
        }
      },
      dataLabels: {
        enabled: false
      },
      
    // fill: {
    //   colors: ["#b74656"]
    // },
      
     title:{
      text:props.title,
      align:'center'
     },
      chart: { id: 'bar-chart',


      //
      animations: {
        enabled: true,
        easing: 'linear',
        dynamicAnimation: {
          speed: 1000,
        },},},
        //


      xaxis: {
        categories: name,
        title: {
          text: 'Country',
        },
      },

      
    
      yaxis: [
        {
          labels: {
            show: true,
            formatter: function(val) {
              return val.toFixed(0);
            }
          },
          title: {
            text: 'No. Of Customers',
          }
        }
      ]
        
  
      }
      //chart data for country vs avg creditscore
  }else if(props.yComponentName=="averageCreditScore"){
    
    options = { 
      dataLabels: {
        enabled: false
      },
      plotOptions: {
        bar: {
          columnWidth: 50,
          distributed: true,
        }
      },
  
      // fill: {
      //   colors: ["#1B998B"]
      // },

     title:{
      text:props.title,
      align:'center'
     },
      chart: { id: 'bar-chart'},
      xaxis: {
       categories: name,
        title: {
          text: 'Country',
        },
      },
    

      
    
      yaxis: [
        {
          labels: {
            show: true,
            // formatter: function(val) {
            //   return val.toFixed(0);
            // }
          },
          title: {
            text: 'Average Credit Score',
          }
        }
      ]
        
  
      }
  }
  //chart data for country vs avg salary
  else{
    options = { 
      plotOptions: {
        bar: {
          columnWidth: 50,
          distributed: true,
        }
      },
      dataLabels: {
        enabled: false
      },
      // fill: {
      //   colors: ["#006b3f"]
      // },
    

     title:{
      text:props.title,
      align:'center',
      // fontSize:'200px'
     },
      chart: { id: 'bar-chart'},
      xaxis: {
        categories: name,
        title: {
          text: 'Country',
        },
      },
      yaxis: [
        {
          labels: {
            show: true,
          },
          title: {
            text: 'Average Salary',
          }
        
        }]
  }
  
  };

  return (
    <div className='chartdet'>
      
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
