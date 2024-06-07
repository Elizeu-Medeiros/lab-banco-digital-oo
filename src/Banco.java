import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Banco {

	private String nome;
	private List<Conta> contas;

	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public void adicionarConta(Conta conta) {
		contas.add(conta);
	}

	/**
	 * @param filePath
	 */
	public void salvarDados(String filePath) {
		try (
				FileOutputStream fileOut = new FileOutputStream(filePath);
				ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
			out.writeObject(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Banco carregarDados(String filePath) {
		Banco banco = null;

		try (
				FileInputStream fileIn = new FileInputStream(filePath);
				ObjectInputStream in = new ObjectInputStream(fileIn)) {
			banco = (Banco) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return banco;
	}

}
