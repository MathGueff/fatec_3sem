import { Request, Response } from "express";
import express from "express"
import { IProductListFilters } from "./IProduct";

//Criação da aplicação
const app = express();

//Configura a aplicação para receber JSON no body das req
app.use(express.json())

const port = 3000;

//#region Cliente

const clients = [
    {
        id: 1,
        name: 'José Alberto',
        document: '1234',
        zipCode: '123',
        phone: '123',
        email: 'a@gmail.com'
    },
    {
        id: 2,
        name: 'Ruarez Francisco',
        document: '123',
        zipCode: '123',
        phone: '123',
        email: 'a@gmail.com'
    },
]

//Define método Get que responde no path /client/:id (para exibir o produto específico)
app.get("/client/:id", (req: Request, res: Response) => {
    const client = clients.find((client) => {
        return client.id === Number(req.params.id)
    })
    if (!client) {
        res.status(404).json({
            "error": true,
            "message": "Não foi possível encontrar um cliente com esse ID"
        });
        return;
    }
    res.status(200).json(client);
});

//Define método Get que responde no path /client (para exibir todos os produtos)
app.get("/client", (req: Request, res: Response) => {
    let filteredClient: any = [];

    if (Object.keys(req.query).length === 0) {
        res.status(200).json(clients);
        return;
    }

    const { name, document } = req.query

    filteredClient = clients.filter((client) => {
        let isValid: boolean = true;
        if (typeof (name) == "string") {
            const nameFilter = name.trim().toLowerCase();
            isValid = isValid && client.name.trim().toLowerCase().includes(nameFilter);
        }
        if (typeof (document) == "string") {
            const documentFilter = document.trim().toLowerCase();
            isValid = isValid && client.document.trim().toLowerCase().includes(documentFilter);
        }
        return isValid;
    })

    if (filteredClient.length === 0) {
        res.status(404).json({
            "error": true,
            "message": "Não foi possível encontrar nenhum produto com o filtro",
        })
        return;
    }

    res.status(200).json(filteredClient)
});

app.post("/client", (req: Request, res: Response) => {
    const newClient = req.body;
    const clintExists = clients.find((client) => client.id === Number(newClient.id))

    if (clintExists) {
        res.status(409).json({
            "error": true,
            "message": "Já existe um cliente com o ID "
        })
        return
    }
    clients.push(newClient);
    res.status(201).json({ "message": "Cliente Cadastrado com sucesso" })
});

app.delete("/client/:id", (req: Request, res: Response) => {
    const clientId = Number(req.params.id);

    const index = clients.findIndex((client) => client.id === clientId)

    if (index === -1) {
        res.status(404).json({
            "error": true,
            "message": "Não foi possível encontrar um cliente com esse ID"
        });
        return;
    }

    const removedClient = clients.splice(index, 1)
    res.status(200).json({
        "message": "Cliente removido com sucesso",
        "client": removedClient
    });
});

app.put("/client/:id", (req: Request, res: Response) => {
    const clientId = Number(req.params.id);

    const index = clients.findIndex((client) => client.id === clientId)

    //Caso não encontre um cliente (retorna -1 por padrão da função)
    if (index === -1) {
        res.status(404).json({
            "error": true,
            "message": "Não foi possível encontrar um cliente com esse ID"
        });
        return;
    }

    const { name, document, zipCode, phone, email } = req.body
    const updatedClient = { name, document, zipCode, phone, email };
    clients[index] = {
        id: clientId,
        ...updatedClient
    }
    res.status(200).json({
        "message": "Cliente atualizado com sucesso",
        "client": clients[index]
    });
});
//#endregion
//#region Funcionário
const employees = [
    {
        id: 1,
        name: 'Ricardo Sênior',
        document: '123',
        position: 'Gerente',
        workingHours: 8,
        salary: 12.00,
        zipCode: '123'
    },
    {
        id: 2,
        name: 'Ricardo Junior',
        document: '122',
        position: 'Estagiário',
        workingHours: 40,
        salary: 1.00,
        zipCode: '321'
    },
]

//Define método Get que responde no path /employee/:id (para exibir o produto específico)
app.get("/employee/:id", (req: Request, res: Response) => {
    const employee = employees.find((employee) => {
        return employee.id === Number(req.params.id)
    })
    if (!employee) {
        res.status(404).json({
            "error": true,
            "message": "Não foi possível encontrar um funcionário com esse ID"
        });
        return;
    }
    res.status(200).json(employee);
});

//Define método Get que responde no path /employee (para exibir todos os produtos)
app.get("/employee", (req: Request, res: Response) => {
    let filteredEmployee: any = [];

    //Retorna o array inteiro caso nenhum query param seja passado
    if (Object.keys(req.query).length === 0) {
        res.status(200).json(employees);
        return;
    }

    const { name, position, workingHours } = req.query

    filteredEmployee = employees.filter((employee) => {
        let isValid: boolean = true;
        if (typeof (name) == "string") {
            const nameFilter = name.trim().toLowerCase();
            isValid = isValid && employee.name.trim().toLowerCase().includes(nameFilter);
        }
        if (typeof (position) == "string") {
            const positionFilter = position.trim().toLowerCase();
            isValid = isValid && employee.position.trim().toLowerCase().includes(positionFilter);
        }
        if (typeof (workingHours) == "string") {
            const workingHoursFilter = Number(workingHours);
            isValid = isValid && employee.workingHours == workingHoursFilter;
        }
        return isValid;
    })

    if (filteredEmployee.length === 0) {
        res.status(404).json({
            "error": true,
            "message": "Não foi possível encontrar nenhum produto com o filtro",
        })
        return;
    }

    res.status(200).json(filteredEmployee)
});

app.post("/employee", (req: Request, res: Response) => {
    const newEmployee = req.body;
    const employeeExists = employees.find((employee) => employee.id === Number(newEmployee.id))
    if (employeeExists) {
        res.status(409).json({
            "error": true,
            "message": "Já existe um funcionário com o ID"
        })
        return;
    }
    employees.push(newEmployee);
    res.status(201).json({ "message": "Funcionário Cadastrado com sucesso" })
});

app.delete("/employee/:id", (req: Request, res: Response) => {
    const employeeId = Number(req.params.id);

    const index = employees.findIndex((employee) => employee.id === employeeId)

    if (index === -1) {
        res.status(404).json({
            "error": true,
            "message": "Não foi possível encontrar um funcionário com esse ID"
        });
        return;
    }

    const removedEmployee = employees.splice(index, 1)
    res.status(200).json({
        "message": "Funcionário removido com sucesso",
        "employee": removedEmployee
    });
});

app.put("/employee/:id", (req: Request, res: Response) => {
    const employeeId = Number(req.params.id);

    const index = employees.findIndex((employee) => employee.id === employeeId)

    //Caso não encontre um funcionário (retorna -1 por padrão da função)
    if (index === -1) {
        res.status(404).json({
            "error": true,
            "message": "Não foi possível encontrar um funcionário com esse ID"
        });
        return;
    }

    const { name, document, position, workingHours, salary, zipCode } = req.body
    const updatedEmployee = { name, document, position, workingHours, salary, zipCode };
    employees[index] = {
        id: employeeId,
        ...updatedEmployee
    }
    res.status(200).json({
        "message": "Funcionário atualizado com sucesso",
        "employee": employees[index]
    });
});
//#endregion

//Inicia aplicacação na porta 3000
app.listen(port, () => {
    console.log(`Servidor executando na porta ${port}`);
});
