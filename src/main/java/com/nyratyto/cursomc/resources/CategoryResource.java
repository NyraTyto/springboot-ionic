package com.nyratyto.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nyratyto.cursomc.domain.Category;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<Category> list() {
		
		Category cat1 = new Category(1, "Informática");
		Category cat2 = new Category(1, "Escritório");
		
		List<Category> categories = new ArrayList<>();
		categories.add(cat1);
		categories.add(cat2);
		
		return categories;
	}
}
