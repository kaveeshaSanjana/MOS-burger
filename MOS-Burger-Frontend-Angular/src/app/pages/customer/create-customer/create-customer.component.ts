import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

interface Customer {
  name: string;
  telephone: string;
  email: string;
}

@Component({
  selector: 'app-create-customer',
  imports: [FormsModule, CommonModule],
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css'] // Corrected to styleUrls
})
export class CreateCustomerComponent {
  public customer: Customer = {
    name: "",
    telephone: "",
    email: ""
  };
  successMessage: string | null = null;
  errorMessage: string | null = null;

  constructor(protected http: HttpClient) { }

  addCustomer() {
    this.http.post("/customer/save", this.customer).subscribe({
      next: (res) => {
        if (res) {
          this.successMessage = 'Customer added successfully!';
          this.errorMessage = null;
          this.resetForm(); // Reset form after successful addition
        } else {
          this.errorMessage = 'Failed to add customer. Please try again.';
          this.successMessage = null;
        }
      },
      error: (err) => {
        this.errorMessage = `Failed to add customer. Error: ${err.message}`;
        this.successMessage = null;
      }
    });
  }

  private resetForm() {
    this.customer = { name: "", telephone: "", email: "" };
  }
}
