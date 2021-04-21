package tk.monkeycode.classicmodels.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import tk.monkeycode.classicmodels.service.ClassicModelsService;

@Controller
public class OrdersController {
	
	private static Logger logger = LoggerFactory.getLogger(OrdersController.class);
	
	private String titulo = "Classic Models";
	
	@Autowired
	private ClassicModelsService cmService;
	
	@ModelAttribute("titulo")
	public String setAttributes() {
		return titulo;
	}

	@GetMapping("/")
	public String mostrarOrdenes(@RequestParam(required = false) String orderStatus,
								 @RequestParam(required = false) Integer customerNumber,
								 Model model) {
		logger.info("Buscando ordenes para: {}, {}", orderStatus, customerNumber);
		model.addAttribute("ordenes", cmService.filtrarOrdenes(orderStatus, customerNumber));
		model.addAttribute("estados", cmService.obtenerEstados());
		model.addAttribute("clientes", cmService.obtenerClientes());
		model.addAttribute("orderStatus", orderStatus);
		model.addAttribute("customerNumber", customerNumber);
		return "ordenes";
	}
}
