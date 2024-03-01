package eus.dam.birt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eus.dam.birt.domain.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer>{

}
