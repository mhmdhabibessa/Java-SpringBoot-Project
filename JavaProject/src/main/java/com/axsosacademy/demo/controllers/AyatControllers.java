package com.axsosacademy.demo.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.axsosacademy.demo.models.Category;
import com.axsosacademy.demo.models.Painting;
import com.axsosacademy.demo.models.User;
import com.axsosacademy.demo.services.CategoryService;
import com.axsosacademy.demo.services.PaintingService;
import com.axsosacademy.demo.services.UserService;
import com.axsosacademy.demo.validetors.UserValidator;

@Controller
public class AyatControllers {
	
    private UserService userService;
    private UserValidator userValidator;
	private final CategoryService categoryService;
	private final PaintingService paintingService;
    

    
    public AyatControllers(UserService userService, UserValidator userValidator , CategoryService categoryService, PaintingService paintingService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.categoryService = categoryService;
		this.paintingService = paintingService;
	}


	@RequestMapping(value={"/login","/register"}) // , method=RequestMethod.POST
	public String login(Model model,@RequestParam(value="error",required=false) String error,@RequestParam(value="logout",required=false) String logout, Principal principal){
		if(principal == null) {
			if(error != null){model.addAttribute("errorMessage","Invalid Credentials.");}
			if(logout != null){model.addAttribute("logoutMessage","Logout Successful");}
			
			model.addAttribute("user",new User());
			return "loginRegnew.jsp";
		}
		return "redirect:/";
	}
	
	@PostMapping("/registration") //@RequestMapping(value="/registration" , method=RequestMethod.POST)
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        userValidator.validate(user, result);

        if (result.hasErrors()) {
            return "loginRegnew.jsp";
        }
        else if(userService.getAll().size() == 0) {
        		userService.saveUserWithAdminRole(user);
        		return "redirect:/login";
        } else {
        		userService.saveWithUserRole(user);
        		return "redirect:/login";
        }
    }
     @RequestMapping("/logout")
	 public String logout(HttpSession session) {
	 	session.invalidate();
	 	return "redirect:/";
	 }
//category 
@RequestMapping("/category")
public String Category(@ModelAttribute("category") Category category) {
	return "showCategory.jsp";
}
@RequestMapping("categories/{id}")
public String showCategory(@PathVariable("id") Long id, 
		@ModelAttribute("category") Category category,
		Model model) {
	Category myCategory = categoryService.getCategory(id);
	model.addAttribute("category", myCategory);
	model.addAttribute("products", paintingService.getAllExceptId(id));
	return "showCategory.jsp";
}
//painting

@RequestMapping("/painting")
public String painting(@ModelAttribute("painting") Painting painting) {
	return "painting.jsp";
}
@RequestMapping("/painting/{id}")
public String showProduct(@PathVariable("id") Long id, @ModelAttribute("painting") Painting painting, Model model) {
	Painting myPainting = paintingService.findPaintingById(id);
	model.addAttribute("painting", myPainting);
	model.addAttribute("categories", categoryService.getAllExceptId(id));
	return "showPainting.jsp";
}

}

