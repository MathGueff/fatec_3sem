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

export const validateUsuario = [
    check('nome')
        .not().isEmpty().trim().withMessage("É obrigatório informar o nome")
        .isAlpha('pt-BR', {ignore : ' '}).withMessage('Informe apenas texto')
        .isLength({min : 3}).withMessage("Informe no mínimo 3 caracteres")
        .isLength({max : 100}).withMessage("Informe no máximo 100 caracteres"),
    check('email')
        .not().isEmpty().trim().withMessage("É obrigatório informar o email")
        .isEmail().withMessage("Informe um email válido")
        .isLowercase().withMessage("Não são permitidos maiúsculas")
        /* .custom((value) => {
            return db.collection('usuarios')
                .find({email : {$eq : value}}).toArray()
                .then((email) => {
                    //Verificar se não existe o Id para garantir que é inclusão
                    if(email.length){
                        return Promise.reject(`O email ${value} já existe!`)
                    }
                })
        })*/,
    check('senha')
        .not().isEmpty().trim().withMessage("A senha é obrigatória")
        .isLength({min : 6}).withMessage("A senha deve ter no mínimo 6 caracteres")
        .isStrongPassword({
            minLength: 6,
            minLowercase : 1, minUppercase: 1,
            minSymbols: 1, minNumbers: 1
        }). withMessage("A senha não é segura. Informe no mínimo 1 caractere maiúsculo, 1 minúsculo, 1 número e 1 caractere especial"),
    check('ativo')
        .default(true)
        .isBoolean().withMessage("O valor deve ser um booleano"),
    check('tipo')
        .default('Cliente')
        .isIn(['Cliente', 'Admin']).withMessage('O tipo deve ser Admin ou Cliente'),
    check('avatar')
        .optional({nullable : true})
        .isURL().withMessage('A URL do Avatar é inválida'),
    validateRequest
]