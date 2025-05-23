package edu.icet.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCartDTO {
    private Long cartId;
    private String customerEmail;
    private ProductDto product;
    private Long qty;
}
