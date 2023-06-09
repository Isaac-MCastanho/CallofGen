package com.generation.callofgen.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Atributo nome do produto é obrigatório")
	@Size(min = 5, max = 100, message = "Atributo nome do produto deve conter no mínimo 5 caracteres e no máximo 100 caracteres")
	private String nome;

	@NotNull(message = "Atributo descrição é obrigatório")
	private String descricao;

	@Positive
	private Integer quantidade;

	@Positive
	@Digits(integer = 6, fraction = 2, message = "O preço é obrigatorio")
	private BigDecimal valor;

	private String foto;
	
	@NotNull(message="A classificação indicativa é obrigatoria")
	//@Size(min=3,max=18,message="A classificação indicativa deve ser entre 3 e 18 anos")
	private Integer idadeIndicada;

	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Integer getIdadeIndicada() {
		return idadeIndicada;
	}

	public void setIdadeIndicada(Integer idadeIndicada) {
		this.idadeIndicada = idadeIndicada;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



}
