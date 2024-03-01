package eus.dam.birt.bootstrap;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import eus.dam.birt.domain.Biblioteca;
import eus.dam.birt.domain.Libro;
import eus.dam.birt.repository.BibliotecaRepository;
import eus.dam.birt.repository.LibroRepository;


@Component
public class BootStrapData implements CommandLineRunner{

	@Autowired 
	private LibroRepository libroRepository;
	
	@Autowired
	private BibliotecaRepository bibliotecaRepository;
	
	@Override
	@Transactional
	
	public void run (String... arg0) throws Exception{
		
		Libro libro1 = new Libro ("36598741258POL","El resplandor","Stephen King", 1982);
		Libro libro2 = new Libro ("34453464454HBN","La lista del juez","Jonh Grisham", 2022);
		Libro libro3 = new Libro (" 978-84-08-28455-0","Alas de Hierro","Rebecca Yarros", 2023 );
		Biblioteca biblioteca1 = new Biblioteca ("Sansomendi");		
		Biblioteca biblioteca2 = new Biblioteca ("Arana");
		
		libro1.setBiblioteca(biblioteca1);
		biblioteca1.getLibros().add(libro1);
		biblioteca1.getLibros().add(libro1);
		libro2.setBiblioteca(biblioteca1);
		biblioteca2.getLibros().add(libro3);
		libro3.setBiblioteca(biblioteca2);
		
		// Guardar entidades
        bibliotecaRepository.save(biblioteca1);
        bibliotecaRepository.save(biblioteca2);
        libroRepository.save(libro1);
        libroRepository.save(libro2);
        libroRepository.save(libro3);
	}
}
