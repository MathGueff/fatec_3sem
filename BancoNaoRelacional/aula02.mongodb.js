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
