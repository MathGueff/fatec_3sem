import express from 'express'
import { insereUsuario, efetuaLogin} from '../controller/usuarios.js'
import {validateUsuario}  from '../middleware/validations.js'

const router = express.Router();

router.post('/',validateUsuario,insereUsuario)

router.post('/login',efetuaLogin)

export default router