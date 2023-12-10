import React, { useState } from 'react';
import './Design.css';

function Transaction () {
    const [receiver, setReceiver] = useState('');
    const [amount, setAmount] = useState(0);

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(receiver, amount);
    }
    const handelReceiverChange = (e) => {
        setReceiver(e.target.value);
    }
    const handleAmountChange = (e) => {
        setAmount(e.target.value);
    }

    return (
        <div className="main">
            <h1>Transaction</h1>
            <form onSubmit={handleSubmit}>
                <input value={receiver} onChange={handelReceiverChange} type="text" placeholder="Receiver" required />
                <br />
                <input value={amount} onChange={handleAmountChange} type="number" placeholder="Amount" required />
                <br />
                <button type="submit">Transfer</button>
            </form>
        </div>
    );
}

export default Transaction;