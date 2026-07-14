function ListofPlayers() {

    const players = [
        { name: "Virat", score: 95 },
        { name: "Rohit", score: 88 },
        { name: "Gill", score: 65 },
        { name: "Rahul", score: 72 },
        { name: "Pant", score: 68 },
        { name: "Hardik", score: 80 },
        { name: "Jadeja", score: 55 },
        { name: "Ashwin", score: 76 },
        { name: "Shami", score: 60 },
        { name: "Bumrah", score: 90 },
        { name: "Siraj", score: 50 }
    ];

    const lowScorePlayers = players.filter(player => player.score < 70);

    return (
        <div>
            <h2>List of Players</h2>

            <table border="1" cellPadding="8">
                <thead>
                    <tr>
                        <th>Player Name</th>
                        <th>Score</th>
                    </tr>
                </thead>

                <tbody>
                    {
                        players.map((player, index) => (
                            <tr key={index}>
                                <td>{player.name}</td>
                                <td>{player.score}</td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>

            <br />

            <h2>Players with Score Below 70</h2>

            <ul>
                {
                    lowScorePlayers.map((player, index) => (
                        <li key={index}>
                            {player.name} - {player.score}
                        </li>
                    ))
                }
            </ul>
        </div>
    );
}

export default ListofPlayers;