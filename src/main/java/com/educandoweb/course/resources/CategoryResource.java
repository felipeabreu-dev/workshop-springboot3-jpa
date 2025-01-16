package com.educandoweb.course.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryResource{
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	ResponseEntity<List<Category>> findAll(){
		List<Category> obj = categoryService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/{id}")
	ResponseEntity<Optional<Category>> findById(@PathVariable Long id){
		Optional<Category> obj = categoryService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
