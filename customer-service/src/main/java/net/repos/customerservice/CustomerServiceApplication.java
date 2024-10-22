package net.repos.customerservice;

import net.repos.customerservice.Dao.entities.Customer;
import net.repos.customerservice.Dao.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(Customer.builder().name("X").email("X@gmail.com").build());
			customerRepository.save(Customer.builder().name("Y").email("Y@gmail.com").build());
		};
	}
}
