import { useState } from "react";
import "./Login.css";

const Login = () => {
    const [name, setName] = useState("");
    const [type, setType] = useState("");
    const [description, setDescription] = useState("");
    const [value, setValue] = useState("");

    const handleSubmit = async (event) => {
        event.preventDefault();

        const data = {
            name: name,
            type: type,
            description: description,
            value: value
        };

        try {
            const response = await fetch('http://localhost:8080/coffee', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(data),
            });

            if (response.ok) {
                alert("Dados enviados com sucesso!");
            } else {
                alert("Erro ao enviar os dados.");
            }
        } catch (error) {
            console.error('Erro ao enviar os dados:', error);
            alert("Erro ao enviar os dados.");
        }
    };

    return (
        <div>
            <div className="container">
                <form onSubmit={handleSubmit}>
                    <h1>Sistema de Cadastro</h1>
                    <div>
                        <input type="text" placeholder="Nome do Café"
                            onChange={(e) => setName(e.target.value)} />
                    </div>
                    <div>
                        <input type="text" placeholder="Descrição"
                            onChange={(e) => setDescription(e.target.value)} />
                    </div>
                    <div>
                        <input type="text" placeholder="Valor"
                            onChange={(e) => setValue(e.target.value)} />
                    </div>
                    <div>
                        <input type="text" placeholder="Tipo"
                            onChange={(e) => setType(e.target.value)} />
                    </div>
                    <button type="submit">Registrar no banco</button>
                </form>
            </div>
        </div>
    );
}

export default Login;

