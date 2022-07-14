package too.polimorfismo.exercicio15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EstruturaMetalica implements Iterable<Peca>{
	
	List<Peca> pecasList;

	private EstruturaMetalica() {
		pecasList = new ArrayList<>();
	}
	
	public static EstruturaMetalica criarEstruturaMetalica() {
		return new EstruturaMetalica();
	}
	
	public void adicionarPeca(Peca peca) {
		pecasList.add(peca);
	}
	
	public Peca obterPeca(int posicao) {
		return pecasList.get(posicao);
	}
	
	public int quantidadePecas() {
		return pecasList.size();
	}

	@Override
	public Iterator<Peca> iterator() {
		return pecasList.iterator();
	}
	
	
}
