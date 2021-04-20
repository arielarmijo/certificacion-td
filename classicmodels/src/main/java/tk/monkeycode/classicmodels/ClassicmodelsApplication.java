package tk.monkeycode.classicmodels;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import tk.monkeycode.classicmodels.domain.Descuento;
import tk.monkeycode.classicmodels.domain.DescuentoComplejo;
import tk.monkeycode.classicmodels.domain.DescuentoSimple;
import tk.monkeycode.classicmodels.domain.GeneradorPrecios;

@SpringBootApplication
public class ClassicmodelsApplication extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClassicmodelsApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ClassicmodelsApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Mustra cabecera
		System.out.println("\n");
		System.out.println("--------------------------------------");
		System.out.println("Demostracion Calculadora de Descuentos");
		System.out.println("--------------------------------------");
		System.out.println();
		
		// Genera y muestra 5 precios aleatorios
		System.out.println("Tomando 5 precios aleatorios...");
		List<Integer> precios = GeneradorPrecios.generarPreciosCaso();
//		List<Integer> precios = GeneradorPrecios.generarPreciosAleatorios(5, 1000, 10000);
		precios.forEach(precio -> System.out.print(String.format("$%,d ", precio)));
		System.out.println("\n");
		
		// Descuentos
		Descuento dctoSimple = new DescuentoSimple();
		Descuento dctoComplejo = new DescuentoComplejo();
		System.out.println(String.format("Descuento con Algoritmo Simple: $%,d", dctoSimple.calcularDescuento(precios)));
		System.out.println(String.format("Descuento con Algoritmo Complejo: $%,d", dctoComplejo.calcularDescuento(precios)));
		
	}
	
}
