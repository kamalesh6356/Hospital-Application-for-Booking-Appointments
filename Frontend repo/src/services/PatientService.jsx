import axios from "axios";

const PATIENT_BASE_URL = 'http://localhost:8082';


class PatientService{
    getPatientDetailsById(patientId){
        return axios.get(PATIENT_BASE_URL+`/getPatientbyId/${patientId}`);
    }

    savePatient(patient){
        return axios.post(PATIENT_BASE_URL+`/addPatient`,patient);
    }
}
export default new PatientService();