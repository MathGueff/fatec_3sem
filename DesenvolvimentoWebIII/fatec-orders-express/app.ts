import { Request, Response } from "express";
import express from "express"

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
        res.status(404).json("Não foi possível encontrar um produto com o ID");
        return;
    }
    res.status(200).json(product);
});

//Define método Get que responde no path /product (para exibir todos os produtos)
app.get("/product", (req : Request, res : Response) => {
    console.log(req.query);
    res.status(200).json(products);
});

//Define método Post que responde no path /product/ (para inserir o produto no body)
app.post("/product", (req : Request, res : Response) => {
    const product = req.body;
    products.push(product);
    res.status(201).send("Produto Cadastrado com sucesso")
});

//Define método Delete que responde no path /product/:id (para excluir o produto com id especificado)
app.delete("/product/:id", (req : Request, res : Response) => {
    const productId = Number(req.params.id);
    
    const index = products.findIndex((product) => product.id === productId)
    
    if(index === -1){
        res.status(404).json("Não foi possível encontrar o produto com ID");
        return;
    }

    const removedProduct = products.splice(index,1)
    res.status(200).json(removedProduct);
});

//Define método Put que responde no path /product/:id (para editar o produto com id especificado)
app.put("/product/:id", (req : Request, res : Response) => {
    const productId = Number(req.params.id);
    
    const index = products.findIndex((product) => product.id === productId)

    //Caso não encontre um produto (retorna -1 por padrão da função)
    if(index === -1){
        res.status(404).json("Não foi possível encontrar o produto com ID")
        return;
    }

    const updatedProduct = req.body;
    products[index] = {
        id: productId,
        name: updatedProduct.name,
        brand: updatedProduct.brand,
        barCode: updatedProduct.barCode,
        supplier: updatedProduct.supplier ,
        stockId: updatedProduct.stockId,
        price: updatedProduct.price,
        weight: updatedProduct.weight,
        measureUnit: updatedProduct.measureUnit 
    }
    res.status(200).json("Produto atualizado com sucesso");
});

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
        res.status(404).json("Não foi possível encontrar um cliente com esse ID");
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
    const clientId = Number(req.params.id);
    
    const index = clients.findIndex((client) => client.id === clientId)

    if(index === -1){
        res.status(404).json("Não foi possível encontrar o cliente com ID");
        return;
    }

    const removedClient = clients.splice(index,1)
    res.status(200).json(removedClient);
});

app.put("/client/:id", (req : Request, res : Response) => {
    const clientId = Number(req.params.id);
    
    const index = clients.findIndex((client) => client.id === clientId)

    //Caso não encontre um cliente (retorna -1 por padrão da função)
    if(index === -1){
        res.status(404).json("Não foi possível encontrar o cliente com ID")
        return;
    }

    const updatedClient = req.body;
    clients[index] = {
        id : clientId,
        name : updatedClient.name,
        document : updatedClient.document,
        zipCode : updatedClient.zipCode,
        phone :updatedClient.phone,
        email :updatedClient.email,
    }
    res.status(200).json("Cliente atualizado com sucesso");
});

//Inicia apliacação na porta 3000
app.listen(3000, () => {
    console.log("Servidor executando na porta 3000");
});
