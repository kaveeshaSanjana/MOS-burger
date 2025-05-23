import { NgFor, NgIf } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import Order from '../../../model/Order';

@Component({
  selector: 'app-update-order',
  imports: [NgIf, NgFor, FormsModule],
  templateUrl: './update-order.component.html',
  styleUrls: ['./update-order.component.css']
})
export class UpdateOrderComponent implements OnInit {
  public orders: Order[] = [];
  public selectedOrder: Order | null = null;
  public isUpdateModalOpen: boolean = false;

  constructor(private readonly http: HttpClient) {}

  ngOnInit(): void {
    this.loadOrders();
  }

  loadOrders(): void {
    this.http.get<Order[]>("/order/get-all").subscribe({
      next: (data) => {
        this.orders = data;
        console.log(data);
      },
      error: (err) => {
        console.error('Error loading orders:', err);
      }
    });
  }

  deleteOrder(id: number): void {
    if (confirm('Are you sure you want to delete this order?')) {
      this.http.delete(`/order/delete/${id}`).subscribe({
        next: (res) => {
          console.log(res);
          this.loadOrders(); // Refresh orders after deletion
        },
        error: (err) => {
          console.error('Error deleting order:', err);
        }
      });
    }
  }

  openUpdateOrderModal(order: Order): void {
    this.selectedOrder = { ...order }; // Create a shallow copy to avoid mutations
    this.isUpdateModalOpen = true;
  }

  closeUpdateOrderModal(): void {
    this.isUpdateModalOpen = false;
    this.selectedOrder = null;
  }

  viewOrder(product: string): void {
    alert(`Viewing product details: ${product}`);
  }
}
