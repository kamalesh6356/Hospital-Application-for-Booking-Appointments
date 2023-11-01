import { BrowserRouter, Route,Routes } from "react-router-dom";
import Home from './screens/Home';
import { ToastContainer } from "react-toastify";
import Patientportal from './screens/Patientportal';
import Signup from './screens/Signup'
import BookAppointment from "./screens/BookAppointment"
import ViewAppointment from "./screens/ViewAppointments";
import UpdateAppointment from "./screens/UpdateAppointment"
import AddPatient from "./screens/AddPatient";
import Navbar from "./components/Navbar";
import AboutUs from "./components/AboutUs";
import ViewDoctors from "./screens/ViewDoctors";
function App() {
  return (
    <div>
    <BrowserRouter>
      <ToastContainer />
      <div><Navbar />
      
      <div>
        <Routes>
          <Route path="/" element={<Home />} />
          
          <Route path = "/bookAppointment" element={<BookAppointment />} />
          <Route path = "/viewAppointment" element={<ViewAppointment />} />
          <Route path = "/addPatient" element={<AddPatient />}/>
          <Route path = "/updateAppointment/:appointmentId" element={<BookAppointment />}/>
          <Route path = "/aboutUs" element={<AboutUs />}/>
          <Route path = "/viewDoctors" element={<ViewDoctors />} />
        </Routes>
      </div>
      </div>
      <div>
        <Routes>
          <Route path="patientLogin" element={<Patientportal />} />
          <Route path="signUp" element={<Signup />} />
        </Routes>
      </div>
      
         
      
        
    
    </BrowserRouter>
    </div>
   
  );
}

export default App;
