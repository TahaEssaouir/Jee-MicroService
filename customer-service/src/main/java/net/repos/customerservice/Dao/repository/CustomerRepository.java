package net.repos.customerservice.Dao.repository;

import net.repos.customerservice.Dao.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {


   List<Customer> findById(Long id);
}
