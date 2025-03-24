const { MongoClient } = require('mongodb')
const fs = require('fs')// File System -> acessa arquivos

const uri = 'mongodb://localhost/27017'
const dbName = 'estoque'
const collectionName = 'municipios'

async function importaMunicipios(){
    const client = new MongoClient(uri)
    try{
        await client.connect()
        console.log("✅ Conectado ao MongoDB")
        //Ler os dados JSON
        const dados = fs.readFileSync('municipios.json', 'utf-8')
        const municipios = JSON.parse(dados)
        //Verificar se é um array
        if(!Array.isArray(municipios))
            {throw new Error('O JSON deve conter um Array de objetos')}
        const db = client.db(dbName) //Criando const com o database 
        const collection = db.collection(collectionName) //Relacionando o nome da collection com a collection do mongoDB
        const collections = await db.listCollections({name : collectionName}).toArray()
        if(collections.length > 0){
            await collection.drop()
            console.log(`⚠ Coleção ${collectionName} foi dropada`)
        }
        const resultado = await collection.insertMany(municipios)
        console.log(`${resultado.insertedCount} documentos inseridos`)
    } catch(error){
        console.log('❌ Erro ao importar ', error.message)
    } finally {
        await client.close()
    }
}

importaMunicipios();