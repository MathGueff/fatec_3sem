//Importação da biblioteca Express
const express = require('express');

//Criação da aplicação
const app = express();

//Define método Get que responde no path /
app.get("/", (req, res) => {
    //Responde requisição com "Hello World"
    res.send("Hello World");
});

//Define método Post que responde no path /
app.post("/", (req, res) => {
    res.send("Hello World Again")
});

//Inicia apliacação na porta 3000
app.listen(3000, () => {
    console.log("Servidor executando na porta 3000");
});