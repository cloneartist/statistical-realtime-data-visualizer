import { HashRouter,Route, Routes } from 'react-router-dom';
import './App.css';
import Sidenav from './Pages/Sidenav';


function App() {
  return (
        <>
        <HashRouter>
        <Routes>
        <Route path="/" element={<Sidenav />} />
        </Routes>
      
      {/* <Sidenav>
      
      
      </Sidenav> */}
      </HashRouter>
      </>
      
  );
}

export default App;
