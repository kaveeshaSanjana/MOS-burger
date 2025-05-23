package edu.icet.ecom.embeddable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class OrderProduct {
    private Long productId;
    private Double price;
    private Long qty;

    public OrderProduct() {
        // Empty constructor
    }

    public OrderProduct(Long productId, Double price, Long qty) {
        this.productId = productId;
        this.price = price;
        this.qty = qty;
    }
}