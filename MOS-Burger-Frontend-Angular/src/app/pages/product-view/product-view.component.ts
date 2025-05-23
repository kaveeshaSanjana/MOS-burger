import { NgFor } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-product-view',
  imports: [RouterLink, NgFor],
  templateUrl: './product-view.component.html',
  styleUrl: './product-view.component.css'
})
export class ProductViewComponent implements OnInit {

  constructor(private http: HttpClient) { }

  public products: any;

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts() {
    this.http.get("/product/get-all").forEach(data => {
      this.products = data;
      console.log(data);

    })
  }

  deleteProduct(id: string) {
    if (confirm("Do you want to Delete ?")){
      this.http.delete(`/product/delete/${id}`).subscribe(res => {
        this.loadProducts();
      }
    )}
  }

}
