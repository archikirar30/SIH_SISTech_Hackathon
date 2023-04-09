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
  if(document.getElementById('outlined-basic').checked)
        document.getElementById('texto').innerHTML = "Store Added";
    else
        document.getElementById('texto').innerHTML = "Store Added";
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
      <center><h1 style={{color:"white"}}>Add Stores</h1></center>
        <Paper elevation={3} style={paperStyle}>
            

    <form className={classes.root} noValidate autoComplete="off">
    
      <TextField id="outlined-basic" label="Store Name" variant="outlined" fullWidth 
      value={name}
      onChange={(e)=>setName(e.target.value)}
      />
      <TextField id="outlined-basic" label="Store Address" variant="outlined" fullWidth
      value={address}
      onChange={(e)=>setAddress(e.target.value)}
      />
      <Button variant="contained" color="secondary" style={{background:"green"}} onClick={handleClick}>
  Submit
</Button>
<p style={{marginLeft:"-112px", marginTop:"-49px", fontSize:"small" ,color:"red"}} id="texto"></p>
    </form>
    </Paper>
    </Container>
  );
}
