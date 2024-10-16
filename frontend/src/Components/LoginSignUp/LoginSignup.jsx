import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './LoginSignup.css';
import email_icon from '../Assets/email.png';
import password_icon from '../Assets/password.png';
import axios from 'axios';

const LoginSignup = () => {
  const navigate = useNavigate();
  const [action, setAction] = useState("Sign Up");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [error, setError] = useState("");
  const [successMessage, setSuccessMessage] = useState("");

  function handleLogin() {
    const url = "http://localhost:8080/api/auth/login";
    const userData = {
      email: email,
      password: password,
    };

    axios.post(url, userData)
      .then(res => {
        setSuccessMessage("Successfully logged in!");
        setError(""); 
        localStorage.setItem("userSession", JSON.stringify(res.data));
        navigate('/dashboard'); 
      })
      .catch(e => {
        console.error(e);
        if (e.response) {
          setError(e.response.data);
        } else {
          setError("An error occurred. Please try again.");
        }
      });
  }

  function handleSignup() {
    const url = "http://localhost:8080/api/auth/register";
    const userData = {
      email: email,
      password: password,
    };

    axios.post(url, userData)
      .then(res => {
        console.log(res.data);
        setSuccessMessage("Successfully registered!");
        setError(""); 
      })
      .catch(e => {
        console.error(e);
        if (e.response) {
          setError(e.response.data);
        } else {
          setError("An error occurred. Please try again.");
        }
      });
  }

  const handleSubmit = async () => {
    setSuccessMessage(""); 
    if (action === "Sign Up" && password !== confirmPassword) {
      setError("Passwords do not match!");
    } else {
      setError("");
      if (action === "Login") {
        handleLogin();
      } else {
        handleSignup();
      }
    }
  };

  return (
    <div>
      <div className='container'>
        <div className='header'>
          <div className='text'>{action}</div>
          <div className='underline'></div>
        </div>
        <div className='submit-container top'>
          <div
            className={action === "Login" ? "submit gray" : "submit"}
            onClick={() => setAction("Sign Up")}
          >
            Sign Up
          </div>
          <div
            className={action === "Sign Up" ? "submit gray" : "submit"}
            onClick={() => setAction("Login")}
          >
            Login
          </div>
        </div>
        <div className='inputs'>
          <div className='input'>
            <img src={email_icon} alt="" />
            <input
              type="email"
              placeholder="Email ID"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
          </div>
          <div className='input'>
            <img src={password_icon} alt="" />
            <input
              type="password"
              placeholder="Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </div>
          {action === "Sign Up" && (
            <div className='input'>
              <img src={password_icon} alt="" />
              <input
                type="password"
                placeholder="Confirm Password"
                value={confirmPassword}
                onChange={(e) => setConfirmPassword(e.target.value)}
              />
            </div>
          )}
        </div>
        {error && <div className='error-message'>{error}</div>}
        {successMessage && <div className='success-message'>{successMessage}</div>}
        {action === "Login" && (
          <div className="forgot-password">Forgot Password?</div>
        )}
        <div className='submit' onClick={handleSubmit}>
          Submit
        </div>
      </div>
    </div>
  );
}

export default LoginSignup;
