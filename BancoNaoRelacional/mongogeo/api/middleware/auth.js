import jwt from 'jsonwebtoken'
export default async function auth(req, res, next){
    const token = req.header('access-token')
    if(!token) return res.status(401).json({
        msg :'Acesso negado. É obrigatório o envio do token JWT'
    })
    try{
        const decoded = jwt.verify(token, process.env.SECRET_KEY)
        req.usuario = decoded.usuario //Adicionamos o usuário atual na requisição
        next();
    } catch(e) {
        res.status(403).send({error : 'Token inválido!'})
    }
 }