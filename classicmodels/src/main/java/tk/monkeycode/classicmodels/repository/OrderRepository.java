package tk.monkeycode.classicmodels.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tk.monkeycode.classicmodels.domain.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

	@Query("select distinct o.status from Order o order by o.status")
	List<String> findDistinctStatus();
	
	@Query(value = "SELECT * FROM orders WHERE status like ?1 AND customernumber in (?2) AND orderdate between ?3 and ?4",
		   nativeQuery = true)
	List<Order> buscarOrden(String status, List<Integer> customerNumber, Date since, Date until);
	
	@Query(value = "select customernumber from orders", nativeQuery = true)
	List<Integer> findCustomerNumbers();
	
	@Query(value = "select max(orderdate) from orders", nativeQuery = true)
	Date findMaxOrderDate();
	
	@Query(value = "select min(orderdate) from orders", nativeQuery = true)
	Date findMinOrderDate();
	
}
