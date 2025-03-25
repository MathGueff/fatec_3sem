import express from 'express'
import { getMunicipiosById } from '../controller/municipios.js'

const router = express.Router()

//GET Municipio by id

router.get('/:id', getMunicipiosById)

export default router