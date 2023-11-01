
import { useState } from "react";
import {  useNavigate, useParams } from "react-router-dom";

import AppointmentService from "../services/AppointmentService";

import "../styles/BookAppointment.css"




const UpdateAppointment = () => {
    const navigate = useNavigate();
    const {appointmentId} =useParams();
    const disablePastDate = () => {
        const today = new Date();
        const dd = String(today.getDate() + 1).padStart(2, "0");
        const mm = String(today.getMonth() + 1).padStart(2, "0"); //January is 0!
        const yyyy = today.getFullYear();
        return yyyy + "-" + mm + "-" + dd;
      }
    console.log(appointmentId)
    const [updateAppointment,setupdateAppointment]=useState({
        
        appointmentDate:"",
      })

      const {appointmentDate} = updateAppointment;

      const onInputChange = (e) => {
        //spread operator (since we are giving only name field)
        //new update will keep on adding
        setupdateAppointment({ ...updateAppointment, [e.target.name]: e.target.value });
        //check in components
      };
    console.log(updateAppointment)
    const onSubmit = async(e) =>{
        e.preventDefault()
        AppointmentService.updateAppointmentDate(appointmentId,updateAppointment).then((response)=>{
            navigate('/viewAppointment')
        }).catch((error)=>{
            console.log(error)
        })

    }    

        
    
    return(
        <div class="container">
     
    
    <div class="content1">
      <form onSubmit={(e) => onSubmit(e)}>
        <div class="user-details">
          <div class="input-box">
            <span class="details">Reschedule Appointment</span>
            <input type="date" name ="appointmentDate" value={appointmentDate} min={disablePastDate()} onChange={(e) => onInputChange(e)} required/>
          </div>
        </div>  
          
         
        
        <div class="button1">
          <input type="submit" value="Reschedule" />
        </div>
      </form>
      
    </div>
    
  </div>
    );
}
export default UpdateAppointment;