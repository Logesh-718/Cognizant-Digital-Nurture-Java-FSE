import { useState } from "react";

function CurrencyConvertor() {

    const [amount, setAmount] = useState("");
    const [currency, setCurrency] = useState("");

    function handleSubmit() {

        const euro = amount / 90;

        setCurrency(euro.toFixed(2));

        alert("Converting to Euro Amount is " + euro.toFixed(2));
    }

    return (

        <div>

            <h1 style={{ color: "green" }}>
                Currency Convertor!!!
            </h1>

            <label>Amount</label>

            <input
                type="number"
                value={amount}
                onChange={(e) => setAmount(e.target.value)}
            />

            <br /><br />

            <label>Currency</label>

            <input
                type="text"
                value={currency}
                readOnly
            />

            <br /><br />

            <button onClick={handleSubmit}>
                Submit
            </button>

        </div>

    );

}

export default CurrencyConvertor;