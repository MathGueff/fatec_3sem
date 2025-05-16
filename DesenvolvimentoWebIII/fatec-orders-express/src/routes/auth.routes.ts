import express, { Request, Response }  from 'express'
import jwt from "jsonwebtoken"
export const authRouter = express.Router();

authRouter.post("/", (req : Request, res : Response) => {
    const {username, password} = req.body;

    if(username === "admin" && password === "admin"){
        const token = jwt.sign(
            {username: "admin"}, 
            "hfsnhnfhdsfsn"
        )
        res.status(200).json({token});
        return;
    }
    
    res.status(401).send()
});