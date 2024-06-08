import logo from './logo.svg';
import './App.css';
import axios from 'axios';
import { useState } from 'react';

function App() {
  const [userId, setUserId] = useState("");
  const [result, setResult] = useState("");
  
  const handleSendUserId = async() => {
    console.log(userId)
    await axios.post("/api/v1/main/get-main", userId, { headers: {'Content-Type': 'application/json'} }
    ).then(({data}) => {
      setResult(data)
    })
  }

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        
        <input type='text' value={userId} onChange={(e)=>setUserId(e.target.value)} />

        <input type='button' value={'보내기'} onClick={handleSendUserId} />

        result: {result}
      </header>
    </div>
  );
}

export default App;
