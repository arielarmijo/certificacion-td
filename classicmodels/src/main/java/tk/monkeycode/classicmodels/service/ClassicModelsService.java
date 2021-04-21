package tk.monkeycode.classicmodels.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import tk.monkeycode.classicmodels.domain.entity.Customer;
import tk.monkeycode.classicmodels.domain.entity.Order;

public interface ClassicModelsService {

	List<Order> obtenerOrdenes();
	List<String> obtenerEstados();
	List<Customer> obtenerClientes();
	List<Order> filtrarOrdenes(String status, Integer customerNumber, Date sinceOrderDate, Date untilOrderDate);
	
}
