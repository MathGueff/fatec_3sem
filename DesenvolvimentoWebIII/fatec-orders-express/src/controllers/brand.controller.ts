import { IBrand } from "../interfaces/brand.interface";
import { BrandModel } from "../models/brand.model"

export const listAll = async () : Promise<IBrand[]> => {
    const brands = await BrandModel.findAll();
    return brands;
}

export const create = async (description: string) : Promise<IBrand> => {
    const brand = await BrandModel.create({description})
    return brand;
}