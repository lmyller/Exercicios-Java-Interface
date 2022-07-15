package too.interfaces.entradaesaida;

import static javax.swing.JOptionPane.*;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EntradaESaida {
	
	public static final int FECHAR_JANELA = CLOSED_OPTION;
	
	public static int menu(String mensagem, String titulo, String[] opcoes) {
		return showOptionDialog(null, mensagem, titulo, DEFAULT_OPTION, QUESTION_MESSAGE, null, opcoes, opcoes[0]);
	}
	
	public static String lerString(String mensagem, String titulo) {
		return showInputDialog(null, mensagem, titulo, QUESTION_MESSAGE);
	}
	
	public static Integer lerNumeroInteiro(String mensagem, String titulo) throws NumberFormatException {
		String string = lerString(mensagem, titulo);
		
		return string == null ? null : Integer.parseInt(string);
	}
	
	public static Float lerNumeroReal(String mensagem, String titulo) throws NumberFormatException {
		String string = lerString(mensagem, titulo);
		
		return string == null ? null : Float.parseFloat(string);
	}
	
	public static void exibirMensagem(String mensagem, String titulo, int tipoMensagem) {
		showMessageDialog(null, mensagem, titulo, tipoMensagem);
	}
	
	public static void exibirMensagem(Object mensagem, String titulo, int tipoMensagem) {
		showMessageDialog(null, mensagem, titulo, tipoMensagem);
	}
	
	public static void exibirMensagemInformativa(String mensagem, String titulo) {
		exibirMensagem(mensagem, titulo, INFORMATION_MESSAGE);
	}
	
	public static void exibirMensagemDeErro(String mensagem, String titulo) {
		exibirMensagem(mensagem, titulo, ERROR_MESSAGE);
	}
	
	public static void exibirCaixaDeTexto(String mensagem, String titulo, int linhas, int colunas) {
		JTextArea textArea = new JTextArea(linhas, colunas);
		
		textArea.setEditable(false);
		textArea.setLineWrap(false);
		textArea.setText(mensagem);
		
		exibirMensagem(new JScrollPane(textArea), titulo, INFORMATION_MESSAGE);
	}
}
