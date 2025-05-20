import express, { NextFunction, Router } from 'express'
import { Request, Response } from "express";
import { create, listAll } from '../controllers/brand.controller';
import jwt from "jsonwebtoken";
import dotenv from "dotenv";
//Utilizamos para implementar as rotas de produto
const router = express.Router();

const authorize = (req: Request, res: Response, next: NextFunction) => {
  const { authorization } = req.headers;
  const secret = process.env.AUTH_SECRET || "";

  jwt.verify(authorization || "", secret, (err) => {
    if (err) {
      return res.status(401).json({ message: "Invalid token" });
    }
    next();
  });
};

router.use(authorize);

const createBrandMiddleware = (req : Request, res : Response, next : NextFunction) => {
   console.log("Descrição: " + req.body.description)
   next();
}

//Define método Get que responde no path /client/:id (para exibir o produto específico)
router.get("/", async (req: Request, res: Response) => {
   const brands = await listAll();
   res.status(200).json(brands)
});

router.post('/', createBrandMiddleware, async (req: Request, res: Response) => {
   const {description} = req.body
   const brand = await create(description);
   res.status(200).json(brand)
})

export default router