import React, { useEffect } from "react";
import { useState } from "react";
import AppointmentService from "../services/AppointmentService";
import {  useNavigate } from "react-router-dom";
import { useParams } from "react-router-dom";
import {  toast } from 'react-toastify';
import { ConstructionOutlined } from "@mui/icons-material";
const BookAppointment=() => {
  const [appointmentId,setAppointmentId]=useState('')
  const [appointmentDate,setAppointmentDate]=useState('')
  const [patientName,setPatientName]=useState('')
  const [message,setMessage]=useState('')
  const navigate = useNavigate();
  const {id}=useParams();
  
  
  // const saveAppointment = (e) =>
  // {
  //   e.preventDefault();
  //   const appointment = {appointmentId,appointmentDate,patientName}
  //   AppointmentService.bookAppointment(appointment).then((response) => {
  //     console.log(response.data)
  //     alert("appointment added");
  //      navigate('/viewAppointment');

  //   }).catch(error => {
  //     console.log(error)
  //   })
  // }

    useEffect(() => {
      AppointmentService.getAppointmentById(id).then((response) =>{
        setAppointmentId(response.data.appointmentId)
        setAppointmentDate(response.data.appointmentDate)
        setPatientName(response.data.patientName)
        setMessage(response.data.message)
      }).catch(error=>{
        console.log(error)
      })
    },[])
  const title=() =>
  {
    if(id){
      return <div className="title">update Appointment</div>
    }else{
         return<div className="title">Book appointment</div>
    }
  }
   
  const saveAppointment = (e) =>
  {
    e.preventDefault();
    const appointment = {appointmentId,appointmentDate,patientName,message}
    if(id){
         AppointmentService.updateAppointment(id,appointment).then((response) => {
          navigate('/viewAppointment');

         }).catch(error =>{
          console.log(error);
         })
    }else{
    AppointmentService.bookAppointment(appointment).then((response) => {
      console.log(response.data)
      alert("appointment added");
       navigate('/viewAppointment');

    }).catch(error => {
      console.log(error)
    })
  }
}
  
  return(
    <>
    <div>

    <div className="container1">
    {/* <div className="title">Book Appointment</div> */}
    {
      title()
    }
    
    <div className="content1">
      <form onSubmit={(e)=>saveAppointment(e)}>
    <div className="user-details"></div>
      <div className="input-box">
            <span className="details">Appointment Id</span>
            <input type="text" name="appointmentId" value={appointmentId} onChange={(e) => setAppointmentId(e.target.value)} placeholder="Enter AppointmentId" required/>
          </div>
          
          <div class="input-box">
            <span class="details">Patient name</span>
            <input type="text" name="patient name" value={patientName} onChange={(e) => setPatientName(e.target.value)}  placeholder="enter patient name" required/>
          </div>
          <div class="input-box">
            <span class="details">Appointment Date</span>
            <input type="Date" name="appointmentDate" value={appointmentDate}  onChange={(e) => setAppointmentDate(e.target.value)} placeholder="Enter Date " required/>
          </div>
          <div class="input-box">
            <span class="details">Message </span>
            <input type="text" name="message" value={message} onChange={(e) => setMessage(e.target.value)}  placeholder="enter message " required/>
          </div>
          <div class="button1">
          <input type="submit" value="Book Appointment" />
        </div>
      </form>

      </div>
      </div>
      </div>
    </>


  );
  }


export default BookAppointment;