package com.produtos.apirest.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



/**
 * 
 * Essa classe quando esta com a anotação Entity
 * significa ela vai ter uma relação com
 * uma entidade(tabela)
 * o string boot vai criar automatico
 * @author pcosta
 *
 */
@Entity
@Table(name="TB_PRODUTO")	//essa aqui é a entidade que ela vai ta relacionada

public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * Esse id vai ser gerado auto no banco
	 * de dados.
	 * isso que significa @id e @generatevalue(strategy = GenerationType.AUTO)
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//Crianado a tabela pelo springBoot
	private Long id;
	@NotNull	//Estou dizendo que esse campo não pode fica fazio
	private String nome;
	@NotNull	//Estou dizendo que esse campo não pode fica fazio
	private BigDecimal quantidade;
	@NotNull	//Estou dizendo que esse campo não pode fica fazio
	private BigDecimal valor;
	
	
	
	//get e set na Classe
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
	
}
