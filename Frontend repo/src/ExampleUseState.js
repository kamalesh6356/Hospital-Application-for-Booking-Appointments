import { useState } from "react"
import axios from "axios";

  const ExampleHooks= ()=>
  {
    const [data,setdata]= useState({email,password});
    const Handler=(event)=>{
        setdata(event.target.value);

    }
    const fetchData=()=>
    {
        axios.post("/api/login").then()
    }


    return(
        <div>
            <label>Email</label>
            <input type="email" value={data} onChange={Handler}></input>
            <label>password</label>
            <input type="password" value={data} onChange={Handler}></input>
            

        </div>
    )
  };
  export ExampleHooks;

  List<String> arr1= new List<>();
  arr1.add("kamlesh");


  int arr1[]=[5,4,6,3,2];
  
  for(int i=0;i<arr1.length();i++)
  {

  if(arr1[i]>arr[i+1])
  {
    int temp=arr1[i];
   arr1[i+1]=arr1[i];
   arr1[i]=temp;

  }

  SOP(arr1[i]);

  int a=10,b=20;
  a=a+b;
  b=a-b;
  a=a-b;
  
  }