import React from 'react';
import { DataGrid, GridToolbar } from '@mui/x-data-grid';
import axios from 'axios';


const Home  = () => {
  
  const columns = [{ field: 'customer_id',headerName:<b>CUSTOMER ID </b> ,width:180},{ field: 'credit_score',headerName:<b>CREDIT SCORE</b>,flex:1}, { field: 'country',headerName:<b>COUNTRY</b>, flex:1},{ field: 'gender',headerName:<b>GENDER</b> ,width:180},{ field: 'age',headerName:<b>AGE</b>},{ field: 'balance',headerName:<b>BALANCE</b>,flex:1},{ field: 'credit_card',headerName:<b>CREDIT CARD</b>,flex:1},{ field: 'estimated_salary',headerName:<b>ESTIMATED SALARY</b>, flex:1}];
    let url ='http://localhost:9090/analytics/customer';


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