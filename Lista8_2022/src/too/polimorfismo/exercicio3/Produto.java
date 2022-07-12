package too.polimorfismo.exercicio3;

public class Produto {
	private String nome, unidade, marcaProduto;
	private float preco;
	private int quantidade;
	
	public Produto() {
		nome = marcaProduto = "";
	}

	public Produto(String nome, String unidade, String marcaProduto, float preco, int quantidade) {
		this.nome = nome;
		this.unidade = unidade;
		this.marcaProduto = marcaProduto;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return String.format("Nome: %s, Unidade: %s, Marca do Produto: %s, preco: %,1.2f, quantidade: %d", nome, unidade,
				marcaProduto, preco, quantidade);
	}
}
