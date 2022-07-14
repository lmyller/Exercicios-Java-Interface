package too.polimorfismo.exercicio5;

import java.util.ArrayList;
import java.util.List;

import too.polimorfismo.exercicio3.Produto;

public class ProdutosList {
	
	List<Produto> produtos;

	private ProdutosList() {
		produtos = new ArrayList<>();
	}
	
	public static ProdutosList criarListaProdutos() {
		return new ProdutosList();
	}
	
	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}
	
	public void alterarProduto(Produto produto, int posicao) {
		produtos.set(posicao, produto);
	}
	
	public Produto obterProduto(int posicao) {
		return produtos.get(posicao);
	}
	
	public void excluirProduto(int posicao) {
		produtos.remove(posicao);
	}
	
	public int quantidadeProdutos() {
		return produtos.size();
	}
}
