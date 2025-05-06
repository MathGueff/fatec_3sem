import { ObjectId } from "mongodb";
import bcrypt from "bcryptjs";
import jwt from 'jsonwebtoken';

export const insereUsuario = async(req, res) => {
    req.body.avatar = `https://ui-avatars.com/api?name=${req.body.nome.replace(/ /g,'+')}&background=3b69b3&color=FFF`

    //bcryptjs -> Criptografar o conteúdo
    //jsonwebtoken -> Para gerar o JWT
    //npm i bcryptjs jsonwebtoken

    //Criptografia da Senha
    const salt = await bcrypt.genSalt(10);
    req.body.senha = await bcrypt.hash(req.body.senha, salt);

    //Salvando usuários
    const db = req.app.locals.db
    await db.collection('usuarios')
        .insertOne(req.body)
        .then(result => res.status(201).send(result)
            .catch(err => res.status(400).json(err))
        )
}