package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.CustomerDTO;
import edu.icet.ecom.entity.CustomerEntity;
import edu.icet.ecom.repository.CustomerDao;
import edu.icet.ecom.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;
    private final ModelMapper mapper;

    @Override
    public boolean increasePoint(Double totalBill, String email) {
        try {
            // Implement your logic here if needed
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean addCustomer(CustomerDTO customer) {
        try {
            if (customerDao.findById(customer.getEmail()).isEmpty()) {
                customerDao.save(mapper.map(customer, CustomerEntity.class));
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) {
        try {
            if (customerDao.findById(customer.getEmail()).isPresent()) {
                customerDao.save(mapper.map(customer, CustomerEntity.class));
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteCustomer(String email) {
        try {
            customerDao.deleteById(email);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public CustomerDTO search(String id) {
        try {
            return customerDao.findById(id).map(customerEntity -> mapper.map(customerEntity, CustomerDTO.class))
                    .orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        try {
            return customerDao.findAll()
                    .stream()
                    .map(customerEntity -> mapper.map(customerEntity, CustomerDTO.class))
                    .toList();
        } catch (Exception e) {
            return List.of();
        }
    }

    @Override
    public CustomerDTO getCustomer(String email) {
        try {
            return mapper.map(customerDao.findById(email), CustomerDTO.class);
        } catch (Exception e) {
            return null;
        }
    }
}
