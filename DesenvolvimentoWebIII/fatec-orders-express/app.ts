import { Request, Response } from "express";

//Importação da biblioteca Express
const express = require('express');

//Criação da aplicação
const app = express();
//Configura a aplicação para receber JSON no body das req
app.use(express.json())

const products = [
    {
        id: 1,
        name: 'Feijão Carioca',
        brand: 'Broto Legal',
        barCode: '93298432984942',
        supplier: 'Rede de Distribuição Ltda',
        stockId: 98,
        price: 100.99,
        weight: 1,
        measureUnit: 'kg'
    },
    {
        id: 2,
        name: 'Arroz',
        brand: 'Tio João',
        barCode: '34324324242',
        supplier: 'Rede de Distribuição Ltda',
        stockId: 65,
        price: 100.99,
        weight: 500.25,
        measureUnit: 'kg'
    },
]

//Define método Get que responde no path /product/:id (para exibir o produto específico)
app.get("/product/:id", (req : Request, res : Response) => {
    const product = products.find((product) =>{
        return product.id === Number(req.params.id)
    })
    if(!product){
        res.status(404).send();
        return;
    }
    res.status(200).json(product);
});

//Define método Get que responde no path /product (para exibir todos os produtos)
app.get("/product", (req : Request, res : Response) => {
    res.status(200).json(products);
});

app.post("/product", (req : Request, res : Response) => {
    const product = req.body;
    products.push(product);
    res.status(201).send("Produto Cadastrado com sucesso")
});

app.delete("/product:id", (req : Request, res : Response) => {
    const reqId = Number(req.params.id)
    const product = products.filter((product) => {
        product.id === reqId
    })
    if(!product){
        return;
    }

});

//Inicia apliacação na porta 3000
app.listen(3000, () => {
    console.log("Servidor executando na porta 3000");
});
