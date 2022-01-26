package org.farmaciagrupo2.farmaciaGrupo2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//criação da tabela e o nome dado a mesma

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	//criação da ID e geração de número automático
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//nome da categoria
	
	@NotBlank (message = "O atributo nome é obrigatório!")
	@Size(min = 2, max = 50, message = "O atributo título deve conter no mínimo 2 e no máximo 50 caracteres")
	private String nome;
	
	//descricao da categoria
	
	@NotBlank (message = "O atributo descricao é obrigatório!")
	@Size(min = 5, max = 100, message = "O atributo descricao deve conter no mínimo 2 e no máximo 50 caracteres")
	private String descricao;
	
	//anotação necessária para trazer informações da chave secundária
	//e anotação para que a aplicação não retorne informações em loop
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;

	//getters and setters
	
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

}
