import express from 'express' 
import cors from 'cors' // Importa o módulo cors
import {config} from 'dotenv'
import {connectToDatabase} from './config/db.js';
import municipiosRoutes from './routes/municipios.js'
import usuariosRoutes from './routes/usuarios.js'
import fs from 'fs'

config()
const app = express();
const PORT = process.env.PORT || 3000;
app.use(express.json()) // forçando a trabalhar com JSON

//rota pública
app.use('/', express.static('public'))

app.use('/api/municipios', municipiosRoutes)
app.use('/api/usuarios', usuariosRoutes)

//define o favicon
app.use('/favicon.ico', express.static('public/images/logo.png'))

connectToDatabase(app).then(() => {
    app.listen(PORT, () => {
        console.log(`Servidor rodando na porta ${PORT}`);
    })
})