import { ObjectId } from "mongodb";

export const insereUsuario = async(req, res) => {
    req.body.avatar = `https://ui-avatars.com/api?name=${req.body.nome.replace(/ /g,'+')}&background=3b69b3&color=FFF`

    //bcryptjs -> Criptografar o conteúdo
    //jsonwebtoken -> Para gerar o JWT
    //npm i bcryptjs jsonwebtoken
}