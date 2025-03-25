import { Request, Response } from "express";

//Importação da biblioteca Express
const express = require('express');

//Criação da aplicação
const app = express();
//Configura a aplicação para receber JSON no body das req
app.use(express.json())

//Produtos
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

app.delete("/product/:id", (req : Request, res : Response) => {
    const product = products.find((product) =>{
        return product.id === Number(req.params.id)
    })

    if(!product){
        res.status(404).json("Não foi possível encontrar o produto com ID");
        return;
    }

    if(removeProduct(product)){
        res.status(200).json(product);
    }
});

app.put("/product/:id", (req : Request, res : Response) => {
    const product = products.find((product) =>{
        return product.id === Number(req.params.id)
    })

    if(!product){
        res.status(404).json("Não foi possível encontrar o produto com ID")
    }

    if(removeProduct(product)){
        const updatedProduct = req.body;
        products.push(updatedProduct)
        res.status(200).json("Produto atualizado com sucesso")
    }
});

function removeProduct(product : any){
    const index = products.indexOf(product)
    return products.splice(index,1)
}

//Cliente

const clients = [
    {
        id: 1,
        name: 'Feijão Carioca',
        document : '123',
        zipCode: '123',
        phone : '123',
        email: 'a@gmail.com'
    },
    {
        id: 2,
        name: 'Arroz',
        document : '123',
        zipCode: '123',
        phone : '123',
        email: 'a@gmail.com'
    },
]

//Define método Get que responde no path /client/:id (para exibir o produto específico)
app.get("/client/:id", (req : Request, res : Response) => {
    const client = clients.find((client) =>{
        return client.id === Number(req.params.id)
    })
    if(!client){
        res.status(404).send();
        return;
    }
    res.status(200).json(client);
});

//Define método Get que responde no path /client (para exibir todos os produtos)
app.get("/client", (req : Request, res : Response) => {
    res.status(200).json(clients);
});

app.post("/client", (req : Request, res : Response) => {
    const client = req.body;
    clients.push(client);
    res.status(201).send("Cliente Cadastrado com sucesso")
});

app.delete("/client/:id", (req : Request, res : Response) => {
    const client = clients.find((client) =>{
        return client.id === Number(req.params.id)
    })

    if(!client){
        res.status(404).json("Não foi possível encontrar o cliente com ID");
        return;
    }

    if(removeclient(client)){
        res.status(200).json(client);
    }
});

app.put("/client/:id", (req : Request, res : Response) => {
    const client = clients.find((client) =>{
        return client.id === Number(req.params.id)
    })

    if(!client){
        res.status(404).json("Não foi possível encontrar o cliente com ID")
    }

    if(removeclient(client)){
        const updatedclient = req.body;
        clients.push(updatedclient)
        res.status(200).json("Cliente atualizado com sucesso")
    }
});


function removeclient(product : any){
    const index = products.indexOf(product)
    return products.splice(index,1)
}

//Inicia apliacação na porta 3000
app.listen(3000, () => {
    console.log("Servidor executando na porta 3000");
});
