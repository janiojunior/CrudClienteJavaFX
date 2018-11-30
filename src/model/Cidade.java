package model;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Cidade extends DefaultEntity<Cidade> {
	
	private static final long serialVersionUID = -477803445713636937L;
	
	private String nome;
	
	@Embedded
	private Estado estado;
	
	private String pais;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
