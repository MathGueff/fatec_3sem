import express from 'express' 
import {connectToDatabase} from './config/db.js';
import municipiosRoutes from './routes/municipios.js'
import fs from 'fs'

const app = express();
const PORT = process.env.PORT || 3000;
app.use(express.json()) // forçando a trabalhar com JSON

//rota pública
app.use('/', express.static('public'))

app.use('/api/municipios', municipiosRoutes)

//define o favicon
app.use('/favicon.ico', express.static('public/images/logo.png'))

connectToDatabase(app).then(() => {
    app.listen(PORT, () => {
        console.log(`Servidor rodando na porta ${PORT}`);
    })
})