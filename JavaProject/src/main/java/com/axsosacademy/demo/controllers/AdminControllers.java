package com.axsosacademy.demo.controllers;



import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.axsosacademy.demo.models.Category;
import com.axsosacademy.demo.models.FileUploadUtil;
import com.axsosacademy.demo.models.Painting;
import com.axsosacademy.demo.models.User;
import com.axsosacademy.demo.services.CategoryService;
import com.axsosacademy.demo.services.PaintingService;
import com.axsosacademy.demo.services.UserService;
import com.axsosacademy.demo.validetors.UserValidator;

@Controller
public class AdminControllers {
  

    private final UserService userService;
    private final PaintingService paintingService;
    private final UserValidator userValidator;
    private final CategoryService categoryService;
    

public AdminControllers(UserService userService, PaintingService paintingService, UserValidator userValidator,
			CategoryService categoryService) {
		this.userService = userService;
		this.paintingService = paintingService;
		this.userValidator = userValidator;
		this.categoryService = categoryService;
	}


//	Add Painting ------------------------------------------------------------------------------------
	@RequestMapping("/admin/add_painting")
    public String addPaintingPage(@ModelAttribute("painting") Painting painting, Model model, Object List) {
		List <Category> categories = categoryService.getAllCategories();
		model.addAttribute("categories" , categories);
        return "addPainting.jsp";
    } 
	

    @PostMapping("/admin/add_painting")
    public String addPainting(@Valid @ModelAttribute("painting") Painting painting, BindingResult result, Model model, HttpSession session) {
        System.out.println("Create a painting");
        
        if (result.hasErrors()) {
        	System.out.println("error");
        	List <Category> categories = categoryService.getAllCategories();
    		model.addAttribute("categories" , categories);
            return "addPainting.jsp";
        } 
        try {
        System.out.println(painting.getId());
        paintingService.addPainting(painting);
        System.out.println("created");
        
        }
        catch(Exception e) {
        	List <Category> categories = categoryService.getAllCategories();
    		model.addAttribute("categories" , categories);
    		
            return "addPainting.jsp";
        }
        return "redirect:/admin/show_paintings";

    }
//    --------------------------------------------------------------------------------------------------
//	Show All Paintings ------------------------------------------------------------------------------------
	@RequestMapping("/admin/show_paintings")
    public String showPaintingPage(Model model) {
		List <Painting> paintings = paintingService.getAllPaintings();
		model.addAttribute("paintings" , paintings);
        return "show_paintings.jsp";
    }
	
//	Delete a Painting ------------------------------------------------------------------------------------
	@RequestMapping("/admin/paintings/{id}/delete")
    public String deletePainting(@PathVariable("id") long id) {
		paintingService.deletePaintning(id);
        return "redirect:/admin/show_paintings";
    }
//  --------------------------------------------------------------------------------------------------
    
//	Add Category ------------------------------------------------------------------------------------
	@RequestMapping("/admin/add_category")
    public String addCategoryPage(@ModelAttribute("category") Category category) {
        return "addCategory.jsp";
    } 
	
    @PostMapping("/admin/add_category")
    public String addCategory(@Valid @ModelAttribute("category") Category category,
    		BindingResult result, Model model,
    		HttpSession session, @RequestParam("pic") MultipartFile multipartFile)throws IOException {
        System.out.println("Create a Category");
        //System.out.println( multipartFile instanceof MultipartFile);
        if (result.hasErrors()) {
        	System.out.println("errors: ");
        	System.out.print(result.getAllErrors().toString());
            //return "addCategory.jsp";
        } 
        try {
//        		MultipartFile multipartFile = null;
        	 String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        	 System.out.println(fileName);
    		 category.setPic(fileName);
    		 
    		 Category savedCategory = categoryService.addCategory(category);
    	       System.out.println(savedCategory.toString());

    		 String uploadDir = "category-photos/" + savedCategory.getId();
    		 
    		 FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        System.out.println("created");
        return "redirect:/admin/show_categories";
        }
        catch(Exception e){
        	model.addAttribute("er", "There is a problem in adding the category!");
        	return "addCategory.jsp";
        }
        
        
        
        
        
    }
//  --------------------------------------------------------------------------------------------------
//	Show All Categories ------------------------------------------------------------------------------------
	@RequestMapping("/admin/show_categories")
    public String showCategoriesPage(Model model) {
		List <Category> categories = categoryService.getAllCategories();
		model.addAttribute("categories" , categories);
        return "show_categories.jsp";
    }
	

//	Delete a Category ------------------------------------------------------------------------------------
	@RequestMapping("/admin/categories/{id}/delete")
    public String deleteCategory(@PathVariable("id") long id) {
		categoryService.deleteCategory(id);
        return "redirect:/admin/show_categories";
    }


    
//	 @RequestMapping("/category/{id}/details")
//	    public String index(Model model , Long id) {
//	        List<Painting> panting =  paintingService.findPaintingById(id);
//	        model.addAttribute("panting", panting);
//	        return "/books/index.jsp";
//	    }

	 @RequestMapping("/category/details")
	 public String showitemis() {
		 return "category_information.jsp";
	 }


	
//	Show All Users ------------------------------------------------------------------------------------
	@RequestMapping("/admin/users")
    public String showUsersPage(Model model) {
		List <User> users = userService.getAll();
		model.addAttribute("users" , users);
        return "show_users.jsp";
    }
//	Delete a User ------------------------------------------------------------------------------------
	@RequestMapping("/admin/users/{id}/delete")
    public String deleteUSer(@PathVariable("id") long id) {
		userService.deleteUser(id);
        return "redirect:/admin/users";
    }
	
//	Add an Admin Page ------------------------------------------------------------------------------------
	@RequestMapping("/admin/add_admin")
    public String addAdminPage(Model model) {
		List <User> users = userService.getNonAdmin();
		model.addAttribute("users" , users);
        return "add_admin.jsp";
    }
//	Add an Admin ------------------------------------------------------------------------------------
	@RequestMapping("/admin/users/{id}/make_admin")
    public String addAdmin(@PathVariable("id") long id) {
		userService.addAdmin(id);
        return "redirect:/admin";
    }
    

}

