package tk.monkeycode.classicmodels.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tk.monkeycode.classicmodels.domain.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

	@Query("select distinct o.status from Order o")
	List<String> findDistinctStatus();
	
	@Query(value = "SELECT * FROM orders WHERE status like ?1 AND customernumber in (?2)", nativeQuery = true)
	List<Order> buscarOrden(String status, List<Integer> customerNumber);
	
	@Query(value = "select customernumber from orders", nativeQuery = true)
	List<Integer> findCustomerNumbers();
	
}
