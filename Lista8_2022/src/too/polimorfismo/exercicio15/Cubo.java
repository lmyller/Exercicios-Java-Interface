package too.polimorfismo.exercicio15;

public final class Cubo extends Peca {
	
	private double aresta;

	public Cubo() {	}

	public Cubo(String nome, int quantidade, Material material, double aresta) {
		super(nome, quantidade, material);
		this.aresta = aresta;
	}

	public double getAresta() {
		return aresta;
	}

	public void setAresta(double aresta) {
		this.aresta = aresta;
	}
	
	@Override
	public double volume() {
		return aresta * aresta * aresta;
	}

	@Override
	public double area() {
		return 6 * (aresta * aresta);
	}

	@Override
	public String toString() {
		return String.format("Aresta: %,1.2f", aresta);
	}
}
