package tk.monkeycode.classicmodels.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GeneradorPrecios {
	
	private static final Random random = new Random();
	
	public static List<Precio> generarPreciosAleatorios(int n, int start, int end) {
		return random.ints(n, start, end+1).mapToObj(precio -> new Precio(precio)).collect(Collectors.toList());
	}
	
	public static List<Precio> generar5PreciosAleatorios(int start, int end) {
		return generarPreciosAleatorios(5, start, end);
	}
	
	public static List<Precio> generarPreciosCaso() {
		return Arrays.asList(new Precio(2432), new Precio(6523), new Precio(8172), new Precio(3341), new Precio(9832));
	}
	
}
