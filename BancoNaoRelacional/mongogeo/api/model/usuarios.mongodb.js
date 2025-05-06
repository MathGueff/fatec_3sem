use('estoque')
db.usuarios.insertOne({
    nome : "Matheus Gueff",
    email : "gueff@gmail.com",
    senha : "123",
    ativo : true,
    tipo : "Cliente",
    avatar : "https://ui-avatars.com/api?name=Matheus+Gueff&background=3b69b3&color=FFF"
})

use('estoque')
db.usuarios.createIndex({'email' : 1},{unique : true});

use('estoque')
db.usuarios.find({},{senha : 0})
