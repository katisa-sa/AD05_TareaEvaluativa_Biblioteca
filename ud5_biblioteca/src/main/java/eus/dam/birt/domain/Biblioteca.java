package eus.dam.birt.domain;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Biblioteca extends BaseEntity{

	@Column
	private String name;
	
	@OneToMany
	@JoinColumn (name="biblioteca_id")
	List <Libro> libros = new ArrayList<>();

	public Biblioteca(String name) {
		super();
		this.name = name;
	}

}
