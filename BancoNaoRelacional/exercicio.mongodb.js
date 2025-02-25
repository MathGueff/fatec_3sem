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

    //Exercício2
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

    //Exercício3
    use('exercicio')
    db.funcionarios.updateMany({}, 
        {$inc : {salario : 100}}
    )

    //Exercício4
    use('exercicio')
    db.funcionarios.updateOne(
        {nome : {$eq : 'João Silva'}},
        {$push : {projetos : 'Projeto C'}}
    )

    //Exercicio5
    use('exercicio')
    db.funcionarios.updateMany(
        {},
        {$unset : {dataContratacao : ""}}
    )

    //Exercício6
    use('exercicio')
    db.funcionarios.updateMany(
        {departamento : {$eq : 'TI'}},
        {$set : {bonificacao : 500}}
    )

    
    //Exercicio7
    use('exercicio')
    db.funcionarios.deleteOne(
        {nome : {$eq : "João Silva"}}
    )

    //Exercício8
    use('exercicio')
    db.funcionarios.deleteMany(
        {departamento : 'Contabilidade'}
    )

    //Exercício9
    use('exercicio')
    db.funcionarios.find(
        {cargo : {$eq : "Desenvolvedor"}},
        {nome : 1, salario : 1, sexo : 1, _id : 0}
    )

    //Exercício10
    use('exercicio')
    db.funcionarios.find(
        {salario : {$gt : 4000}},
    )

    //Exercício11 - Não consegui
    use('exercicio')
    db.funcionarios.find(
        {dataContratacao : {$gt : new Date('2022-12-31'), $lt : new Date('2024-01-01')}}
    )

    //Exercício12
    use('exercicio')
    db.funcionarios.find(
        {$or : [{projetos : {$eq : "Projeto A"}}, {projetos : {$eq : "Projeto B"}}]}
    )

    //Exercício13
    use('exercicio')
    db.funcionarios.find(
        {projetos : {$nin : ['Projeto B']}}
    )

    //Exercício14
    use('exercicio')
    db.funcionarios.find(
        {sexo : {$eq : "Feminino"}},
        {nome:1, salario:1,departamento:1, sexo:1, _id:0}
    )

    //Exercício15
    use('exercicio')
    db.funcionarios.find(
        {dataContratacao : {$lt : new Date('2023-01-01')}}
    )

    //Exercício16
    use('exercicio')
    db.funcionarios.find(
        {projetos : {$size : 2}}
    )

    //Exercício17 - Nao consegui
    use('exercicio')
    db.funcionarios.find(
        {dataCadastro : {$gt : new Date()}}
    )

    //Exercício18
    use('exercicio')
    db.funcionarios.find(
        {nome : /^João/i}
    )

    //Exercício19
    use('exercicio')
    db.funcionarios.find(
        {nome : /Oliveira$/}
    )

    //Exercício20
    use('exercicio')
    db.funcionarios.find(
        {$or : [{nome : /Luis/}, {nome : /Luiz/}]}
    )

    //Exercício21
    use('exercicio')
    db.funcionarios.find(
        {$and : [{departamento : {$eq : "TI"}}, {salario : {$gt : 4500}}]}
    )

    //Exercício22
    use('exercicio')
    db.funcionarios.find(
        {$and : [
            {cargo : {$nin : ["Desenvolvedor"]}}, 
            {dataContratacao : {$gt : new Date('2022-12-31'), $lt : new Date('2024-01-01')}}
            ]
        }
    )
    
    //Exercício23
    use('exercicio')
    db.funcionarios.find(
        {$and : [
            {projetos : {$in : ['Projeto A', 'Projeto B']}},
            {salario : {$lte : 5000}}
        ]}
    )

    //Exercício24
    use('exercicio')
    db.funcionarios.find(
        {$and : [
            {projetos : {$nin : ['Projeto A']}},
            {departamento : {$not : {$eq : 'TI'}}}
        ]}
    )

    //Exercício25
    use('exercicio')
    db.funcionarios.find(
        {$or : [
            {sexo : {$eq : "Feminino"}},
            {dataContratacao : {$lt : new Date('2023-01-01')}}
        ]}
    )

    //Exercício26
    use('exercicio')
    db.funcionarios.find(
        {$and : [
            {$or : [
                {cargo : {$in : ['Desenvolvedor', 'Analista']}}
            ]},
            {salario : 4000},
            {dataContratacao : {gt : new Date('2022-12-31')}}
        ]}
    )

    use('exercicio')
    db.funcionarios.find()

    use('exercicio')
    db.funcionarios.drop()