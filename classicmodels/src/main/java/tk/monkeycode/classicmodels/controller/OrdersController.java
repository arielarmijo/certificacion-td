package tk.monkeycode.classicmodels.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import tk.monkeycode.classicmodels.domain.entity.Order;
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
								 @RequestParam(required = false) Date desde,
								 @RequestParam(required = false) Date hasta,
								 Model model) {
		SimpleDateFormat dateFmt = new SimpleDateFormat ("yyyy-MM-dd");
		List<Order> ordenes = cmService.filtrarOrdenes(orderStatus, customerNumber, desde, hasta);
		logger.info("ordenes para {}, {}, {}, {}: {}", orderStatus, customerNumber, desde, hasta, ordenes.size());
		model.addAttribute("ordenes", ordenes);
		model.addAttribute("estados", cmService.obtenerEstados());
		model.addAttribute("clientes", cmService.obtenerClientes());
		model.addAttribute("orderStatus", orderStatus);
		model.addAttribute("customerNumber", customerNumber);
		model.addAttribute("desde", desde != null ? dateFmt.format(desde) : "");
		model.addAttribute("hasta", hasta != null ? dateFmt.format(hasta) : "");
		return "ordenes";
	}
}
