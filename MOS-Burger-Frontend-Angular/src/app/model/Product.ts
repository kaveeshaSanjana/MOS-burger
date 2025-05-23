export default class Product {
    productId:number;
    path: string ;
    name: string ;
    price: number ;
    description: string ;
    stock: number;


    constructor(productId:number,path: string ,name: string ,price: number,description: string,stock: number){
        this.productId = productId;
        this.path = path;
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

}