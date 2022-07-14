package too.polimorfismo.exercicio15;

public final class Paralelepipedo extends Peca {

	private double altura, largura, profundidade;

	public Paralelepipedo() { }

	public Paralelepipedo(String nome, int quantidade, Material material, double altura, double largura, double profundidade) {
		super(nome, quantidade, material);
		this.altura = altura;
		this.largura = largura;
		this.profundidade = profundidade;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getLargura() {
		return largura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public double getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(double profundidade) {
		this.profundidade = profundidade;
	}
	
	@Override
	public double volume() {
		return altura * largura * profundidade;
	}

	@Override
	public double area() {
		return 2 * ((altura * largura) + (altura * profundidade) + (largura * profundidade));
	}

	@Override
	public String toString() {
		return String.format("Altura: %,1.2f, Largura: %,1.2f, Profundidade: %,1.2f", altura, largura, profundidade);
	}
}
