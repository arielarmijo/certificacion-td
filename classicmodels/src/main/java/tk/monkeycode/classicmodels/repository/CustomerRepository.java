package tk.monkeycode.classicmodels.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tk.monkeycode.classicmodels.domain.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	List<Customer> findAllByOrderByCustomerName();

}
