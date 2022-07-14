package too.polimorfismo.exercicio15;

public final class Cilindro extends Peca {
	
	private double raio, altura;

	public Cilindro() {}

	public Cilindro(String nome, int quantidade, Material material, double raio, double altura) {
		super(nome, quantidade, material);
		this.raio = raio;
		this.altura = altura;
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	@Override
	public double volume() {
		return Math.PI * (raio * raio) * altura;
	}

	@Override
	public double area() {
		return 2 * Math.PI * raio * (raio + altura);
	}

	@Override
	public String toString() {
		return String.format("Raio: %,1.2f, Altura: %,1.2f", raio, altura);
	}
}
