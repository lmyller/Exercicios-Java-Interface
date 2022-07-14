package too.polimorfismo.exercicio15;

import static too.interfaces.entradaesaida.EntradaESaida.FECHAR_JANELA;
import static too.interfaces.entradaesaida.EntradaESaida.exibirCaixaDeTexto;
import static too.interfaces.entradaesaida.EntradaESaida.lerNumeroInteiro;
import static too.interfaces.entradaesaida.EntradaESaida.lerNumeroReal;
import static too.interfaces.entradaesaida.EntradaESaida.menu;

import too.polimorfismo.exercicio15.Peca.Material;

public class EM implements Estrutura{
	
	private static final String TITULO = "Estrutura metálica",
								TIPO_PECA = "Tipo da peça:",
								QUANTIDADE_PECA = "Quantidade da peça",
								MATERIAL_PECA = "Material da peça",
								PECA_CILINDRO = "Cilindro",
								PECA_CUBO = "Cubo",
								PECA_PARALELEPIPEDO = "Paralelepípedo",
								RAIO_CILINDRO = "Raio do cilindro:",
								ALTURA_CILINDRO = "Altura do cilindro:",
								ARESTA_CUBO = "Aresta do cubo:",
								ALTURA_PARALELEPIPEDO = "Altura do paralelepípedo",
								LARGURA_PARALELEPIPEDO = "Largura do paralelepípedo",
								PROFUNDIDADE_PARALELEPIPEDO = "Profundidade do paralelepípedo",
								PESO_TOTAL = "Peso total: ",
								VOLUME_TOTAL = "Volume total: ",
								LATAS_TINTA_NECESSARIA = "Latas de tinta necessárias: ",
								VOLUME_TOTAL_CILINDRO = "Volume cilindro: ",
								VOLUME_TOTAL_CUBO = "Volume cubo: ",
								VOLUME_TOTAL_PARALELEPIPEDO = "Volume paralelepípedo: ";
	
	private static final int OPCAO_CILINDRO = 0,
							 OPCAO_CUBO = 1,
							 OPCAO_PARALELEPIPEDO = 2;
	
	public static void main(String[] args) {
		new EM();
		System.exit(0);
	}

	public EM() {
		int tipoPeca, quantidadePeca, materialPeca;
		Peca peca = null;
		EstruturaMetalica estruturaMetalica = EstruturaMetalica.criarEstruturaMetalica();
		String[] opcoesPeca = {PECA_CILINDRO, PECA_CUBO, PECA_PARALELEPIPEDO};
		String[] opcoesMaterial = {Material.FERRO.getTipoMaterial(), Material.ALUMINIO.getTipoMaterial()};
		
		while (true){
			if((tipoPeca = menu(TIPO_PECA, TITULO, opcoesPeca)) == FECHAR_JANELA) break;
			
			if((quantidadePeca = lerNumeroInteiro(QUANTIDADE_PECA, TITULO)) == FECHAR_JANELA) break;
			
			if((materialPeca = menu(MATERIAL_PECA, TITULO, opcoesMaterial)) == FECHAR_JANELA) break;
			
			switch (tipoPeca) {
			case OPCAO_CILINDRO: peca = criarCilindro(PECA_CILINDRO, quantidadePeca, materialPeca); break;
			case OPCAO_CUBO: peca = criarCubo(PECA_CUBO, quantidadePeca, materialPeca); break;
			case OPCAO_PARALELEPIPEDO: peca = criarParalelepipedo(PECA_PARALELEPIPEDO, quantidadePeca, materialPeca); break;
			}
			estruturaMetalica.adicionarPeca(peca);
		}
		formatarResultado(estruturaMetalica);	
	}

	private void formatarResultado(EstruturaMetalica estruturaMetalica) {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(String.format("%s%,1.2f\n", PESO_TOTAL, pesoEstrutura(estruturaMetalica)));
		stringBuilder.append(String.format("%s%,1.2f\n", VOLUME_TOTAL, volumeEstrutura(estruturaMetalica)));
		stringBuilder.append(String.format("%s%d\n", LATAS_TINTA_NECESSARIA, quantidadeTinta(estruturaMetalica)));
		stringBuilder.append(String.format("%s%,1.2f\n", VOLUME_TOTAL_CILINDRO, volumeCilindros(estruturaMetalica)));
		stringBuilder.append(String.format("%s%,1.2f\n", VOLUME_TOTAL_CUBO, volumeCubos(estruturaMetalica)));
		stringBuilder.append(String.format("%s%,1.2f\n", VOLUME_TOTAL_PARALELEPIPEDO, volumeParalelepipedos(estruturaMetalica)));
		
		exibirCaixaDeTexto(stringBuilder.toString(), TITULO, estruturaMetalica.quantidadePecas() * 6, 50);
	}

	private Peca criarCilindro(String pecaCilindro, int quantidadePeca, int materialPeca) {
		return new Cilindro(pecaCilindro, quantidadePeca, obterTipoMaterial(materialPeca), lerNumeroReal(RAIO_CILINDRO, TITULO), lerNumeroReal(ALTURA_CILINDRO, TITULO));
	}
	
	private Peca criarCubo(String pecaCilindro, int quantidadePeca, int materialPeca) {
		return new Cubo(pecaCilindro, quantidadePeca, obterTipoMaterial(materialPeca), lerNumeroReal(ARESTA_CUBO, TITULO));
	}
	
	private Peca criarParalelepipedo(String pecaCilindro, int quantidadePeca, int materialPeca) {
		return new Paralelepipedo(pecaCilindro, quantidadePeca, obterTipoMaterial(materialPeca), lerNumeroReal(ALTURA_PARALELEPIPEDO, TITULO), 
								  lerNumeroReal(LARGURA_PARALELEPIPEDO, TITULO), lerNumeroReal(PROFUNDIDADE_PARALELEPIPEDO, TITULO));
	}

	private Material obterTipoMaterial(int materialPeca) {
		return materialPeca == Material.FERRO.getNumeroMaterial() ? Material.FERRO : Material.ALUMINIO;
	}

	@Override
	public double pesoEstrutura(EstruturaMetalica estruturaMetalica) {
		double pesoTotal = 0;
		
		for(int indice = 0; indice < estruturaMetalica.quantidadePecas(); indice++) { 
			Peca peca = estruturaMetalica.obterPeca(indice);
			
			if(peca.getMaterial().getTipoMaterial().equals(Material.FERRO.getTipoMaterial())) {
				pesoTotal += Material.FERRO.getPeso() * peca.volume();
			}
			else
				pesoTotal += Material.ALUMINIO.getPeso() * peca.volume();
		}
		return pesoTotal;
	}

	@Override
	public double volumeEstrutura(EstruturaMetalica estruturaMetalica) {
		double volumerTotal = 0;
		
		for(int indice = 0; indice < estruturaMetalica.quantidadePecas(); indice++) 
			volumerTotal += estruturaMetalica.obterPeca(indice).volume();
		
		return volumerTotal;
	}

	@Override
	public int quantidadeTinta(EstruturaMetalica estruturaMetalica) {
		int lataDeTinta = 0; 
		double quantidadeTinta = obterQuantidadeTintaUsado(estruturaMetalica);
		
		while(quantidadeTinta > 0) {
			if(quantidadeTinta >= 5) {
				lataDeTinta++;
				quantidadeTinta -= 5;
				continue;
			}
			if(quantidadeTinta >= 2) {
				lataDeTinta++;
				quantidadeTinta -= 2;
				continue;
			}
			
			if(quantidadeTinta >= 0.5) {
				lataDeTinta++;
				quantidadeTinta -= 0.5;
				continue;
			}
			
			if(quantidadeTinta < 0.5){
				lataDeTinta++;
				break;
			}
		}
		
		return lataDeTinta;
	}

	private double obterQuantidadeTintaUsado(EstruturaMetalica estruturaMetalica) {
		double quantidadeTinta = 0;
		
		for(int indice = 0; indice < estruturaMetalica.quantidadePecas(); indice++) {
			Peca peca = estruturaMetalica.obterPeca(indice);
			if(peca.getMaterial().getTipoMaterial().equals(Material.FERRO.getTipoMaterial())) 
				quantidadeTinta += Material.FERRO.getConsumoTinta() * peca.area();
			
			else
				quantidadeTinta += Material.ALUMINIO.getConsumoTinta() * peca.area();
		}
		
		return quantidadeTinta;
	}

	@Override
	public double volumeCilindros(EstruturaMetalica estruturaMetalica) {
		double volume = 0;
		
		for(Peca peca : estruturaMetalica)
			if(peca.getNome().equals(PECA_CILINDRO))
				volume += peca.volume();
		
		return volume;
	}

	@Override
	public double volumeCubos(EstruturaMetalica estruturaMetalica) {
		double volume = 0;
		
		for(Peca peca : estruturaMetalica)
			if(peca.getNome().equals(PECA_CUBO))
				volume += peca.volume();
		
		return volume;
	}	

	@Override
	public double volumeParalelepipedos(EstruturaMetalica estruturaMetalica) {
		double volume = 0;
		
		for(Peca peca : estruturaMetalica)
			if(peca.getNome().equals(PECA_PARALELEPIPEDO))
				volume += peca.volume();
		
		return volume;
	}
}
