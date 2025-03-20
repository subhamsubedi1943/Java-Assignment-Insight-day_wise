import React from 'react';
import './Calculator.css';

function Calculator({ number1, number2 }) {
  // Calculate results
  const sum = number1 + number2;
  const difference = number1 - number2;
  const product = number1 * number2;

  return (
    <div className="calculator-container">
      <h2>Calculation Results</h2>
      
      <div className="result-card">
        <div className="result-item">
          <span className="operation">Sum:</span>
          <span className="result-value">{number1} + {number2} = {sum}</span>
        </div>
        
        <div className="result-item">
          <span className="operation">Difference:</span>
          <span className="result-value">{number1} - {number2} = {difference}</span>
        </div>
        
        <div className="result-item">
          <span className="operation">Product:</span>
          <span className="result-value">{number1} × {number2} = {product}</span>
        </div>
      </div>
      
      <div className="input-summary">
        <p>You entered: {number1} and {number2}</p>
      </div>
    </div>
  );
}

export default Calculator;