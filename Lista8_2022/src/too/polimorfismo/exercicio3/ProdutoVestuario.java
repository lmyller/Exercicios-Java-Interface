package too.polimorfismo.exercicio3;

public final class ProdutoVestuario extends Produto {
	
	private String cor, tamanhoProduto;
	
	public ProdutoVestuario() {}

	public ProdutoVestuario(String nome, String unidade, String marcaProduto, float preco, int quantidade, String cor, String tamanhoProduto) {
		super(nome, unidade, marcaProduto, preco, quantidade);
		this.cor = cor;
		this.tamanhoProduto = tamanhoProduto;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTamanhoProduto() {
		return tamanhoProduto;
	}

	public void setTamanhoProduto(String tamanhoProduto) {
		this.tamanhoProduto = tamanhoProduto;
	}

	@Override
	public String toString() {
		return String.format("Cor: %s, Tamanho do produto: %s", cor, tamanhoProduto);
	}
}
