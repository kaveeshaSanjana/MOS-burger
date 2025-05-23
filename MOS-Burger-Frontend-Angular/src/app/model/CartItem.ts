export default class CartItem {
  customerEmail: string;
  productId: number;
  qty: number;

  constructor(customerEmail: string,productId: number,qty: number){
    this.customerEmail = customerEmail;
    this.productId = productId;
    this.qty = qty;
  }
}