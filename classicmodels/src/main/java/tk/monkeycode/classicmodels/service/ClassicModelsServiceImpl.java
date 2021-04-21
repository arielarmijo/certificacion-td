package tk.monkeycode.classicmodels.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tk.monkeycode.classicmodels.domain.entity.Customer;
import tk.monkeycode.classicmodels.domain.entity.Order;
import tk.monkeycode.classicmodels.repository.CustomerRepository;
import tk.monkeycode.classicmodels.repository.OrderRepository;

@Slf4j
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
		return (List<Customer>) customerRepo.findAllByOrderByCustomerName();
	}

	@Override
	public List<Order> filtrarOrdenes(String status, Integer customerNumber, Date sinceOrderDate, Date untilOrderDate) {
		status = (status == null) ? "%" : status;
		customerNumber = (customerNumber == null) ? -1 : customerNumber;
		sinceOrderDate = (sinceOrderDate == null) ? orderRepo.findMinOrderDate() : sinceOrderDate;
		untilOrderDate = (untilOrderDate == null) ? orderRepo.findMaxOrderDate() : untilOrderDate;
		log.info("{}, {}, {}, {}", status, customerNumber, sinceOrderDate, untilOrderDate);
		List<Integer> customerNumbers = (customerNumber == -1) ? orderRepo.findCustomerNumbers() : Arrays.asList(customerNumber);
		return orderRepo.buscarOrden(status, customerNumbers, sinceOrderDate, untilOrderDate);
	}

}
