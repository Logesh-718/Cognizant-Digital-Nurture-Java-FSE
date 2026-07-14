import { useState } from "react";
import CurrencyConvertor from "./Components/CurrencyConvertor";

function App() {

    const [count, setCount] = useState(0);

    function increment() {

        setCount(count + 1);

    }

    function decrement() {

        setCount(count - 1);

    }

    function sayHello() {

        alert("Hello! Static Message");

    }

    function increase() {

        increment();

        sayHello();

    }

    function welcome(message) {

        alert(message);

    }

    function onPress() {

        alert("I was clicked");

    }

    return (

        <div style={{ padding: "20px" }}>

            <h2>{count}</h2>

            <button onClick={increase}>
                Increment
            </button>

            <br /><br />

            <button onClick={decrement}>
                Decrement
            </button>

            <br /><br />

            <button onClick={() => welcome("Welcome")}>
                Say Welcome
            </button>

            <br /><br />

            <button onClick={onPress}>
                Click on me
            </button>

            <br /><br />

            <CurrencyConvertor />

        </div>

    );

}

export default App;