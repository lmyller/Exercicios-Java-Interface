package too.polimorfismo.exercicio5;

import static too.interfaces.entradaesaida.EntradaESaida.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import too.polimorfismo.exercicio3.Produto;
import too.polimorfismo.exercicio3.ProdutoAlimenticio;
import too.polimorfismo.exercicio3.ProdutoVestuario;

public class ControleDeEstoque {

	private static final String TITULO = "Controle de estoque", 
								ESCOLHA_OPCAO = "Escolha uma opcao",
								CADASTRAR = "Cadastrar",
								CONSULTAR_NOME = "Consultar por nome",
								CONSULTAR_DATA_VALIDADE = "Consultar por data de validade",
								ALTERAR = "Alterar",
								EXCLUIR = "Exclui",
								RELATORIO = "Relatório",
								RELATORIO_NOME = "Relatório por nome",
								RELATORIO_QUANTIDADE = "Relatório por quantidade",
								RELATORIO_DATA_FABRICACAO = "Relatório por data de fabricação",
								RELATORIO_TAMANHO = "Relatório por tamanho",
								NOME_PRODUTO = "Nome do produto:",
								PRECO_UNITARIO = "Preço unitário:",
								PRECO_INVALIDO = "Preço inválido!",
								QUANTIDADE_ESTOQUE = "Quantidade em estoque:",
								QUANTIDADE_ESTOQUE_INVÁLIDA = "Quantidade estoque inválida!",
								UNIDADE = "Unidade:",
								MARCA_PRODUTO = "Marca do produto:",
								PRODUTO_ALIMENTICIO = "Produto alimentício",
								PRODUTO_VESTUARIO = "Produto vestuário",
								PESO_PRODUTO = "Peso produto:",
								PESO_INVÁLIDO = "Peso inválido!",
								DATA_VALIDADE = "Data de validade:",
								DATA_FABRICACAO = "Data de fabricação:",
								DATA_INVALIDA = "Data inválida",
								TAMANHO_PRODUTO = "Tamanho do produto:",
								COR_PRODUTO = "Cor do produto:",
								PATTERN_DATA = "dd/MM/yyyy";
	
	private static final int COMANDO_CADASTRAR = 0,
							 COMANDO_CONSULTAR_NOME = 1,
							 COMANDO_CONSULTAR_DATA_VALIDADE = 2,
							 COMANDO_ALTERAR = 3,
							 COMANDO_EXCLUIR = 4,
							 COMANDO_RELATORIO = 5,
							 COMANDO_RELATORIO_NOME = 0,
							 COMANDO_RELATORIO_QUANTIDADE = 1,
							 COMANDO_RELATORIO_DATA_FABRICACAO = 2,
							 COMANDO_RELATORIO_TAMANHO = 3,
							 COMANDO_PRODUTO_ALIMENTICIO = 0,
							 COMANDO_PRODUTO_VESTUARIO = 1;
							
	public static void main(String[] args) {
		new ControleDeEstoque();
	}
	
	public ControleDeEstoque() {
		String[] opcoes = {CADASTRAR, CONSULTAR_NOME, CONSULTAR_DATA_VALIDADE, ALTERAR, EXCLUIR, RELATORIO};
		ProdutosList produtosList = ProdutosList.criarListaProdutos();
		
		while(true) {
			int escolha = menu(ESCOLHA_OPCAO, TITULO, opcoes);
			
			if(escolha == FECHAR_JANELA) break;
			
			switch(escolha) {
			case COMANDO_CADASTRAR: cadastrar(produtosList); break;
			}
		}
	}

	private void cadastrar(ProdutosList produtosList) {
		String nomeProduto, marcaProduto, unidade;
		String[] opcoesProduto = {PRODUTO_ALIMENTICIO, PRODUTO_VESTUARIO};
		Float preco;
		Integer quantidade, escolhaTipoProduto;
		Produto produto;
		
		if((nomeProduto = lerStringProduto(NOME_PRODUTO, TITULO)) == null) return;
			
		if((marcaProduto = lerStringProduto(MARCA_PRODUTO, TITULO)) == null) return;
		
		if((unidade = lerStringProduto(UNIDADE, TITULO)) == null) return;
		
		if((preco = lerNumeroRealProduto(PRECO_UNITARIO, PRECO_INVALIDO, TITULO)) == null) return;
		
		if((quantidade = lerNumeroInteiroProduto(QUANTIDADE_ESTOQUE, TITULO)) == null) return;
		
		escolhaTipoProduto = menu(ESCOLHA_OPCAO, TITULO, opcoesProduto);
		if(escolhaTipoProduto == FECHAR_JANELA) return;
		
		if(escolhaTipoProduto == COMANDO_PRODUTO_ALIMENTICIO)
			produto = cadastrarProdutoAlimenticio(nomeProduto, marcaProduto, unidade, preco, quantidade);
		
		else
			produto = cadastrarProdutoVestuario(nomeProduto, marcaProduto, unidade, preco, quantidade);
			
		if(produto == null)
			return;
		
		produtosList.adicionarProduto(produto);
	}

	private String lerStringProduto(String mensagem, String titulo) {
		while(true) {
			String nome = lerString(mensagem, titulo);
			
			if(!nome.isBlank())
				return nome;
		}
	}
	

	private Float lerNumeroRealProduto(String mensagem, String mensagemErro, String titulo) {
		while(true){
			try {
				Float preco = lerNumeroReal(mensagem, titulo);
				
				if(preco == null) return null;
				
				return preco > 0 ? preco : 0;
					
			} catch (NumberFormatException e) {
				exibirMensagemDeErro(mensagemErro, titulo);
			}
		}
	}
	
	private Integer lerNumeroInteiroProduto(String mensagem, String titulo) {
		while(true) {
			try {
				Integer quantidade = lerNumeroInteiro(mensagem, titulo);
				
				if(quantidade == null) return null;
				
				return quantidade > 0 ? quantidade : 0;
				
			} catch (NumberFormatException e) {
				exibirMensagemDeErro(QUANTIDADE_ESTOQUE_INVÁLIDA, titulo);
			}
		}
	}
	
	private Produto cadastrarProdutoAlimenticio(String nomeProduto, String marcaProduto, String unidade, Float preco,
			Integer quantidade) {
		Float peso;
		LocalDate dataFabricacao, dataValidade;
		
		if((peso = lerNumeroRealProduto(PESO_PRODUTO, PESO_INVÁLIDO, TITULO)) == null) return null;
		
		if((dataFabricacao = lerData(DATA_FABRICACAO, TITULO)) == null) return null;
		
		if((dataValidade = lerData(DATA_VALIDADE, TITULO)) == null) return null;
		
		return criarProdutoAlimenticio(nomeProduto, marcaProduto, unidade, preco, quantidade, peso, dataFabricacao, dataValidade);
	}
	
	private Produto cadastrarProdutoVestuario(String nomeProduto, String marcaProduto, String unidade, Float preco,
			Integer quantidade) {
		String tamanho, corProduto;
		
		if((tamanho = lerStringProduto(TAMANHO_PRODUTO, TITULO)) == null) return null;
		
		if((corProduto = lerStringProduto(COR_PRODUTO, TITULO)) == null) return null;
		
		return criarProdutoVestuario(nomeProduto, marcaProduto, unidade, preco, quantidade, corProduto, tamanho);
	}

	private Produto criarProdutoAlimenticio(String nomeProduto, String marcaProduto, String unidade, Float preco,
			Integer quantidade, Float peso, LocalDate dataFabricacao, LocalDate dataValidade) {
		return new ProdutoAlimenticio(nomeProduto, unidade, marcaProduto, preco, quantidade, peso, dataFabricacao, dataValidade);
	}

	private Produto criarProdutoVestuario(String nomeProduto, String marcaProduto, String unidade, Float preco,
			Integer quantidade, String corProduto, String tamanho) {
		return new ProdutoVestuario(nomeProduto, unidade, marcaProduto, preco, quantidade, corProduto, tamanho);
	}
	
	private LocalDate lerData(String mensagem, String titulo) {
		while(true) {
			try {
				String string = lerStringProduto(mensagem, titulo);
				
				if(string == null) return null;
				
				LocalDate localDate = LocalDate.parse(string, DateTimeFormatter.ofPattern(PATTERN_DATA));
				return localDate;
			} catch (DateTimeParseException e) {
				exibirMensagemDeErro(DATA_INVALIDA, titulo);
			}
		}
	}
}
