package net.repos.customerservice.web;

import net.repos.customerservice.Dao.entities.Customer;
import net.repos.customerservice.Dao.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CustomerRestController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/get")
    public List<Customer> customerList(){
      return customerRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public List <Customer> customerById(Long id){
       return  customerRepository.findById(id);
    }

    @PostMapping("/save")
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

}
