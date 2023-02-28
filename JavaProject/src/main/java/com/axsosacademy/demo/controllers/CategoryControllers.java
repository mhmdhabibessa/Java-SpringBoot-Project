package com.axsosacademy.demo.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.axsosacademy.demo.repositories.CategoryRepository;
import com.axsosacademy.demo.services.CategoryService;
import com.axsosacademy.demo.services.PaintingService;
import com.axsosacademy.demo.services.UserService;
import com.axsosacademy.demo.validetors.UserValidator;

@Controller
public class CategoryControllers {
    private UserService userService;
    private UserValidator userValidator;
    private CategoryService categoryserves;
    private PaintingService paintingService1;
    

   





public CategoryControllers(UserService userService, UserValidator userValidator, CategoryService categoryserves,
			PaintingService paintingService1, CategoryRepository repo) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.categoryserves = categoryserves;
		this.paintingService1 = paintingService1;
		this.repo = repo;
	}
//	 @RequestMapping("/category/details")
//	 public String showitemis() {
//		 return "category_information.jsp";
//	 }
	 @RequestMapping("category/category/details/cart")
	 public String showcart1() {
		 return "cart.jsp";
	 }
	 
//    
//	 @PostMapping("admin/add_category")
//	   public RedirectView saveCategory(Category category,@RequestParam("image") MultipartFile multipartFile)
//	   		throws IOException {
//		 String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//		 category.setPic(fileName);
//		 
//		 Category savedCategory = cateServ.save(category);
//		 String uploadDir = "category-photos/" + savedCategory.getId();
//		 
//		 FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
//	       return new RedirectView("/"+ true);
//}

    
    
	
   






//	 @RequestMapping("/category/details")
//	 public String showitemis() {
//		 return "category_information.jsp";
//	 }
	 @RequestMapping("category/category/details/cart")
	 public String showcart() {
		 return "cart.jsp";
	 }
	 
	 @Autowired
	    private CategoryRepository repo;
	 
	 		@PostMapping("/users/save")
	 		 public String addCategory(@Valid @ModelAttribute("category") Category category,
	 				 BindingResult result, Model model, HttpSession session,
	 				 @RequestParam("photos") MultipartFile multipartFile) throws IOException {
	 	        System.out.println("Create a Category");
	 	       System.out.println(multipartFile);
	 	        if (result.hasErrors()) {
	 	        	System.out.println("error");
	 	            return "addCategory.jsp";
	 	        } 
	 	        try {
	 	        	categoryserves.addCategory(category);
	 	        	System.out.println("created");
	 	        	
	 	        	String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			 		category.setPic(fileName);
			 		Category savedUser = repo.save(category);
			 		System.out.println(savedUser);
		 			String uploadDir = "../img/" + savedUser.getId();
		 			System.out.println(uploadDir);
		 			FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		 			System.out.println("Uploaded");

	 	        	
	 	        return "redirect:/admin/add_category";
	 	        }
	 	        catch(Exception e){
	 	        	model.addAttribute("er", "This Category is aleady added!");
	 	        	return "addCategory.jsp";
	 	        }
	 	        
	 	        
	 		} 	
	 		
	 		
//	 		public RedirectView saveUser(Category category ,@RequestParam("photos") MultipartFile multipartFile) throws IOException {
//
//		 		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//		 		category.getPic(fileName);
//		 		Category savedUser = repo.save(category);
//		 		System.out.println(savedUser);
//	 			String uploadDir = "../img/" + savedUser.getId();
//	 			System.out.println(uploadDir);
//	 			FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
//	 			System.out.println("Uploaded");
//	 			return new RedirectView("/category", true);
//	 					
//	 	
//	 			}
//	 		@GetMapping("/category")
//	 		public String ADphoto(Model model,long id) {
//	 			model.addAttribute("category",categoryserves.findCategoryById(id));
//	 			return "thymleaf/photo";
//	 		}
	 		
	 		
//	 		Delete a product_Painting ------------------------------------------------------------------------------------
//	 		@RequestMapping("/product/painting/{id}/delete")
//	 	    public String deleteUSer(@PathVariable("id") long id) {
//	 			paintingService1.deleteUser(id);
//	 	        return "redirect:/category/category/details/cart";
//	 	    }
	 		
   

	@RequestMapping("category/{cid}/painting/{id}")
	 public String showPainting(@PathVariable("id") long id,@PathVariable("cid") long cid, Model model, Principal principal) {
		 Painting painting = paintingService1.findPaintingById(id);
		 model.addAttribute("painting",painting);
		 List <Category> categories = categoryserves.getAllCategories();
		 model.addAttribute("categories" , categories);
		 model.addAttribute("principal",principal);
		Category cat = categoryserves.findCategoryById(cid);
		model.addAttribute("category",cat);
		List<Painting> paintings = cat.getPaintings();
		model.addAttribute("paintings", paintings);
		 return "paintingInfo.jsp";
	 }
	
	 @RequestMapping("/cart")
	 public String showcart(Model model, Principal principal) {
		 User user = userService.findByUsername(principal.getName());
//		 List<Painting> paintings = paintingService.
		 
		 return "cart.jsp";
	 }
	 
	 @RequestMapping("/cart/add_cart/{cid}/{pid}")
	 public String addcart(@PathVariable("cid") long cid ,@PathVariable("pid") long pid, Principal principal) {
		 User user = userService.findByUsername(principal.getName());
		 	userService.addToCart(cid,pid,user.getId());
		 return "redirect:/cart";
		 }

	 }



