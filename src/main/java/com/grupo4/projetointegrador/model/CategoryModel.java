package com.grupo4.projetointegrador.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_category")
public class CategoryModel {
	
	// attributes
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private long idCategory;

			@NotBlank(message = "Informe o Gênero")
			private String genre;

			@OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
			@JsonIgnoreProperties({ "category" })
			private List<BookModel> book;

			public CategoryModel() {
			}

			public CategoryModel(String genre) {
				this.genre = genre;
			}

			public long getIdCategory() {
				return idCategory;
			}

			public void setIdCategory(long idCategory) {
				this.idCategory = idCategory;
			}

			public String getGenre() {
				return genre;
			}

			public void setGenre(String genre) {
				this.genre = genre;
			}

			public List<BookModel> getBook() {
				return book;
			}

			public void setBook(List<BookModel> book) {
				this.book = book;
			}

}
