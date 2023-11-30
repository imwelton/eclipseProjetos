package br.unigoias.canil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Caes {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	@ManyToOne
	@JoinColumn(name="racas_id")
	private Racas raca;
	private String sexo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Racas getRaca() {
		return raca;
	}
	public void setRaca(Racas raca) {
		this.raca = raca;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Caes(int id, String nome, Racas raca, String sexo) {
		this.id = id;
		this.nome = nome;
		this.raca = raca;
		this.sexo = sexo;
	}
	public Caes() {
		super();
	}
}
