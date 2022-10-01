package com.api.ouvidoriacontrol.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_OUVIDORIA")
public class OuvidoriaModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private UUID id;
	 
	 @Column(nullable = false, unique = false, length = 60)
	 private String usuario;
	 
	 @Column(nullable = false, unique = true, length = 11)
	 private String cpf;
	 
	 @Column(nullable = false, unique = false, length = 12)
	 private String tipo;
	 
	 @Column(nullable = false, unique = false, length = 200)
	 private String descricao;
	 
	 @Column(nullable = false)
	 private LocalDateTime dataRegistro;
	 
	 @Column(nullable = true, unique = false, length = 50)
	 private String nomeCurso;
	 
	 @Column(nullable = true, unique = false, length = 1)
	 private boolean resolvido;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	 
}
