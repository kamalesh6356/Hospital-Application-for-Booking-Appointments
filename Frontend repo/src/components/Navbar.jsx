import React, { useEffect, useState } from "react";
import { Link,Outlet, useNavigate } from 'react-router-dom';
import logo from "../assets/balco_logo.png";
import nabh from "../assets/nabh.png";
import IGBC from "../assets/IGBC_gold.png";
import portal from "../assets/portal-0.png";
import contact from "../assets/contact-0.png";

import {FiLogOut} from 'react-icons/fi';

import { IconContext } from "react-icons";
import "../styles/Navbar.css";
import { doLogout, getCurrentUserDetail, isLoggedIn } from "../auth";
function Navbar(){
    const navigate = useNavigate();
    const goToPatientPortal = () =>{
        navigate("/patientLogin");
    }
    
    const Appointment = () =>{
        navigate("/bookAppointment");
    }
    const ViewAppointment = () =>{
        navigate("/ViewAppointment");
    }


    const[login,setLogin] = useState(false)
   const [user,setUser]=useState(undefined)

    useEffect(()=>{
        setLogin(isLoggedIn())
        setUser(getCurrentUserDetail())
    },[login])


    const logout = () => {
        doLogout(() => {
            setLogin(false)
            navigate("/")
        })
    }
    return(
        <div className="header">
            <div className="navbar-left">
                <img src={logo} className="images" alt="logo"/>
                <img src={nabh} className="images" alt="logo"/>
                <img src={IGBC} className="images" alt="logo"/>
            </div>
            <div class="navbar-right">
                <div class ="n-list">
                    
                    <ul className="btn-list">
                        {
                            login && (
                                <>
                                    <li>
                                        <button type="button" className="button btn-1" onClick={logout}>
                                            <IconContext.Provider value={{  size:"1em"}}>
                                                <div>
                                                    <FiLogOut />
                                                 </div>
                                            </IconContext.Provider>Logout</button>
                                    </li>

                                    <li>
                                        <button type="button" className="button btn-1" onClick={Appointment}><img src={portal} alt="icon"/>Book Appointment</button>
                                    </li>

                                    <li>
                                        <button type="button" className="button" onClick={ViewAppointment}><img src={portal} alt="icon"/>View My Appointments</button>
                                    </li>
                                    
                                </>
                            )
                        }
                        {
                            !login && (
                                <li>
                                    <button type="button" className="button btn-1" onClick={goToPatientPortal}><img src={portal} alt="icon"/>Patient Login</button>
                                </li>
                            )
                        }
                        
                        <li>
                        `<button className="button" ><img src={contact} alt="icon"/> Contact us</button>
                        </li>
                        
                    </ul>
                </div>
                <div className="nav-section">
                    <ul className="btn-list1">
                        <Link to="/"  style={{textDecoration:"none"}}><li>Home</li></Link>
                        <Link to="/aboutUs" style={{textDecoration:"none"}}><li>About Us</li></Link>
                        <Link to="/" style={{textDecoration:"none"}}><li>Specialities</li></Link>
                        <Link to="/viewDoctors" style={{textDecoration:"none"}}><li>Doctors</li></Link>
                        <Link to="/" style={{textDecoration:"none"}}><li>Facilities</li></Link>
                        <Link to="/" style={{textDecoration:"none"}}><li>Academics</li></Link>
                        <Link to="/" style={{textDecoration:"none"}}><li>Health Library</li></Link>

                    </ul>
            </div>
            </div>
            
        <Outlet /> 
        </div>
    );
}
export default Navbar;

