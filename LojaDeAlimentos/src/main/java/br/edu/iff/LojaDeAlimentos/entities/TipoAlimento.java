package br.edu.iff.LojaDeAlimentos.entities;

public enum TipoAlimento {

	Legume(1), Verdura(2), Laticionio(3), Fruta(4), Carne(5);

	private final int cod;

	private TipoAlimento(int cod) {
		this.cod = cod;
	}

	public int getCod() {
		return cod;
	}

	public static TipoAlimento toEnum(int code) {
		for (TipoAlimento f : TipoAlimento.values()) {
			if (f.getCod() == code) {
				return f;
			}
		}
		return null;
	}
}
