import React, { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import "../components/chart1.css";
import axios from "axios";

const Chart1 = (props) => {
  const [yComponent, setnumberOfCustomers] = useState([]);
  const [name, setname] = useState([]);
  const getData = async () => {
  
    await axios(`https://srdv.stackroute.io/analytics/${props.url}`).then((res) => {
      setnumberOfCustomers(res.data.map((item) => item[props.yComponentName]));
      setname(res.data.map((item) => item.name));
    });
  };

  useEffect(() => {
    const interval = setInterval(() => {
      // console.log('This will run every second!');
      getData();
    }, 1000);
    return () => clearInterval(interval);
  }, []);

  const series = [
    {
      name: props.name,
      data: yComponent,
    },
  ];

  // let options_for_customers;
  let options;

  //chart data for country vs no. of customers
  if (props.yComponentName === "numberOfCustomers") {
    options = {
      legend: {
        fontSize: "20px",
        horizontalAlign:'center',
        offsetX:80,
        offsetY:15,
      },
      plotOptions: {
        bar: {
          columnWidth: 50,
          distributed: true,
        },
      },
      dataLabels: {
        enabled: false,
      },


      title: {
        text: props.title,
        align: "center",
        style:{
          color:'#1a1859',
          // fontFamily: 'Geneva',
          fontSize: '28px'}
      },
      chart: {
        id: "bar-chart",
        toolbar: {
          tools: {
            download: '<b>Download\u2B07\uFE0E</b>'
          }
        },
        //
        // animations: {
        //   enabled: true,
        //   easing: "linear",
        //   dynamicAnimation: {
        //     speed: 1000,
        //   },
        // },
      },
      //

      xaxis: {
        categories: name,
        labels: {
          style: {
            fontSize: '15px'
        }},
        title: {
          style:{
            color:'#1a1859',
          // fontFamily: 'Geneva',
            fontSize: '18px'},
          text: "Country",
        },
      },

      yaxis: [
        { 
          labels: {
            style: {
              fontSize: '15px'
          },
          
            show: true,
            formatter: function (val) {
              return val.toFixed(0);
            },
          },
          title: {
            style:{
              color:'#1a1859',
            // fontFamily: 'Geneva',
              fontSize: '18px',
            
          },
         
         offsetX:-10, 
            text: "No. Of Customers",
          },
        },
      ],
    };
    //chart data for country vs avg creditscore
  } else if (props.yComponentName === "averageCreditScore") {
    options = {
      legend: {
        fontSize: "20px",
        horizontalAlign:'center',
        offsetX:80,
        offsetY:15,
      },
      dataLabels: {
        enabled: false,
      },
      plotOptions: {
        bar: {
          columnWidth: 50,
          distributed: true,
        },
      },


      title: {
        
        text: props.title,
        style:{
          color:'#1a1859',
          // fontFamily: 'Geneva',
          fontSize: '28px'},
        align: "center",
      },
      chart: { id: "bar-chart" , toolbar: {
        tools: {
          download: '<b>Download\u2B07\uFE0E</b>'
        }
      },},
      xaxis: {
        labels: {
          style: {
              fontSize: '15px'
          }

     },
        categories: name,
        fontSize:'200px',
        title: {
          style:{
            color:'#1a1859',
          // fontFamily: 'Geneva',
            fontSize: '18px'},
          text: "Country",
        },
      },

      yaxis: [
        { fontSize:'200px',
          labels: {
            style: {
              fontSize: '15px'
          },
            show: true,
          },
          decimalsInFloat:2,
          title: {
            style:{
              color:'#1a1859',
          // fontFamily: 'Geneva',
              fontSize: '18px'},
              offsetX:-10, 
            text: "Average Credit Score",
          },
        },
      ],
    };
  }
  //chart data for country vs avg salary
  else {
    options = {
      
      legend: {
        fontSize: "20px",
        horizontalAlign:'center',
        offsetX:80,
        offsetY:15,
      },
      plotOptions: {
        bar: {
          
          columnWidth: 50,
          distributed: true,
        },
      },
      dataLabels: {
        
        enabled: false,
      },
      
      
      title: {
        text: props.title,
        
        style:{
          color:'#1a1859',
          // fontFamily: 'Geneva',
          fontSize: '28px'},
        align: "center",
        
      },
      chart: { id: "bar-chart",
      // toolbar: {
      //   customIcons: [{
      //     html: '<i class="fa fa-angle-down"></i>',
      //     onClick: function(e, chartContext){},
      //     appendTo: 'left' // left / top means the button will be appended to the left most or right most position
      //    }]}

      toolbar: {
            tools: {
              download: '<b>Download\u2B07\uFE0E</b>'
            }
          },
       },
      xaxis: {
        categories: name,
        labels: {
          style: {
              fontSize: '15px'
          }
          },
        title: {
          style:{
            color:'#1a1859',
          // fontFamily: 'Geneva',
            fontSize: '18px'},
          text: "Country",
        },
      },
     
      yaxis: [{
          labels: {
            style:{
              fontSize:'15px'
            },
            show: true,},
            decimalsInFloat:2,
          title: {
            style:{
              color:'#1a1859',
          // fontFamily: 'Geneva',
            fontSize: '18px',
            offsetY: -30},
            text: "Average Salary",
            offsetX:-10, 
          },
        },
      ],
    };
  }

  return (
    <div className="chartdet">
      <Chart options={options} series={series} type="bar" width="1100" />
    </div>
  );
};

export default Chart1;