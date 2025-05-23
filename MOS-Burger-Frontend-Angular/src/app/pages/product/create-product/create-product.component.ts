import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms'
import { HttpClient } from '@angular/common/http';

interface Product{
  name: string ;
  path: string;
  description: string;
  price: number;
  stock: number;
}


@Component({
  selector: 'app-create-product',
  imports: [FormsModule],
  templateUrl: './create-product.component.html',
  styleUrl: './create-product.component.css'
})
export class CreateProductComponent {
  
  constructor(protected http:HttpClient){}

  public pdct:Product = {
    name:"",
    path: "",
    description:"",
    price: 0,
    stock: 0
  }
  
  addProduct(){
    this.http.post("/api/product/save",this.pdct).subscribe(res=>{
      console.log(res);
    })
  }

}
