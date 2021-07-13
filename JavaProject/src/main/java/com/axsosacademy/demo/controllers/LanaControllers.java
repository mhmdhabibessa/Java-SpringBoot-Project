package com.axsosacademy.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsosacademy.demo.models.Category;
import com.axsosacademy.demo.models.Painting;
import com.axsosacademy.demo.services.CategoryService;
import com.axsosacademy.demo.services.PaintingService;
import com.axsosacademy.demo.services.UserService;
import com.axsosacademy.demo.validetors.UserValidator;

@Controller
public class LanaControllers {
    private final UserService userService;
    private final UserValidator userValidator;
    private final CategoryService cateServ;
    private final PaintingService paintServ;
    
	public LanaControllers(UserService userService, UserValidator userValidator, CategoryService cateServ,
			PaintingService paintServ) {
		
		this.userService = userService;
		this.userValidator = userValidator;
		this.cateServ = cateServ;
		this.paintServ = paintServ;
	}


	@RequestMapping("/category/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category cat = cateServ.findCategoryById(id);
		model.addAttribute("category",cat);
		List<Painting> paintings = cat.getPaintings();
		model.addAttribute("paintings", paintings);
		System.out.println(paintings);
		List <Category> categories = cateServ.getAllCategories();
		model.addAttribute("categories" , categories);
		return"categoryShow.jsp";
	}
    

}
