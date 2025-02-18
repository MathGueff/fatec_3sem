//Tipos de dados
//String, Number, Boolean, Date, ObjectID
//Array, Object

//Database Estoque
use('estoque')

//Collection categorias
db.categorias.insertOne({
    nome: 'Bebidas',
    ativo: true, 

}) //nome -> string, ativo -> boolean

//SELECT *
use('estoque')
db.categorias.find()

//INSERT (UNICO DOCUMENTO)
use('estoque')
db.categorias.insertOne({_id:'123', nome: 'Sobremesas', ativo:true})

//SELECT ESCOLHENDO AS COLUNAS (0 -> FALSE E 1 -> TRUE)
use('estoque')
db.categorias.find({}, {_id:0, nome:1})

//INSERINDO VÁRIOS DOCUMENTOS COM UM ARRAY
use('estoque')
db.categorias.insertMany([
    {nome: 'Entradas', ativo:false},
    {nome: 'Pães', ativo: true}
])

use('estoque')
db.produtos.insertOne({
    _id:'124',
    nome: 'Hambúrguer Gourmet',
    preco: 35.99,
    ingredientes: ['pão', 'carne', 'queijo', 'alface', 'tomate'],
    vegetariano: false,
    dataCadastro: new Date(),
    calorias: {
        total: 780,
        porcoes: 1
    }
})

//Para mostrar como é possivel adicionar com os atributos em ordem aleatória, porém bagunça o objeto
use('estoque')
db.produtos.insertOne({
    ingredientes: ['pão', 'carne', 'queijo', 'alface', 'tomate'],
    _id:'125',
    preco: 35.99,
    vegetariano: false,
    dataCadastro: new Date(),
    calorias: {
        total: 780,
        porcoes: 1
    },
    nome: 'Hambúrguer Gourmet',
})

use('estoque')
db.produtos.find()

//DELETE COLLECTION (DELETE TABLE)
use('estoque')
db.produtos.drop()

//Criando a collection com as regras
use('estoque')
db.createCollection('produtos', {
    validator: {
    $jsonSchema: {
        'bsonType' : 'object',
        'required' : ['_id', 'nome', 'preco', 
            'ingredientes', 'vegetariano', 'dataCadastro']
        }}
})

use('estoque')
db.getCollectionInfos({name:'produtos'})

try{
    use('estoque')
    db.produtos.insertOne({
        abobrinha: 'Abóbora',
    })
} catch(err){
    printjson(err);
}

use('estoque')
db.estados.insertMany([
    {sigla:'SP', nome: 'São Paulo', populacao: 12000000},
    {sigla: 'AC', nome: 'Acre', populacao: 712000},
    {sigla: 'RJ', nome: 'Rio de Janeiro', populacao: 2500000}
])

use('estoque')
db.estados.find({}, {})

//SELECT id, nome from estados where sigla = 'SP'
use('estoque')
db.estados.find({sigla : {$eq: 'SP'}}, {nome:1})

/* FILTROS */

// i = insensitive case (nao diferencia maiusculo de minusculo)
// $ = que termine
// ^ = que inicie

//SELECT nome from estados where nome like %Paulo%
use('estoque')
db.estados.find({nome : /paulo/i}, {_id:0, nome:1})
use('estoque')
db.estados.find({nome : /^rio/i}, {_id:0, nome:1})

//SELECT * from estados where nome like %o
use('estoque')
db.estados.find({nome : /o$/i}, {_id:0, nome:1})

//SELECT * from estados where populacao >= 11000000
use('estoque')
db.estados.find({populacao : { $gte: 11000000}})

//SELECT * from estados where populacao <= 11000000
use('estoque')
db.estados.find({populacao : { $lte: 11000000}})

//SELECT * from estados where sigla IN ('SP', 'AC')
use('estoque')
db.estados.find({sigla : {$in: ['SP', 'AC']}})

//SELECT * from estados where sigla not IN ('AC', 'SP')
use('estoque')
db.estados.find({sigla : {$nin: ['SP', 'AC']}})

//SELECT * from estados where sigla = 'SP' or sigla = 'AC'
use('estoque')
db.estados.find({
    $or : [
        {sigla : {$eq : 'AC'}},
        {sigla : {$eq : 'SP'}}
    ]
})

//DELETE
//Nao precisa do equal para entender
use('estoque')
db.estados.deleteOne({sigla : 'AC'})
use('estoque')
db.estados.deleteOne({sigla : {$eq : 'AC'}})

use('estoque')
db.estados.insertOne({
    sigla : 'AC',
    nome : 'Acre',
    populacao : 12000000
})

use('estoque')
db.estados.deleteMany({nome: /o/i})