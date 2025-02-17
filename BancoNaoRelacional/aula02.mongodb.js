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

//Database Estoque
use('estoque')
db.categorias.find()

use('estoque')
db.categorias.insertOne({_id:'123', nome: 'Sobremesas', ativo:true})

use('estoque')
db.categorias.find({}, {_id:0, nome:1})