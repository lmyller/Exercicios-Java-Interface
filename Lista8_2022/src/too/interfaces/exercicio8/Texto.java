package too.interfaces.exercicio8;

import too.interfaces.exercicio7.AcessoUniversal;

public class Texto extends AcessoUniversal {

	StringBuilder texto;
	
	@Override
	public Object criar() {
		return new StringBuilder();
	}

	@Override
	public void escrever(Object escrita) {
		texto.append(escrita);
	}

	@Override
	public Object ler() {
		return texto;
	}
}
