import React from 'react';
import { DataGrid, GridToolbar } from '@mui/x-data-grid';
import axios from 'axios';


const Home  = () => {
  
  const columns = [{ field: 'customer_id',headerName:'Customer Id' ,width:180},{ field: 'credit_score',headerName:'Credit Score',flex:1}, { field: 'country',headerName:'Country', flex:1},{ field: 'gender',headerName:'Gender' ,width:180},{ field: 'age',headerName:'Age'},{ field: 'balance',headerName:'Balance',flex:1},{ field: 'credit_card',headerName:'Credit Card',flex:1},{ field: 'estimated_salary',headerName:'Estimated Salary', flex:1}];
    let url ='https://srdv.stackroute.io/analytics/customer';


  const [filterModel, setFilterModel] = React.useState({
    items: [
      {
        field: 'rating',
        operator: '>',
        value: '2.5',
      },
    ],
  });
  const [rows, setRows] = React.useState([]);
  React.useEffect(() => {
    axios.get(url).then((response) => {
      setRows(response.data);
      console.log(response.data);
    });
  },[]);
  console.log(rows);
  
    // axios.get(url).then(res=>{
    //   console.log(res.data);[]
    //   //const rows = res.data;
    // })
    
  
    return (
        <> <br /><br />
               <div style={{ height: 871, width: '100%'}}>
      <DataGrid
        columns={columns}
        rows={rows}
        getRowId={(row)=>row.id+
        row.customer_id+
        row.credit_score+
        row.country+
        row.gender+
        row.age+
        row.balance+
        row.credit_card+
        row.estimated_salary
        
        }
        slots={{
          toolbar: GridToolbar,
        }}
        filterModel={filterModel}
        onFilterModelChange={(newFilterModel) => setFilterModel(newFilterModel)}
      />
    </div>
        </>
    );
};

export default Home;