package too.polimorfismo.exercicio3;

import java.time.LocalDate;

public final class ProdutoAlimenticio extends Produto {

	private float peso;
	private LocalDate dataFabricacao, dataValidade;
	
	public ProdutoAlimenticio() {}

	public ProdutoAlimenticio(String nome, String unidade, String marcaProduto, float preco, int quantidade, float peso, LocalDate dataFabricacao,
							  LocalDate dataValidade) {
		super(nome, unidade, marcaProduto, preco, quantidade);
		this.peso = peso;
		this.dataFabricacao = dataFabricacao;
		this.dataValidade = dataValidade;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	@Override
	public String toString() {
		return String.format("Peso: %,1.2f, Data de fabricacao: %s, Data de validade: %s", peso, dataFabricacao, dataValidade);
	}
}
