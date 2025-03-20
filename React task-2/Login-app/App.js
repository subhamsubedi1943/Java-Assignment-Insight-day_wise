import React, {useState} from 'react';

export default function LoginForm(){
  const[id, setId]=useState('');
  const[password,setPassword]=useState('');

  const handleIdChange=(e)=>{
    setId(e.target.value);
  }
  const handlePasswordChange=(e)=>{
    setPassword(e.target.value);
  }
  const handleSubmit=(e)=>{
    e.preventDefault();
    if(id==='admin' && password==='admin'){
      alert('Login Success');}
      else{
        alert('Login Failed');
      }
  }
  return(
    <form onSubmit={handleSubmit}>
      <label>Id:</label>
      <input type="text" value={id} onChange={handleIdChange}/>
      <label>Password:</label>
      <input type="password" value={password} onChange={handlePasswordChange}/>
      <button type="submit">Submit</button>
    </form>
  );
}