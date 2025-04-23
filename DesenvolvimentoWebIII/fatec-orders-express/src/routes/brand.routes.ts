import express, { Router } from 'express'
import { Request, Response } from "express";
import { create, listAll } from '../controllers/brand.controller';
//Utilizamos para implementar as rotas de produto
const router = express.Router();

//Define método Get que responde no path /client/:id (para exibir o produto específico)
router.get("/", async (req: Request, res: Response) => {
   const brands = await listAll();
   res.status(200).json(brands)
});

router.post('/', async (req: Request, res: Response) => {
   const {description} = req.body
   const brand = await create(description);
   res.status(200).json(brand)
})

export default router