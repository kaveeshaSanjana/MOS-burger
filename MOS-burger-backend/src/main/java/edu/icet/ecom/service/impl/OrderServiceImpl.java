package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.OrderDTO;
import edu.icet.ecom.entity.OrderEntity;
import edu.icet.ecom.repository.OrderDao;
import edu.icet.ecom.service.CustomerService;
import edu.icet.ecom.service.OrderService;
import edu.icet.ecom.service.SendEmailService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    final OrderDao orderDao;
    final CartServiceImpl cartService;
    final CustomerService customerService;
    final ModelMapper modelMapper;
    final SendEmailService sendEmailService;

    @Override
    public boolean placeOrder(OrderDTO order) {
        orderDao.save(modelMapper.map(order,OrderEntity.class));
        //boolean b = customerService.increasePoint(order.getCredit(), order.getEmail());
        sendEmailService.sendEmail("Place Order","Your order placed Success",order.getEmail());
        cartService.delete(order.getEmail());
        return true;
    }

    @Override
    public boolean deleteOrder(Long orderId) {
        orderDao.deleteById(orderId);
        return true;
    }

    @Override
    public List<OrderDTO> searchOrder(Date date) {
        ArrayList<OrderDTO> orderDTOS = new ArrayList<>();
        orderDao.findAllByDate(date).forEach(orderEntity ->
                orderDTOS.add(modelMapper.map(orderEntity, OrderDTO.class))
        );
        return orderDTOS;
    }

    @Override
    public List<OrderDTO> getAll() {
        ArrayList<OrderDTO> orderDtos = new ArrayList<>();
        orderDao.findAll().forEach(orderEntity ->
                orderDtos.add(modelMapper.map(orderEntity, OrderDTO.class))
        );
        return orderDtos;
    }

    @Override
    public OrderDTO searchOrder(Long orderId) {
        return modelMapper.map(orderDao.findById(orderId), OrderDTO.class);
    }

    @Override
    public boolean update(OrderDTO orderDto) {
        orderDao.save(modelMapper.map(orderDto,OrderEntity.class));
        return true;
    }


}
