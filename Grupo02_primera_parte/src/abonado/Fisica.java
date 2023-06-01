package abonado;

public class Fisica extends Abonado {

	public Fisica(String nombre, int dni) {
		super(nombre, dni);
	}
	@Override
	public String toString() {
		return "tipoA: " + tipoAbonado() + super.toString();
	}
	public String tipoAbonado() {
		return "Fisica";
	}
	@Override
	public double valorTotal() {
		double suma = 0;
		for (int i = 0; i < this.lista.size(); i++) {
			suma += this.lista.get(i).getValorTotal();
		}
		return suma;
	}
	public Object clone() throws CloneNotSupportedException {
		Fisica clon = null;
		clon = (Fisica) super.clone();
		return clon;
	}
}
