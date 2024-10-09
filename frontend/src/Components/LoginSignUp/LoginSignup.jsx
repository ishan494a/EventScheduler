import React, { useState } from 'react'
import './LoginSignUp.css'
import user_icon from '../Assets/person.png'
import email_icon from '../Assets/email.png'
import password_icon from '../Assets/password.png'

const LoginSignup = () => {
  const [action, setAction] = useState("Sign Up");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [error, setError] = useState("");

  function handleLogin(){
    const userData = {email, password};
    fetch('http://localhost:8080/api/auth/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(userData),
    }
    )
    .then(response => {
      if (response.ok) {
        return response.json();
      }
      throw new Error('Login failed');
    })
    .then(data => {
      console.log("User Logged in successfully:", data);
      // Handle successful signup (e.g., redirect, show success message)
    })
    .catch(error => {
      console.error("Signup error:", error);
    });
  } 
  function handleSignup(){
    const userData = {email, password};
    
    // Send POST request to backend
    fetch('http://localhost:8080/api/auth/register', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(userData),
    })
    .then(response => {
      if (response.ok) {
        return response.json();
      }
      throw new Error('Signup failed');
    })
    .then(data => {
      console.log("User signed up successfully:", data);
      // Handle successful signup (e.g., redirect, show success message)
    })
    .catch(error => {
      console.error("Signup error:", error);
    });
  }
  
  const handleSubmit = async () => {
    if (action === "Sign Up" && password !== confirmPassword) {
      setError("Passwords do not match!");
      console.log({ email, password });
    } else {
      setError("");
      if(action === "Login"){
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
        {/* Sign Up and Login buttons moved to the top, under the underline */}
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
          {/* Show Confirm Password only if the action is Sign Up */}
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
        {/* Conditionally show Forgot Password link only in Login mode */}
        {action === "Login" && (
          <div className="forgot-password">Forgot Password?</div>
        )}
        {/* Submit button moved below the inputs and Forgot Password */}
        <div className='submit' onClick={handleSubmit}>
          Submit
        </div>
      </div>
    </div>
  )
}

export default LoginSignup;
