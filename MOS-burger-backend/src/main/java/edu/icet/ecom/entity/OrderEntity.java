package edu.icet.ecom.entity;

import edu.icet.ecom.embeddable.OrderProduct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "`Order`")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String email;

    @ElementCollection
    @CollectionTable(name = "orderProduct",joinColumns = @JoinColumn(name = "orderId" ))
    private List<OrderProduct> product;
    private LocalDate date;
    private Double total;
    private Double credit;
}
