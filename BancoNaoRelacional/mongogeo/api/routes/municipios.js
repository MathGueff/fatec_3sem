import express from 'express'
import { getMunicipiosById, createMunicipio } from '../controller/municipios.js'
import { validateMunicipio } from '../middleware/validations.js'
import auth from '../middleware/auth.js'
const router = express.Router()

//GET Municipio by id
router.get('/:id', auth, getMunicipiosById)

//POST cria um novo munícipio
router.post('/', validateMunicipio, createMunicipio)

export default router