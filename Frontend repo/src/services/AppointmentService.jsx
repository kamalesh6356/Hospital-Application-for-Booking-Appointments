import axios from "axios";

const APPOINTMENT_BASE_URL = 'http://localhost:8086';

class AppointmentService{
    

    bookAppointment(appointment){
        return axios.post(APPOINTMENT_BASE_URL+'/appointments',appointment);
    }

    getAppointment()
    {
        return axios.get(APPOINTMENT_BASE_URL+'/appointments/getappointments');
    }
    getAppointmentById(appointmentId)
    {
        return axios.get(APPOINTMENT_BASE_URL+'/appointments/getappointments/'+appointmentId);
    }
    updateAppointment(appointmentId,appointment)
    {
        return axios.put(APPOINTMENT_BASE_URL+'/appointments/updateappointment/'+appointmentId,appointment);
    }
    deleteAppointment(appointmentId)
    {
        return axios.delete(APPOINTMENT_BASE_URL+'/appointments/deleteappointment/'+appointmentId);
 
    }

}

export default new AppointmentService();