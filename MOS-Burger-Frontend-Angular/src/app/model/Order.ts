import Product from "./Product";

export default class Order {
    orderId: number;
    email: string;
    date: string;
    product: Product[];

    constructor(orderId: number,email: string,date: string,product: Product[]){
        this.orderId = orderId;
        this.email =  email;
        this.date = date;
        this.product = product;
    }
  }