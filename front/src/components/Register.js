import React, { useState } from 'react';
import './Design.css';

function Register() {
    const [name, setName] = useState('');
    const [pin, setPin] = useState('');
    const [deposit, setDeposit] = useState(0);

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(name, pin, deposit);
    }
    const hadleNameChange = (e) => {
        setName(e.target.value);
    }
    const handlePinChange = (e) => {
        setPin(e.target.value);
    }
    const handleDepositChange = (e) => {
        setDeposit(e.target.value);
    }

    return (
        <div className='main'>
            <h1>Register</h1>
            <form onSubmit={handleSubmit}>
                <input value={name} onChange={hadleNameChange} type="text" placeholder="Name" required />
                <br />
                <input value={pin} onChange={handlePinChange} type="password" placeholder="Pin" required />
                <br />
                <input value={deposit} onChange={handleDepositChange} type='number' deposit="Deposit" required />
                <br />
                <button type="submit">Register</button>
            </form>
        </div>
    );
}

export default Register;