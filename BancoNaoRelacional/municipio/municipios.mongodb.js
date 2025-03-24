use('estoque')
db.municipios.find().count()

use('estoque')
db.municipios.find().limit(5)

//Como agregar um documento em outro, como um join
use('estoque')
db.municipios.aggregate([
    {$lookup: {
      from: 'estados',
      localField: 'codigo_uf',
      foreignField: 'codigo_uf',
      as: 'estado'
    }}
])

use('estoque')
db.estados.aggregate([
    {$lookup: {
      from: 'municipios',
      localField: 'codigo_uf',
      foreignField: 'codigo_uf',
      as: 'listaMunicipios'
    }}
])

use('estoque')
db.estados.aggregate([
    {$match : {nome : /São Paulo/}},
    {$lookup: {
      from: 'municipios',
      localField: 'codigo_uf',
      foreignField: 'codigo_uf',
      as: 'listaMunicipios'
    }}
])