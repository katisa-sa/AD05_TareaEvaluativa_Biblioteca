package eus.dam.birt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import eus.dam.birt.domain.Libro;
import eus.dam.birt.repository.LibroRepository;

@Controller
public class LibroController {
	
	@Autowired
	private LibroRepository libroRepository;
	
	@GetMapping("/libros")
	public String getLibros(Model model) {
		model.addAttribute("libros",libroRepository.findAll());
		return "libros/list";
	}
	
	@GetMapping("/libros/new")
	public String initCreationForm(Model model) {
		Libro libro = new Libro();
		model.addAttribute("libro",libro);
		return "libros/libroForm";
	}
	
	@PostMapping ("libros/new/submit")
	public String submitCreationForm(@ModelAttribute Libro libro) {
		libroRepository.save(libro);
		return "redirect:/libros";
	}
	
	@GetMapping ("libros/edit/{id}")
	public String initEditForm(@PathVariable("id")int id, Model model) {
		model.addAttribute("libro", libroRepository.findById(id));
		return "libros/libroForm";
	}
	
	@GetMapping ("libros/delete/{id}")
	public String initDelete(@PathVariable ("id") int id) {
		libroRepository.deleteById(id);
		return "redirect:/libros";
		
	}
}
