package tk.monkeycode.classicmodels.domain;

/**
 * Precio es un valor entero mayor o iguala 0.
 * 
 * @author aarmijo
 *
 */
public class Precio {

	private int precio;
	
	public Precio(int precio) {
		setPrecio(precio);
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		if (precio >= 0) {
			this.precio = precio;
		} else {
			throw new IllegalArgumentException("Precio no puede ser negativo.");
		}
	}

	@Override
	public String toString() {
		return String.valueOf(precio);
	}

}
