import axios from "axios";
import { useState,useEffect } from "react";
import { Link} from "react-router-dom";
import DoctorService from "../services/DoctorService";
// import { getCurrentUserDetail } from "../auth";
import {  toast } from 'react-toastify';

import "../styles/ViewAppointment.css"



const ViewDoctors = () => {

  const[doctors,setDoctors] = useState([])

  useEffect(() =>{
    getAllDoctors();
}, [])
  
  
  const getAllDoctors=() =>{
    DoctorService.getDoctor().then((response) => {
      setDoctors(response.data)
      console.log(response.data)
    
  }).catch(error => {
    console.log(error);
  })

  }
  


    
    
 
  return (
    <div className = "container2">
    <h2 className = "text-center"> Doctor List</h2>
    <hr/>
    <br></br>
    <Link to = "/bookAppointment" className = "btn2 btn-primary mb-2" > Book Appointment </Link>
    <table className="list">
        <thead>
            <th>Doctor Id</th>
            <th> Doctor name</th>
            <th> Specialisation  </th>
           
            
        </thead>
        <tbody>
            {
                doctors.map(
                    doctor =>
                    <tr key = {doctor.doctorId}> 
                    <td>{doctor.doctorId}</td>
                        <td>{doctor.name}</td>
                        <td> {doctor.specialisation} </td>
                       

                        <td>

                        </td>

                        
                        
                       
                        
                        
                    </tr>
                )
            }
        </tbody>
    </table>
</div>
  );
};

export default ViewDoctors;
