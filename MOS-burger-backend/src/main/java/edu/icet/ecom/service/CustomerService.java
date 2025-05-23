package edu.icet.ecom.service;

import edu.icet.ecom.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    boolean increasePoint(Double credit, String email);
    boolean addCustomer(CustomerDTO customer);
    boolean updateCustomer(CustomerDTO customer);
    boolean deleteCustomer(String email);
    CustomerDTO search(String id);
    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomer(String email);
}
