package tk.monkeycode.classicmodels.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.monkeycode.classicmodels.domain.entity.Customer;
import tk.monkeycode.classicmodels.domain.entity.Order;
import tk.monkeycode.classicmodels.repository.CustomerRepository;
import tk.monkeycode.classicmodels.repository.OrderRepository;

@Service
public class ClassicModelsServiceImpl implements ClassicModelsService {

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public List<Order> obtenerOrdenes() {
		return (List<Order>) orderRepo.findAll();
	}
	
	@Override
	public List<String> obtenerEstados() {
		return orderRepo.findDistinctStatus();
	}

	@Override
	public List<Customer> obtenerClientes() {
		return (List<Customer>) customerRepo.findAll();
	}

	@Override
	public List<Order> filtrarOrdenes(String status, Integer customerNumber) {
		status = (status == null) ? "%" : status;
		customerNumber = (customerNumber == null) ? -1 : customerNumber;
		List<Integer> customerNumbers = (customerNumber == -1) ? orderRepo.findCustomerNumbers() : Arrays.asList(customerNumber);
		return orderRepo.buscarOrden(status, customerNumbers);
	}

}
