package tk.monkeycode.classicmodels.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class OrdersController {
	
	private String titulo = "Classic Models";
	
	private static Logger logger = LoggerFactory.getLogger(OrdersController.class);
	
	@ModelAttribute("titulo")
	public String setAttributes() {
		return titulo;
	}

	@GetMapping("/")
	public String mostrarOrdenes() {
		logger.info("Mostrando ordenes...");
		return "ordenes";
	}
}
