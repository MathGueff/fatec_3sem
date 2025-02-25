use('cinema');

db.filmes.insertOne({
    "titulo": "Guerra nas Estrelas",
    "ano" : 1978,
    "diretor" : "George Lucas",
    "classificação" : "🌠🌠🌠🌠🌠",
    "tituloJp" : "スターウォーズ"
});

use('cinema');

db.filmes.insertOne({
    "titulo": "Guerra nas Estrelas 2",
    "ano" : 1981,
    "diretor" : "George Lucas",
    "classificação" : "🌠🌠🌠",
});

use('cinema');
//Select * from filmes
db.filmes.find(); 

use('cinema');
//Select titulo, ano from filmes
db.filmes.find({}, {titulo:1, ano:1, _id:0}); 
//Chaves com 0 não aparecem, e campos não especificados também

use('cinema');
//Select titulo diretor from filmes where ano = 1978
db.filmes.find({ano:1978}, {titulo:1, diretor:1, _id:0}); 