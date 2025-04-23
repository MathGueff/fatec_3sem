import { DataTypes, Model, Optional } from "sequelize";
import { IBrand } from "../interfaces/brand.interface";
import sequelize from '../config/database'

type BrandCreationalAttributes = Optional<IBrand, "id">

export class BrandModel extends Model<IBrand, BrandCreationalAttributes>{
    public id!: number;
    public description!: string;
}

BrandModel.init(
{
    id : {
        primaryKey : true,
        type: DataTypes.INTEGER,
        autoIncrement: true,
        allowNull: false,
        field: "id_marca",
    },
    description : {
        allowNull : false,
        type: DataTypes.STRING(100),
        field: "descricao"
    },
}, 
{
    tableName: "marca",
    sequelize,
    timestamps: false
})