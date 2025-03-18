import express from 'express' 
import fs from 'fs'

const app = express()
app.use(express.json()) // parse da JSON

//rota pública
app.use('/', express.static('public'))

//define o favicon
app.use('/favicon.ico', express.static('public/images/logo.png'))

app.listen(3000, function(){
    console.log('Servidor rodando!');
})