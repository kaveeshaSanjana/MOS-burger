package edu.icet.ecom.dto;

import edu.icet.ecom.embeddable.OrderProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {
    private Long orderId;
    private String email;
    private List<OrderProduct> product;
    private LocalDate date;
    private Double total;
    private Double credit;
}
