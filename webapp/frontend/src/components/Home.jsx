import React from 'react';
import Table from 'react-bootstrap/Table';
import 'bootstrap/dist/css/bootstrap.min.css';
const Home  = () => {
    return (
        <> <br /><br /><br /><br />
<div>
<Table striped bordered hover size="sm">
      <thead>
        <tr>
          <th>S.NO</th>
          <th>Customer Name</th>
          <th>Credit Score</th>
          <th>Gender</th>
          <th>Credit Score</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td colSpan={5}></td>
          <td></td>
        </tr>
        <tr>
          <td>2</td>
          <td></td>
         
        </tr>
        <tr>
          <td>3</td>
          <td colSpan={5}></td>
          <td></td>
        </tr>
        <tr>
          <td>4</td>
          <td colSpan={2}></td>
          <td></td>
        </tr>
        <tr>
          <td>5 </td>
          <td colSpan={5}></td>
          <td></td>
        </tr>
      </tbody>
    </Table>
    </div>
        </>
    );
};

export default Home;