package edu.icet.ecom.controller;

import edu.icet.ecom.dto.OrderDTO;
import edu.icet.ecom.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@CrossOrigin()
public class OrderController {
    final OrderService orderService;

    @PostMapping("/place-order")
    public void placeOrder(@RequestBody OrderDTO orderDto){
        orderService.placeOrder(orderDto);
    }

    @GetMapping("/get-by-date/{date}")
    public List<OrderDTO> getAll(@PathVariable Date date){
        return orderService.searchOrder(date);
    }

    @GetMapping("/get-all")
    public List<OrderDTO> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/get-by-id/{id}")
    public OrderDTO getAll(@PathVariable Long id){
        return orderService.searchOrder(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id ){
        orderService.deleteOrder(id);
    }

}
