import axios from "axios";

const DOCTOR_BASE_URL = 'http://localhost:8081';

class DoctorService{
    

    

    getDoctor()
    {
        return axios.get(DOCTOR_BASE_URL+'/doctors/getdoctors');
    }
}
export default new DoctorService();