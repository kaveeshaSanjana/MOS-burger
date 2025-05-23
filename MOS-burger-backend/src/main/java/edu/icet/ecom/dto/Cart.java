package edu.icet.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Cart {
     private Long cartId;
     private String customerEmail;
     private Long productId;
     private Long qty;

}
