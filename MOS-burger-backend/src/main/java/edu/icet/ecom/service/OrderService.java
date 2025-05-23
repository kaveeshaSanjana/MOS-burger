package edu.icet.ecom.service;

import edu.icet.ecom.dto.OrderDTO;

import java.sql.Date;
import java.util.List;

public interface OrderService {
    boolean placeOrder(OrderDTO order);
    boolean deleteOrder(Long orderId);
    List<OrderDTO> searchOrder(Date date);
    List<OrderDTO> getAll();
    OrderDTO searchOrder(Long orderId);
    boolean update(OrderDTO orderDto);
}
