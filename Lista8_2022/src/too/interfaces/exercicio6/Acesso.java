package too.interfaces.exercicio6;

public interface Acesso {
	Object criar();
	
	Object criar(String nome);
		
	Object abrir();
	
	Object abrir(String nome);
	
	void escrever(String nome, Object escrita);
	
	void escrever(Object escrita);
	
	Object ler();
	
	Object ler(String nome);
	
	void fechar();
	
	void fechar(String nome);
}
