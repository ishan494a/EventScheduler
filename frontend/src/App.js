import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

function App() {
  // Empty login function placeholder
  const handleLogin = () => {
    window.location.href = "http://localhost:8080/login"
  };

  return (
    <div className="container-fluid">
      <div className="row min-vh-100 align-items-center">
        <div className="col-12 col-md-6 mx-auto">
          <div className="card shadow-lg rounded-4">
            <div className="card-body">
              <h2 className="card-title text-center mb-4">Event Scheduler</h2>
              <p className="text-center mb-4">Log in with your GitHub account to start scheduling events.</p>
              
              <div className="d-flex justify-content-center">
                <button
                  className="btn btn-dark btn-lg btn-block w-100"
                  onClick={handleLogin}
                >
                  Login with GitHub
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
