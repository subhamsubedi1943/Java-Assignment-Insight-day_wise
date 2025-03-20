import React from 'react';
import './MobileDetails.css';

function MobileDetails({ mobile }) {
  return (
    <div className="mobile-card">
      <h2>{mobile.brand} {mobile.model}</h2>
      <div className="mobile-details">
        <p><strong>ID:</strong> {mobile.id}</p>
        <p><strong>Price:</strong> ${mobile.price}</p>
        <p><strong>Storage:</strong> {mobile.storage}</p>
        <p><strong>Color:</strong> {mobile.color}</p>
      </div>
    </div>
  );
}

export default MobileDetails;