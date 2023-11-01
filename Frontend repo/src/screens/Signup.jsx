import React, {  useEffect, useState } from "react";

import "../styles/patientPortal.css";
import doctor from "../assets/doctor.svg";
import {FaFacebookF} from 'react-icons/fa';
import {FcGoogle} from 'react-icons/fc';
import { IconContext } from "react-icons";
import { register } from "../services/userService";
import { toast } from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import { useNavigate } from "react-router";



const Signup = () => {

  const navigate = useNavigate();

  const[userData,setuserData] = useState({
    name:'',
    email:'',
    password:'',
    mobileNumber:''

  })

  // const [error,setError]=useState({
  //   errors:{},
  //   isError:false
  // })

  useEffect(() => {
   
  },[userData])
  const handleChange = (event,property) =>{
    setuserData({...userData,[property]:event.target.value})
  }
  const onSubmit = (e) =>{
    e.preventDefault();

    register(userData).then((resp) =>{
      toast.success("User Created Successfully",{
        className:'toast-message'
      })
      navigate("/patientLogin")

    }).catch((error)=>{
      if(error.response.data.status===500){
        toast.error("EmailId already Exists.Try logIn to your account using forgot password",{className:'toast-message'})
        navigate("/patientLogin")
      }
    })


    
  }



  return (
    <>
      <section className="loginsection register-section ">
        <div className="container grid grid-two-column">
          <div className="login-image">
            {/* <img src="/hero.png" alt="user loggin pic" /> */}
            {/* <img src={doctor} className="hero-image" alt="user login " /> */}
          </div>
          {/* right side div  */}
          <div className="login-data register-data">
            
            <p className="bold-text">Create Your Account!</p>
            <p className="common-para register-para">
              Join the most trusted platform and connect with Doctors
              community instantly.
            </p>
            {/* form start  */}
            <form onSubmit={(e)=>onSubmit(e)}>
            <div className="form">
                <input
                  type="text"
                  id="name"
                  className="form__input"
                  placeholder=" "
                  name="name"
                  onChange={(e) => handleChange(e,'name')}
                  value={userData.name}
                 
                />
                <label htmlFor="name" className="form__label">
                   Name
                </label>
              </div>
              <div className="form">
                <input
                  type="text"
                  id="mobileNumber"
                  className="form__input"
                  placeholder=" "
                  name="mobileNumber"
                  onChange={(e) => handleChange(e,'mobileNumber')}
                  value={userData.mobileNumber}
                 
                />
                <label htmlFor="mobileNumber" className="form__label">
                   Mobile Number
                </label>
              </div>


              <div className="form">
                <input
                  type="text"
                  id="email"
                  className="form__input"
                  placeholder=" "
                  name="email"
                  onChange={(e) => handleChange(e,'email')}
                  value={userData.email}
                 
                />
                <label htmlFor="email" className="form__label">
                  Email Address
                </label>
              </div>

              {/* for mobile number  */}
              
              <div className="form">
                <input
                  type="password"
                  id="password"
                  className="form__input"
                  placeholder=" "
                  name="password"
                  onChange={(e) => handleChange(e,'password')}
                  value={userData.password}
                  
                />
                <label htmlFor="password" className="form__label">
                  Pasword
                </label>
              </div>

              <div className="form">
                <input
                  type="password"
                  id="repeat password"
                  className="form__input"
                  placeholder=" "
                  name="repeatpassword"
                  
                />
                <label htmlFor="repeat password" className="form__label">
                  Repeat Password
                </label>
              </div>

              
              

              <input
                type="submit"
                value="REGISTER"
                className="btn register-btn"
              />
            </form>
            {/* extra way to login  */}
           
            <p className="common-para">
              or join us with your social network account
            </p>
            <div className="social-btn">
            <IconContext.Provider value={{  size:"3em",className:"fa-brands fa-facebook-f"}}>
                <div>
                  <FaFacebookF/>
                </div>
            </IconContext.Provider>
              
            <IconContext.Provider value={{  size:"3em",className:"fa-brands fa-m"}}>
                <div>
                  <FcGoogle />
                </div>
            </IconContext.Provider>
              
              
            </div>
            <p className="common-para">
              Already have an account with us? <a href="/patientLogin"> Login </a> here
            </p>
          </div>
        </div>
      </section>
    </>
  );
};
export default Signup;
