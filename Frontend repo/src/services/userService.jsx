import { myAxios } from "./helper";

export const register = (user) =>{
    return myAxios.post('/registerNewUser',user).then((response) => response.data)
}

export const loginUser =(loginDetail) => {
    return myAxios.post('/authenticate',loginDetail).then((response)=>response.data)
}

