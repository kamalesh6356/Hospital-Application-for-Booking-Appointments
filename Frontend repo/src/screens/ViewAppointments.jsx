import axios from "axios";
import { useState,useEffect } from "react";
import { Link} from "react-router-dom";
// import { getCurrentUserDetail } from "../auth";
import {  toast } from 'react-toastify';

import "../styles/ViewAppointment.css"
import AppointmentService from "../services/AppointmentService";



const ViewAppointment = () => {

  const[appointments,setAppointments] = useState([])

  useEffect(() =>{
    getAllAppointments();
}, [])
  
  
  const getAllAppointments=() =>{
    AppointmentService.getAppointment().then((response) => {
      setAppointments(response.data)
      console.log(response.data)
    
  }).catch(error => {
    console.log(error);
  })

  }
  

//   const loadAppointments = async () => {
//     const response = await axios.get('http://localhost:8082/getAppointmentBypatientEmail/'+userEmail);
    
//     setAppointments(response.data)
//  }

  const cancelAppointment = (appointmentId) => {
    AppointmentService.deleteAppointment(appointmentId).then((response) =>{
     getAllAppointments();
    }).catch(error =>{
      console.log(error);
    })
    // toast.success("Your Appointment has been cancelled successfully",{autoClose:1000});
  //  loadAppointments();
  
  }
    
    
 
  return (
    <div className = "container2">
    <h2 className = "text-center"> My Appointments</h2>
    <hr/>
    <br></br>
    <Link to = "/bookAppointment" className = "btn2 btn-primary mb-2" > Book Appointment </Link>
    <table className="list">
        <thead>
            <th> Appointment Id </th>
            <th> Appointment Date</th>
            <th> Patient Name </th>
            <th> Message  </th>
            <th> Actions</th>
            
        </thead>
        <tbody>
            {
                appointments.map(
                    appointment =>
                    <tr key = {appointment.appointmentId}> 
                        <td>{appointment.appointmentId}</td>
                        <td> {appointment.appointmentDate} </td>
                        <td> {appointment.patientName} </td>
                        <td> {appointment.message} </td>

                        <td> <Link className="btn1 btn-primary" style={{marginLeft:"10px"}} to={`/updateAppointment/${appointment.appointmentId}`} >Update</Link>
                              <button className="btn1 btn-danger" onClick={() => cancelAppointment(appointment.appointmentId)} style={{marginLeft:"10px"}}>cancel</button>

                        </td>

                        
                        
                       
                        
                        
                    </tr>
                )
            }
        </tbody>
    </table>
</div>
  );
};

export default ViewAppointment;
