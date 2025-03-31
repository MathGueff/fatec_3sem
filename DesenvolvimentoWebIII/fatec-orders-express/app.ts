import { Request, Response } from "express";
import express from "express"

//Criação da aplicação
const app = express();

//Configura a aplicação para receber JSON no body das req
app.use(express.json())

const port = 3000;

//#region Produtos
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
        res.status(404).json({
            "error": true,
            "message" : "Não foi possível encontrar um produto com esse ID"
        });
        return;
    }
    res.status(200).json(product);
});

//Define método Get que responde no path /product (para exibir todos os produtos)
app.get("/product", (req : Request, res : Response) => {
    let filteredProduct : any = [];

    //Retorna o array inteiro caso nenhum query param seja passado
    if(Object.keys(req.query).length === 0){
        res.status(200).json(products);
        return;
    }

    //Fazendo a filtragem com todos os filtros existentes (ao mesmo tempo, para evitar sobrescrita entre os filtros)
    filteredProduct = products.filter((product) => {
        let isValid : boolean = true;
        if(typeof(req.query.name) == "string"){
            const nameFilter = req.query.name.trim().toLowerCase(); 
            isValid = isValid && product.name.trim().toLowerCase().includes(nameFilter);
        }
        if(typeof(req.query.brand) == "string"){
            const brandFilter = req.query.brand.trim().toLowerCase(); 
            isValid = isValid && product.brand.trim().toLowerCase().includes(brandFilter) ;
        }
        if(typeof(req.query.supplier) == "string"){
            const supplierFilter = req.query.supplier.trim().toLowerCase(); 
            isValid = isValid && product.supplier.trim().toLowerCase().includes(supplierFilter);
        }
        if(typeof(req.query.stockId) == "string"){
            const stockyIdFilter = Number(req.query.stockId);
            isValid = isValid && product.stockId == stockyIdFilter;
        }
        return isValid;
    })

    //Caso nenhum produto seja encontrado com os filtros passados, retorna 404
    if(filteredProduct.length === 0){
        res.status(404).json({
            "error" : true,
            "message" : "Não foi possível encontrar nenhum produto com o filtro"
        })
        return;
    }

    //Retorna o array filtrado
    res.status(200).json(filteredProduct)
});

//Define método Post que responde no path /product/ (para inserir o produto no body)
app.post("/product", (req : Request, res : Response) => {
    const newProduct = req.body;
    //Verificando se no array há um produto com o id igual ao do novo produto
    const existProduct = products.find((product) => product.id === Number(newProduct.id));
    if(existProduct){
        res.status(409).json({
            "error" : true,
            "message" : "Um produto cadastrado com o ID já existe"
        })
        return
    }
    products.push(newProduct);
    res.status(201).json({
        "message" : "Cadastrado com sucesso",
        "product" : newProduct
    })
});

//Define método Delete que responde no path /product/:id (para excluir o produto com id especificado)
app.delete("/product/:id", (req : Request, res : Response) => {
    const productId = Number(req.params.id);
    
    const index = products.findIndex((product) => product.id === productId)
    
    if(index === -1){
        res.status(404).json({
            "error": true,
            "message" : "Não foi possível encontrar um produto com esse ID"
        });
        return;
    }

    const removedProduct = products.splice(index,1)
    res.status(200).json({
        "message" : "Produto excluído com sucesso", 
        "product" : removedProduct
    });
});

//Define método Put que responde no path /product/:id (para editar o produto com id especificado)
app.put("/product/:id", (req : Request, res : Response) => {
    const productId = Number(req.params.id);
    
    const index = products.findIndex((product) => product.id === productId)

    //Caso não encontre um produto (retorna -1 por padrão da função)
    if(index === -1){
        res.status(404).json({
            "error": true,
            "message" : "Não foi possível encontrar um produto com esse ID"
        });
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
    res.status(200).json({
        "message" : "Produto atualizado com sucesso",
        "product" : products[index]
    });
});
//#endregion
//#region Cliente

const clients = [
    {
        id: 1,
        name: 'José Alberto',
        document : '1234',
        zipCode: '123',
        phone : '123',
        email: 'a@gmail.com'
    },
    {
        id: 2,
        name: 'Ruarez Francisco',
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
        res.status(404).json({
            "error": true,
            "message" : "Não foi possível encontrar um cliente com esse ID"
        });
        return;
    }
    res.status(200).json(client);
});

//Define método Get que responde no path /client (para exibir todos os produtos)
app.get("/client", (req : Request, res : Response) => {
    let filteredClient : any = [];

    if(Object.keys(req.query).length === 0){
        res.status(200).json(clients);
        return;
    }

    filteredClient = clients.filter((client) => {
        let isValid : boolean = true;
        if(typeof(req.query.name) == "string"){
            const nameFilter = req.query.name.trim().toLowerCase(); 
            isValid = isValid && client.name.trim().toLowerCase().includes(nameFilter);
        }
        if(typeof(req.query.document) == "string"){
            const documentFilter = req.query.document.trim().toLowerCase(); 
            isValid = isValid && client.document.trim().toLowerCase().includes(documentFilter) ;
        }
        return isValid;
    })

    if(filteredClient.length === 0){
        res.status(404).json({
            "error" : true,
            "message" : "Não foi possível encontrar nenhum produto com o filtro",
        })
        return;
    }

    res.status(200).json(filteredClient)
});

app.post("/client", (req : Request, res : Response) => {
    const newClient = req.body;
    const clintExists = clients.find((client) => client.id === Number(newClient.id))

    if(clintExists){
        res.status(409).json({
            "error" : true,
            "message" : "Já existe um cliente com o ID "
        })
        return
    }
    clients.push(newClient);
    res.status(201).json({"message" : "Cliente Cadastrado com sucesso"})
});

app.delete("/client/:id", (req : Request, res : Response) => {
    const clientId = Number(req.params.id);
    
    const index = clients.findIndex((client) => client.id === clientId)

    if(index === -1){
        res.status(404).json({
            "error": true,
            "message" : "Não foi possível encontrar um cliente com esse ID"
        });
        return;
    }

    const removedClient = clients.splice(index,1)
    res.status(200).json({
        "message" : "Cliente removido com sucesso",
        "client" : removedClient
    });
});

app.put("/client/:id", (req : Request, res : Response) => {
    const clientId = Number(req.params.id);
    
    const index = clients.findIndex((client) => client.id === clientId)

    //Caso não encontre um cliente (retorna -1 por padrão da função)
    if(index === -1){
        res.status(404).json({
            "error": true,
            "message" : "Não foi possível encontrar um cliente com esse ID"
        });
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
    res.status(200).json({
        "message" : "Cliente atualizado com sucesso",
        "client" : clients[index]
    });
});
//#endregion
//#region Funcionário
const employees = [
    {
        id: 1,
        name: 'Ricardo Sênior',
        document : '123',
        position: 'Gerente',
        workingHours : 8,
        salary: 12.00,
        zipCode: '123'
    },
    {
        id: 2,
        name: 'Ricardo Junior',
        document : '122',
        position: 'Estagiário',
        workingHours : 40,
        salary: 1.00,
        zipCode: '321'
    },
]

//Define método Get que responde no path /employee/:id (para exibir o produto específico)
app.get("/employee/:id", (req : Request, res : Response) => {
    const employee = employees.find((employee) =>{
        return employee.id === Number(req.params.id)
    })
    if(!employee){
        res.status(404).json({
            "error": true,
            "message" : "Não foi possível encontrar um funcionário com esse ID"
        });
        return;
    }
    res.status(200).json(employee);
});

//Define método Get que responde no path /employee (para exibir todos os produtos)
app.get("/employee", (req : Request, res : Response) => {
    let filteredEmployee : any = [];

    //Retorna o array inteiro caso nenhum query param seja passado
    if(Object.keys(req.query).length === 0){
        res.status(200).json(employees);
        return;
    }

    filteredEmployee = employees.filter((employee) => {
        let isValid : boolean = true;
        if(typeof(req.query.name) == "string"){
            const nameFilter = req.query.name.trim().toLowerCase(); 
            isValid = isValid && employee.name.trim().toLowerCase().includes(nameFilter);
        }
        if(typeof(req.query.position) == "string"){
            const positionFilter = req.query.position.trim().toLowerCase(); 
            isValid = isValid && employee.position.trim().toLowerCase().includes(positionFilter) ;
        }
        if(typeof(req.query.workingHours) == "string"){
            const workingHoursFilter = Number(req.query.workingHours); 
            isValid = isValid && employee.workingHours == workingHoursFilter;
        }
        return isValid;
    })

    if(filteredEmployee.length === 0){
        res.status(404).json({
            "error" : true,
            "message" : "Não foi possível encontrar nenhum produto com o filtro",
        })
        return;
    }

    res.status(200).json(filteredEmployee)
});

app.post("/employee", (req : Request, res : Response) => {
    const newEmployee = req.body;
    const employeeExists = employees.find((employee) => employee.id === Number(newEmployee.id))
    if(employeeExists){
        res.status(409).json({
            "error" : true,
            "message" : "Já existe um funcionário com o ID"
        })
        return;
    }
    employees.push(newEmployee);
    res.status(201).json({"message" : "Funcionário Cadastrado com sucesso"})
});

app.delete("/employee/:id", (req : Request, res : Response) => {
    const employeeId = Number(req.params.id);
    
    const index = employees.findIndex((employee) => employee.id === employeeId)

    if(index === -1){
        res.status(404).json({
            "error": true,
            "message" : "Não foi possível encontrar um funcionário com esse ID"
        });
        return;
    }

    const removedEmployee = employees.splice(index,1)
    res.status(200).json({
        "message" : "Funcionário removido com sucesso",
        "employee" : removedEmployee
    });
});

app.put("/employee/:id", (req : Request, res : Response) => {
    const employeeId = Number(req.params.id);
    
    const index = employees.findIndex((employee) => employee.id === employeeId)

    //Caso não encontre um funcionário (retorna -1 por padrão da função)
    if(index === -1){
        res.status(404).json({
            "error": true,
            "message" : "Não foi possível encontrar um funcionário com esse ID"
        });
        return;
    }

    const updatedemployee = req.body;
    employees[index] = {
        id: employeeId,
        name: updatedemployee.name,
        document : updatedemployee.document,
        position: updatedemployee.position,
        workingHours : updatedemployee.workingHours,
        salary: updatedemployee.salary,
        zipCode: updatedemployee.zipCode
    }
    res.status(200).json({
        "message" : "Funcionário atualizado com sucesso",
        "employee" : employees[index]
    });
});
//#endregion

//Inicia aplicacação na porta 3000
app.listen(port, () => {
    console.log(`Servidor executando na porta ${port}`);
});
