import React, { useState } from 'react';

export default function SignupForm(){
  const [customerId, setCustomerId] = useState('');
  const [name, setName]= useState('');
  const [email, setEmail] = useState('');
  const [gender, setGender] = useState('');
  const [city, setCity] = useState('');
  const [state, setState] = useState('');
  const [review, setReview] = useState(false);
  
  const handleSubmit = (e) => {
    e.preventDefault();
    setReview(true);
};
return (
  <div>
    <form onSubmit={handleSubmit}>
      <div>
        <label>Customer ID:</label>
        <input type="text" value={customerId} onChange={(e) => setCustomerId(e.target.value)} />
      </div>
      <div>
        <label>Name:</label>
        <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
      </div>
      <div>
        <label>Email:</label>
        <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
      </div>
      <div>
        <label>Gender:</label>
        <select value={gender} onChange={(e) => setGender(e.target.value)}>
          <option value="">Select Gender</option>
          <option value="Male">Male</option>
          <option value="Female">Female</option>
          <option value="Other">Other</option>
        </select>
      </div>
      <div>
        <label>City:</label>
        <select value={city} onChange={(e) => setCity(e.target.value)}>
          <option value="">Select City</option>
          <option value="Hyderabad">Hyderabad</option>
          <option value="Chennai">Chennai</option>
          <option value="Pune">Pune</option>
        </select>
      </div>
      <button type="submit">Review</button>
      </form>

      {review && (
        <div>
          <h2>Review Details</h2>
          <p>Customer ID: {customerId}</p>
          <p>Name: {name}</p>
          <p>Email: {email}</p>
          <p>Gender: {gender}</p>
          <p>City: {city}</p>
        </div>
      )}
    </div>
  );
}