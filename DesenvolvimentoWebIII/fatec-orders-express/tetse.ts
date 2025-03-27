const clients = [
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

//Define método Get que responde no path /client/:id (para exibir o produto específico)
app.get("/client/:id", (req : Request, res : Response) => {
    const client = clients.find((client) =>{
        return client.id === Number(req.params.id)
    })
    if(!client){
        res.status(404).json("Não foi possível encontrar um produto com o ID");
        return;
    }
    res.status(200).json(client);
});

//Define método Get que responde no path /client (para exibir todos os produtos)
app.get("/client", (req : Request, res : Response) => {
    console.log(req.query);
    res.status(200).json(clients);
});

//Define método Post que responde no path /client/ (para inserir o produto no body)
app.post("/client", (req : Request, res : Response) => {
    const client = req.body;
    clients.push(client);
    res.status(201).send("Produto Cadastrado com sucesso")
});

//Define método Delete que responde no path /client/:id (para excluir o produto com id especificado)
app.delete("/client/:id", (req : Request, res : Response) => {
    const clientId = Number(req.params.id);
    
    const index = clients.findIndex((client) => client.id === clientId)
    
    if(index === -1){
        res.status(404).json("Não foi possível encontrar o produto com ID");
        return;
    }

    const removedclient = clients.splice(index,1)
    res.status(200).json(removedclient);
});

//Define método Put que responde no path /client/:id (para editar o produto com id especificado)
app.put("/client/:id", (req : Request, res : Response) => {
    const clientId = Number(req.params.id);
    
    const index = clients.findIndex((client) => client.id === clientId)

    //Caso não encontre um produto (retorna -1 por padrão da função)
    if(index === -1){
        res.status(404).json("Não foi possível encontrar o produto com ID")
        return;
    }

    const updatedclient = req.body;
    clients[index] = {
        id: clientId,
        name: updatedclient.name,
        brand: updatedclient.brand,
        barCode: updatedclient.barCode,
        supplier: updatedclient.supplier ,
        stockId: updatedclient.stockId,
        price: updatedclient.price,
        weight: updatedclient.weight,
        measureUnit: updatedclient.measureUnit 
    }
    res.status(200).json("Produto atualizado com sucesso");
});