package edu.icet.ecom.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Cart")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class CartEntity {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long cartId;
     private String customerEmail;
     private Long productId;
     private Long qty;

}
