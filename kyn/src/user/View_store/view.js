

import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container ,Paper,Button} from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
     
    },
  },
}));

export default function Student() {
    const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
    const[name,setName]=useState('')
    const[address,setAddress]=useState('')
    const[students,setStudents]=useState([])
     const classes = useStyles();

  const handleClick=(e)=>{
    e.preventDefault()
    const student={name,address}
    console.log(student)
    fetch("http://localhost:8080/online/add",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(student)

  }).then(()=>{
    console.log("New Student added")
  })
}

useEffect(()=>{
  fetch("http://localhost:8080/online/getAll")
  .then(res=>res.json())
  .then((result)=>{
    setStudents(result);
  }
)
},[])
  return (

    <Container>
 <center><h1 style={{color:"white"}}>Nearby Stores</h1></center>

    <Paper elevation={3} style={paperStyle}>

      {students.map(student=>(
        <Paper elevation={6} style={{borderRadius:"30px" ,background:"white" ,margin:"12px",padding:"15px", textAlign:"center", backgroundColor:'white'}} key={student.id}>
         <img src="https://media.istockphoto.com/photos/wide-banner-waitress-staff-woman-wearing-protection-face-mask-turning-picture-id1353811407?b=1&k=20&m=1353811407&s=170667a&w=0&h=hWk1oaT4e3TgmtN-cxHeGnK5fuTARMXOwuuosgOcYGU=" width={"500px"} height={"50px"} ></img>
         <h4>Verification ID: {student.id}</h4>
         <h4>Name: {student.name}</h4>
         <h4> Address: {student.address}</h4>

        </Paper>
      ))
}


    </Paper>



    </Container>
  );
}
