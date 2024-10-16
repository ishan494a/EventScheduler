import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom'; // Import useNavigate for navigation
import './Dashboard.css'; // Import your CSS for styling

const Dashboard = () => {
  const navigate = useNavigate(); // Initialize useNavigate hook
  const [userSession, setUserSession] = useState(JSON.parse(localStorage.getItem("userSession")));

  const handleLogout = () => {
    localStorage.removeItem("userSession");
    navigate("/"); // Redirect to login page after logout
  };

  return (
    <div className="container">
      <div className="header">
        <h1 className="text">Welcome to the Dashboard!</h1>
        {userSession && <p>Hello, {userSession.email}</p>}
        <div className="underline"></div>
      </div>
      
      <button className="submit logout-button" onClick={handleLogout}>
        Logout
      </button>
    </div>
  );
};

export default Dashboard;
