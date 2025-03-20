import React, { useState } from 'react';
import MobileDetails from './MobileDetails';
import './App.css';

function App() {
  // Sample mobile phone data
  const [mobiles, setMobiles] = useState([
    { id: 1, model: "iPhone 15 Pro", price: 999, brand: "Apple", storage: "256GB", color: "Titanium" },
    { id: 2, model: "Samsung Galaxy S24", price: 799, brand: "Samsung", storage: "128GB", color: "Phantom Black" },
    { id: 3, model: "Google Pixel 8", price: 699, brand: "Google", storage: "128GB", color: "Obsidian" },
    { id: 4, model: "OnePlus 12", price: 899, brand: "OnePlus", storage: "256GB", color: "Emerald Green" }
  ]);

  return (
    <div className="app-container">
      <h1>Mobile Phone Catalog</h1>
      <div className="mobiles-grid">
        {mobiles.map(mobile => (
          <MobileDetails key={mobile.id} mobile={mobile} />
        ))}
      </div>
    </div>
  );
}

export default App;