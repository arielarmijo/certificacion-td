package tk.monkeycode.classicmodels.repository;

import org.springframework.data.repository.CrudRepository;

import tk.monkeycode.classicmodels.domain.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
