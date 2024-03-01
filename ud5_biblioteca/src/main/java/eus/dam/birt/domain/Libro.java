package eus.dam.birt.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Libro extends BaseEntity {

	@Column
	private String isbn;
	
	@Column
	private String titulo;
	
	@Column
	private String autor;

	@Column(name="anio_ed")
	private int anioEdicion;
	
	@ManyToOne
	@JoinColumn (name="biblioteca_id")
	private Biblioteca biblioteca;

	public Libro(String isbn, String titulo, String autor, int anio) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.anioEdicion = anio;
	}

}
