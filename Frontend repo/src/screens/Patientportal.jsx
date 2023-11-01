
import React, { useState } from "react";
import 'bootstrap/dist/css/bootstrap.css';
import "../styles/patientPortal.css";
import { loginUser } from "../services/userService";
import doctor from "../assets/doctor.svg"
import {FaFacebookF} from 'react-icons/fa';
import {FcGoogle} from 'react-icons/fc';
import { IconContext } from "react-icons";
import { Link, useNavigate } from 'react-router-dom';
import { toast } from "react-toastify";
import { doLogin } from "../auth";
const Patientportal = () =>{
const navigate = useNavigate();
 const[userLoginData,setuserLoginData ] =  useState({
    email:'',
    password:''
  })
  const handleChange = (event,field) =>{
    let actualValue = event.target.value
    setuserLoginData({...userLoginData,[field]:actualValue})
  } 
  const onSubmit = (event) =>{
    event.preventDefault();

    if(userLoginData.email.trim()==='' && userLoginData.password.trim()===''){
      toast.error("Username and password is Required !!",{className:'toast-message'})
      return;
    }
    else if(userLoginData.email.trim()===''){
      toast.error("Username  is required",{className:'toast-message'})
      return;
    }
    else if(userLoginData.password.trim()===''){
      toast.error("password is required",{className:'toast-message'})
      return;
    }


    loginUser(userLoginData).then((jwtTokenData) => {
      doLogin(jwtTokenData,()=>{
        navigate("/")
      })
      toast.success("user Logged In Successfully")
      
      
    }).catch(error=>{
      if(error.response.status===400){
        toast.error(error.response.data.message ,{className:'toast-message'})
      }
      else if(error.response.status===404){
        toast.error(error.response.data.message,{className:'toast-message'})
      }
      console.log(error)
    })

  }
    
    return(
      <>
      <section className="loginsection section ">
        <div className="container3 grid grid-two-column">
          <div className="login-image">
             
          </div>
          {/* right side div  */}
          <div className="login-data">
            
            <p className="bold-text">Welcome back!</p>
            {/* form start  */}
              <form onSubmit={(e) => onSubmit(e)} className="login-form">
                <div className="form">
                  <input
                    type="text"
                    id="email"
                    className="form__input"
                    placeholder=" "
                    name="email"
                    value={userLoginData.email}
                    onChange={(e) => handleChange(e,'email')}
                    
                  />
                  <label htmlFor="email" className="form__label">
                    Email
                  </label>
                </div>

              <div className="form">
                <input
                  type="password"
                  id="password"
                  className="form__input"
                  placeholder=" "
                  name="password"
                  value={userLoginData.password}
                  onChange={(e) => handleChange(e,'password')}
                  
                />
                <label htmlFor="password" className="form__label">
                  Password
                </label>
              </div>

              <div className="checkbox">
                <input type="checkbox" className="form-checkbox" />

                <p className="common-para">Remember me on this system</p>
              </div>

              <div className="forgotPassword">
                <a
                  className="common-para"
                  href="#"
                  target="_blank"
                  rel="noopener noreferrer">
                  Forgot Password?
                </a>
              </div>

              <input type="submit" value="Login" className="btn" />
            </form>
            {/* extra way to login  */}
            <p className="common-para">
              or login with your social network account
            </p>
            <div className="social-btn login-btn">
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
              Don't have account yet? <Link to="/signUp"> Sign Up </Link> here
            </p>
          </div>
        </div>
      </section>
    </>
    );
}


export default Patientportal;