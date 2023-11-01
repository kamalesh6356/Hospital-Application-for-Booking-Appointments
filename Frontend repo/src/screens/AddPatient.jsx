import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import PatientService from "../services/PatientService";
import "../styles/BookAppointment.css"
import { getCurrentUserDetail } from "../auth";

const AddPatient = () => {
    const navigate = useNavigate();
   
    const userEmail = getCurrentUserDetail().email;
    const [patient,setPatient]=useState({
        
        patientName:"",
        patientEmailId:userEmail,
        patientMobileNo:"",
        patientgender:""
      })

    const {patientName,patientEmailId,patientMobileNo,patientgender} = patient;

    const onInputChange = (e) => {
        setPatient({...patient, [e.target.name]: e.target.value });
      };
    const onSubmit = async (e) => {
        e.preventDefault();
        PatientService.savePatient(patient).then((resp)=>{
            toast.success("patient Details successfully added",{className:'toast-message'})
            navigate("/bookAppointment")
        }).catch((error)=>{
            console.log(error)
        })

    }
    return(
        <div className="container1">
     
        <div className="title">Make an Appointment</div>
        <div className="content1">
          <form onSubmit={(e) => onSubmit(e)}>
          <div className="user-details">
         
          <div class="input-box">
            <span class="details">Patient Name</span>
            <input type="text" name="patientName" value={patientName} onChange={(e) => onInputChange(e)} placeholder="Enter Patient Name" required/>
          </div>
          <div class="input-box">
            <span class="details">Patient Email</span>
            <input type="text" name="patientEmail" value={patientEmailId} onChange={(e) => onInputChange(e)}  placeholder={userEmail} disabled/>
          </div>
          <div class="input-box">
            <span class="details">Patient MobileNo</span>
            <input type="text" name="patientMobileNo" value={patientMobileNo} onChange={(e) => onInputChange(e)}  placeholder={"Enter Patient mobile no"} required/>
          </div>
          <div class="input-box">
            <span class="details">Patient Gender</span>
            <input type="text" name="patientgender" value={patientgender} onChange={(e) => onInputChange(e)}  placeholder={"Enter Patient Gender"} required/>
          </div>
          
         
         
         
          
          
        </div>
        <div class="button1">
          <input type="submit" value="Save " />
        </div>
      </form>
      
    </div>
    
  </div>
    
    );
}
export default AddPatient;