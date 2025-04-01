import { check, param, validationResult } from 'express-validator'

export const validateRequest = (req, res, next) => {
    const errors = validationResult(req)
    if (!errors.isEmpty()) {
        return res.status(400).json({
            error: true,
            message: "Erro de validação",
            errors: errors.array()
        })
    }
    next()
}

export const validateMunicipio = [
    //Codigo IBGE
    check('codigo_ibge')
        .notEmpty().withMessage('O código IBGE é obrigatório')
        .isInt({ min: 1000000, max: 999999 }).withMessage('O código IBGE deve ser um número inteiro de 7 digitos'),
    //Nome  
    check('nome').notEmpty().withMessage('O nome é obrigatório')
        .isLength({ max: 100 }).withMessage('O nome não pode ter mais que 100 caracteres'),
    //Capital
    check('capital').isBoolean().withMessage("O campo capital deve ser boolean"),
    //Local
    check('local').notEmpty().withMessage('O local é obrigatório')
        .isObject().withMessage('O local tem que ser um objeto'),
    //Local type
    check('local.type').notEmpty().withMessage("O tipo do local deve ser Point"),
    //Local coordinates
    check('local.coordinates').notEmpty().withMessage('As coordenadas são obrigatórias')
        .isArray({ min: 2, max: 2 }).withMessage('As coordenadas devem ser com a latitude e longitude'),
    //Local coordinates 0
    check('local.coordinates.0').isFloat({ min: -180, max: 180 })
        .withMessage('A longitude é um intervalo entre -180 e 180'),
    //Aplica as validações
    validateRequest
]