//ESTADOS

use('estoque')
db.estados.find()

use('estoque')
db.estados.find().forEach(function (estado) {
    db.estados.updateOne(
        {_id : estado._id},
        {$set : {
            local : {
                type : 'Point',
                coordinates : [estado.longitude, estado.latitude]
            }
        },
        $unset : {latitude: "", longitude : ""}
    }
    )
})

use('estoque')

use('estoque')
//Criando o índice Sphere
db.estados.createIndex({local : '2dsphere'})

use('estoque')
db.estados.find({
    local : {
        $near : {
            $geometry : {
                type : 'Point',
                coordinates : [-23.5313,-47.4495]
            },
            $maxDistance : 20000000
        }
    }
}, {nome:1, _id:0})

use('estoque')
db.estados.find({
    local : {
        $geoWithin : {
            $centerSphere : [[-47.4495, -23.5313], 50 /6378.1] //Raio em medianos
        } //6378.1 é o raio da Terra em KM
    }
}, {nome : 1, _id: 0})

//MUNICÍPIOS
use('estoque')
db.municipios.find()

use('estoque')
db.municipios.find().forEach(function (municipio) {
    db.municipios.updateOne(
        {_id : municipio._id},
        {$set : {
            local : {
                type : 'Point',
                coordinates : [municipio.longitude, municipio.latitude]
            }
        },
        $unset : {latitude: "", longitude : ""}
    }
    )
})

use('estoque')
db.municipios.find({}, {local:1})

use('estoque')
//Criando o índice Sphere
db.municipios.createIndex({local : '2dsphere'})

use('estoque')
db.municipios.find({
    local : {
        $near : {
            $geometry : {
                type : 'Point',
                coordinates : [-23.5313,-47.4495]
            },
            $maxDistance : 20000000
        }
    }
}, {nome:1, _id:0})

use('estoque')
db.municipios.find({
    local : {
        $geoWithin : {
            $centerSphere : [[-47.4495, -23.5313], 20 /6378.1] //Raio em medianos
        } //6378.1 é o raio da Terra em KM
    }
}, {nome : 1, _id: 0})