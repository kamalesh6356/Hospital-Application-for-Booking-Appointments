import React from "react";
import "../styles/AboutUs.css";
const AboutUs = () => {
     return(
        <>
        
           
            <div className="container-1">
            <h1 className="heading" xss="removed">Welcome to <span xss="removed">Balco Medical Centre</span></h1> 
            <div className="img">
            <img  src="https://www.balcomedicalcentre.com/uploads/slider/about_slider-1.png"/>
            </div>
           
            <div className="heading-1">
              
            
            <h2 className="heading-2">A Premier Cancer Hospital</h2>
            <p className="a-para">
            Balco Medical Centre (BMC), a 170 bedded state-of-the-art tertiary care Oncology facility<br></br> in Naya Raipur, is the first flagship initiative of Vedanta Medical Research<br></br> Foundation (VMRF). VMRF, a non-profit organization, is an initiative of Vedanta Resources and Bharat Aluminium Company Ltd. (BALCO) to contribute<br></br> towards prevention of cancer and its related illnesses. BMC has brought ultra-modern, multi-modality diagnostic and therapeutic facilities within easy reach of India’s population at an affordable cost. Currently, it is fast emerging as a national leader in India’s oncology space including medical, surgical, radiation, haematological and palliative care. 
            </p>
            </div>
         
            </div>
        
        </>
     );
}
export default AboutUs