package edu.icet.ecom.controller;

import edu.icet.ecom.dto.CustomerDTO;
import edu.icet.ecom.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {
    final CustomerService customerService;

    @PostMapping("/save")
    public boolean save(@RequestBody CustomerDTO customerDto){
        return customerService.addCustomer(customerDto);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") String email){
        return customerService.deleteCustomer(email);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody CustomerDTO customer){
        return customerService.updateCustomer(customer);
    }

    @PatchMapping("/point/{id}/{email}")
    public boolean increasePoint(@PathVariable("id") Double point,@PathVariable("email") String email){
        return customerService.increasePoint(point,email);
    }

    @GetMapping("get-all")
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

     @GetMapping("get/{id}")
    public CustomerDTO getCustomer(@PathVariable("id") String email){
        return customerService.getCustomer(email);
    }


}
