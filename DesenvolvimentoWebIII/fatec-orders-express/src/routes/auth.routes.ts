import express, { Request, Response } from 'express'
import jwt from "jsonwebtoken"
import dotenv from "dotenv";
export const authRouter = express.Router();

authRouter.post("/", (req: Request, res: Response) => {
    const { username, password } = req.body;

    if (username === "admin" && password === "admin") {
        const secret = process.env.AUTH_SECRET || "";
        const token = jwt.sign({ username: "admin" }, secret);
        res.status(200).json({ token });
        return;
    }

    res.status(401).send()
});