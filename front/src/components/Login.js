import React, { useState } from 'react';
import './Design.css';

function Login() {
    const [name, setName] = useState('');
    const [pin, setPin] = useState('');

    const hadleNameChange = (e) => {
        setName(e.target.value);
    }
    const handlePinChange = (e) => {
        setPin(e.target.value);
    }

    const handleSubmit = (e) => {
        fetch('http://localhost:8080/user/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ name, pin })    
        })
        // .then(res => res.json())
        .then(data => {
            console.log(data);
            // if (data.status === 'success') {
            //     window.location.href = '/transaction';
            // } else {
            //     alert(data.message);
            // }
        })
        .catch(err => console.log(err));
    }
    
    return (
        <div className='main'>
            <h1>Login</h1>
            <form onSubmit={handleSubmit}>
                <input value={name} onChange={hadleNameChange} type="text" placeholder="Name" required />
                <br />
                <input value={pin} onChange={handlePinChange} type="password" placeholder="Pin" required />
                <br />
                <button type="submit">Login</button>
            </form>
            <a href="/register">Register</a>
        </div>

    );
}

export default Login;