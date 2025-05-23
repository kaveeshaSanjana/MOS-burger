import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-update-customer',
  imports:[FormsModule ,  CommonModule] ,
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {
  public customer: any = {
    name: "",
    telephone: "",
    email: ""
  };
  successMessage: string | null = null;
  errorMessage: string | null = null;

  constructor(protected http: HttpClient, protected route: ActivatedRoute, protected router: Router) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.loadCustomer(id);
  }

  loadCustomer(id: string | null) {
    this.http.get<any>(`/customer/get/${id}`).subscribe({
      next: (data) => {
        this.customer = data;
      },
      error: (err) => {
        this.errorMessage = `Failed to load customer. Error: ${err.message}`;
      }
    });
  }

  updateCustomer() {
    const id = this.route.snapshot.paramMap.get('id');
    this.http.put(`/customer/update`, this.customer).subscribe({
      next: (res) => {
        this.successMessage = 'Customer updated successfully!';
        this.errorMessage = null;
        this.router.navigate(['/customer']); // Redirect after update
      },
      error: (err) => {
        this.errorMessage = `Failed to update customer. Error: ${err.message}`;
        this.successMessage = null;
      }
    });
  }
}
