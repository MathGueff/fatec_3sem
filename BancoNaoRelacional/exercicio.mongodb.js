use('exercicio')
//Exercício 1
const dadosFuncionarios = [
    {
    nome: "João Silva",
    cargo: "Desenvolvedor",
    sexo: "Masculino",
    salario: 5000,
    departamento: "TI",
    dataContratacao: new Date("2023-01-01"),
    projetos: ["Projeto A", "Projeto B"],
    dataCadastro: new Date()
    },
    {
    nome: "Maria Santos",
    cargo: "Analista de Dados",
    sexo: "Feminino",
    salario: 4800,
    departamento: "TI",
    dataContratacao: new Date("2023-06-15"),
    projetos: ["Projeto C"],
    dataCadastro: new Date()
    },
    {
    nome: "Carlos Oliveira",
    cargo: "Desenvolvedor",
    sexo: "Masculino",
    salario: 5100,
    departamento: "TI",
    dataContratacao: new Date("2022-03-10"),
    projetos: ["Projeto B"],
    dataCadastro: new Date()
    },
    {
    nome: "Ana Pereira",
    cargo: "Gerente de Projetos",
    sexo: "Feminino",
    salario: 7500,
    departamento: "Gestão",
    dataContratacao: new Date("2021-09-20"),
    projetos: ["Projeto A", "Projeto C"],
    dataCadastro: new Date()
    },
    {
    nome: "Luis Fernandes",
    cargo: "Contador",
    sexo: "Masculino",
    salario: 4200,
    departamento: "Contabilidade",
    dataContratacao: new Date("2020-11-05"),
    projetos: [],
    dataCadastro: new Date()
    },
    {
    nome: "Luiza Costa",
    cargo: "Analista Financeira",
    sexo: "Feminino",
    salario: 4600,
    departamento: "Financeiro",
    dataContratacao: new Date("2023-04-18"),
    projetos: ["Projeto D"],
    dataCadastro: new Date()
    },
    {
    nome: "João Souza",
    cargo: "Desenvolvedor",
    sexo: "Masculino",
    salario: 4900,
    departamento: "TI",
    dataContratacao: new Date("2023-07-01"),
    projetos: ["Projeto A"],
    dataCadastro: new Date()
    }
    ];
    db.funcionarios.insertMany(dadosFuncionarios)

    //Exercício2 - Adicionando um novo funcionario à collection funcionarios
    use('exercicio')
    db.funcionarios.insertOne({
        nome: "Davy Oliveira",
        cargo: "Programador Back-End",
        sexo: "Masculino",
        salario: 9000,
        departamento: "TI",
        dataContratacao : new Date("2021-10-20"),
        projetos : ["SaneaSP", "Marmoraria"],
        dataCadastro : new Date()
    })

    //Exercício3 - Aumentando o salário de todos em 100
    use('exercicio')
    db.funcionarios.updateMany({}, 
        {$inc : {salario : 100}}
    )

    //Exercício4 - Atualizando apenas o João Silva e adicionando o projeto C ao seu array de projetos
    use('exercicio')
    db.funcionarios.updateOne(
        {nome : {$eq : 'João Silva'}},
        {$push : {projetos : 'Projeto C'}}
    )

    //Exercicio5 - Atualizando todos os funcionários para remover a data de contratação
    use('exercicio')
    db.funcionarios.updateMany(
        {},
        {$unset : {dataContratacao : ""}}
    )

    //Exercício6 - Atualizando todos do departamento de TI e adicionando bonificação para eles
    use('exercicio')
    db.funcionarios.updateMany(
        {departamento : {$eq : 'TI'}},
        {$set : {bonificacao : 500}}
    )

    
    //Exercicio7 - Deletando o João Silva
    use('exercicio')
    db.funcionarios.deleteOne(
        {nome : {$eq : "João Silva"}}
    )

    //Exercício8 - Deletando todos do departamento de Contabilidade
    use('exercicio')
    db.funcionarios.deleteMany(
        {departamento : 'Contabilidade'}
    )

    //Exercício9 - Mostrando todos desenvolvedores, exibindo apenas nome, salario e sexo
    use('exercicio')
    db.funcionarios.find(
        {cargo : {$eq : "Desenvolvedor"}},
        {nome : 1, salario : 1, sexo : 1, _id : 0}
    )

    //Exercício10 - Mostrando todos funcionários com salario maior que 4000
    use('exercicio')
    db.funcionarios.find(
        {salario : {$gt : 4000}},
    )

    //Exercício11  - Mostrando todos com data de contratacao em 2023
    use('exercicio')
    db.funcionarios.find(
        {dataContratacao : {$gt : new Date('2022-12-31'), $lt : new Date('2024-01-01')}}
    )

    //Exercício12 - Mostrando funcionarios que possuem Projeto A ou Projeto B como projetos
    use('exercicio')
    db.funcionarios.find(
        {$or : [{projetos : {$eq : "Projeto A"}}, {projetos : {$eq : "Projeto B"}}]}
    )

    //Exercício13 - Mostrando apenas os que não possuem Projeto B em projetos
    use('exercicio')
    db.funcionarios.find(
        {projetos : {$nin : ['Projeto B']}}
    )

    //Exercício14 - Todos funcionários femininos mostrando nome, salario, dep e sexo
    use('exercicio')
    db.funcionarios.find(
        {sexo : {$eq : "Feminino"}},
        {nome:1, salario:1,departamento:1, sexo:1, _id:0}
    )

    //Exercício15 - Mostrando contratados antes de 2023
    use('exercicio')
    db.funcionarios.find(
        {dataContratacao : {$lt : new Date('2023-01-01')}}
    )

    //Exercício16 - Mostrando quem tem mais de um projeto
    use('exercicio')
    db.funcionarios.find(
        {$and : [
            {projetos : {$not : {$size : 1}}},
            {projetos : {$not : {$size : 0}}}
        ]}
    )

    //Exercício17 - Nao consegui
    use('exercicio')
    db.funcionarios.find(
        {dataCadastro : {$gte : new Date()  - 30}}
    )

    //Exercício18 - Mostrando funcionários cujo nome começa com "João"
    use('exercicio')
    db.funcionarios.find(
        {nome : /^João/i}
    )

    //Exercício19 - Mostrando funcionários cujo nome termina com "Silva"
    use('exercicio')
    db.funcionarios.find(
        {nome : /Silva$/}
    )

    //Exercício20 - Mostrando funcionários que contenham "Luiz" ou "Luiza" no nome
    use('exercicio')
    db.funcionarios.find(
        {$or : [{nome : /Luis/}, {nome : /Luiz/}]}
    )

    //Exercício21 - Mostrando funcionários do dep de TI e com sal maior ou igual a 4500
    use('exercicio')
    db.funcionarios.find(
        {$and : [{departamento : {$eq : "TI"}}, {salario : {$gt : 4500}}]}
    )

    //Exercício22 - Mostrando funcionários que não tenham cargo de Desenvolvedor e que tenham sido contratados em 2023
    use('exercicio')
    db.funcionarios.find(
        {$and : [
            {cargo : {$nin : ["Desenvolvedor"]}}, 
            {dataContratacao : {$gt : new Date('2022-12-31'), $lt : new Date('2024-01-01')}}
            ]
        }
    )
    
    //Exercício23 - Mostrando funcionários que trabalham nos projetos A ou B  e que tenham sal menor ou igual a 5000
    use('exercicio')
    db.funcionarios.find(
        {$and : [
            {projetos : {$in : ['Projeto A', 'Projeto B']}},
            {salario : {$lte : 5000}}
        ]}
    )

    //Exercício24 - Mostrando funcionários que não trabalham no Projeto A e que o departamento não seja de TI
    use('exercicio')
    db.funcionarios.find(
        {$and : [
            {projetos : {$nin : ['Projeto A']}},
            {departamento : {$not : {$eq : 'TI'}}}
        ]}
    )

    //Exercício25 - Mostrando funcionários femininos com data de contratacao menor que 2023
    use('exercicio')
    db.funcionarios.find(
        {$or : [
            {sexo : {$eq : "Feminino"}},
            {dataContratacao : {$lt : new Date('2023-01-01')}}
        ]}
    )

    //Exercício26 - Mostrando funcionários que tenham cargo de Desenvolvedor ou Analista e 
        // salário maior que 4000 e data de contratacao seja a partir de 2023
    use('exercicio')
    db.funcionarios.find(
        {$and : [
            {cargo : {$in : ['Desenvolvedor', 'Analista']}},
            {salario : {$gt : 4000}},
            {dataContratacao : {$gt : new Date('2022-12-31')}}
        ]}
    )

    use('exercicio')
    db.funcionarios.find()

    use('exercicio')
    db.funcionarios.drop()