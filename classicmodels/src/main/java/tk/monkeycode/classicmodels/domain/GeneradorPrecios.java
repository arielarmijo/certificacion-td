package tk.monkeycode.classicmodels.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GeneradorPrecios {
	
	private static final Random random = new Random();
	
	public static List<Integer> generarPreciosAleatorios(int n, int start, int end) {
		return random.ints(n, start, end+1).boxed().collect(Collectors.toList());
	}
	
	public static List<Integer> generarPreciosCaso() {
		return Arrays.asList(2432, 6523, 8172, 3341, 9832);
	}

}
