use('estoque')

//Criando um documento
const usuarios = [
    {nome : 'José', idade:22, sexo: 'M', hobbies: ["surf", "animes"]}, 
    {nome : 'Maria', idade:24, sexo: 'F', hobbies: ["judô", "volei"]}
]

db.usuarios.insertMany(usuarios);

use('estoque')
db.usuarios.find();

use('estoque')
db.usuarios.updateOne({nome : {$eq : "Maria"}}, 
    {$set :  {nome : "Maria Silva"}}
)

//Alterando o valor do campo de UM único documento
use('estoque')
db.usuarios.updateOne({nome : /carlos/i}, {$set : {nome: 'José'}}) 

//Usando $INC para incrementar a idade de todos na alteração
use('estoque')
db.usuarios.updateMany({},
    {$inc : {idade : 1}}
)
//Usando $INC para decrementar a idade de todos na alteração
use('estoque')
db.usuarios.updateMany({},
    {$inc : {idade : -1}}
)

//Adicionando um novo elemento a um array com $PUSH
use('estoque')
db.usuarios.updateOne(
    {nome : /josé/i},
    {$push : {hobbies : 'fotografia'}},
)

use('estoque')
db.usuarios.updateOne({sexo : {$eq : 'F'}}, {$pull : {hobbies : 'judô'}})