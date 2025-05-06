import express from 'express'
import { insereUsuario } from '../controller/usuarios.js'
import {validateUsuario}  from '../middleware/validations.js'

const router = express.Router();

router.post('/',validateUsuario,insereUsuario)

export default router