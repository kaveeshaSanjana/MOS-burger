import { NgFor } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import Order from '../../model/Order';
import Product from '../../model/Product';


@Component({
  selector: 'app-order',
  imports: [NgFor],
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  public orders: Order[] = []; 
  public selectedOrder: Order | null = null;
  public isUpdateModalOpen: boolean = false;

  constructor(private readonly http: HttpClient) {}

  ngOnInit(): void {
    this.loadOrders();
  }

   loadOrders(): void {
    this.http.get<Order[]>("/order/get-all").subscribe(data => {
      this.orders = data;
      console.log(data);
    });
  }

  deleteOrder(id: number): void {
    if (confirm('Are you sure you want to delete this order?')) {
      this.http.delete(`/order/delete/${id}`).subscribe(res => {
        console.log(res);
        this.loadOrders();
      });
    }
  }

  viewOrder(product: Product[]) {
    alert(`Viewing product details: ${product}`);
  }
}
