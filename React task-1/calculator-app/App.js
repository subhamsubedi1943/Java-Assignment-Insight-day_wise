import React, { useState } from 'react';
import Calculator from './Calculator';
import './App.css';

function App() {
  // State for form inputs
  const [number1, setNumber1] = useState('');
  const [number2, setNumber2] = useState('');
  
  // State to control when to show calculation results
  const [showCalculation, setShowCalculation] = useState(false);

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();
    setShowCalculation(true);
  };

  // Reset form and hide calculations
  const handleReset = () => {
    setNumber1('');
    setNumber2('');
    setShowCalculation(false);
  };

  return (
    <div className="app-container">
      <h1>React Calculator</h1>
      
      <div className="form-container">
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label htmlFor="number1">First Number:   </label>
            <input
              type="number"
              id="number1"
              value={number1}
              onChange={(e) => setNumber1(e.target.value)}
              required
            />
          </div>
          
          <div className="form-group">
            <label htmlFor="number2">Second Number:   </label>
            <input
              type="number"
              id="number2"
              value={number2}
              onChange={(e) => setNumber2(e.target.value)}
              required
            />
          </div>
          
          <div className="button-group">
            <button type="submit">Calculate</button>
            <button type="button" onClick={handleReset}>Reset</button>
          </div>
        </form>
      </div>
      
      {showCalculation && (
        <Calculator 
          number1={parseFloat(number1)} 
          number2={parseFloat(number2)} 
        />
      )}
    </div>
  );
}

export default App;