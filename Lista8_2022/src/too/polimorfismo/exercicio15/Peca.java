package too.polimorfismo.exercicio15;

public abstract class Peca {
	
	private String nome;
	private int quantidade;
	private Material material;
	
	public Peca() {
		nome = "";
	}

	public Peca(String nome, int quantidade, Material material) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.material = material;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	public abstract double volume();
	
	public abstract double area();

	@Override
	public String toString() {
		return String.format("Nome: %s, Quantidade: %d, Material: %s", nome, quantidade, material);
	}

	public enum Material {
		FERRO("Ferro", 0, 7.8f, 0.7f), ALUMINIO("Alumínio", 1, 2.7f, 0.5f);
		
		private String tipoMaterial;
		private int numeroMaterial;
		private float peso, consumoTinta;
		
		private Material(String tipoMaterial, int numeroMaterial, float peso, float consumoTinta) {
			this.tipoMaterial = tipoMaterial;
			this.numeroMaterial = numeroMaterial;
			this.peso = peso;
			this.consumoTinta = consumoTinta;
		}

		public String getTipoMaterial() {
			return tipoMaterial;
		}

		public int getNumeroMaterial() {
			return numeroMaterial;
		}

		public float getPeso() {
			return peso;
		}

		public float getConsumoTinta() {
			return consumoTinta;
		}
	}
}
