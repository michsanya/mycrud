package crud.mycrud.controller;

import java.util.ArrayList;
import java.util.List;

//import crud.mycrud.model.User;
//import crud.mycrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import crud.mycrud.model.User;
import crud.mycrud.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping(value = "/home")
	public String getStartPage(ModelMap model) {
		return "home";
	}
	
	@GetMapping(value = "/{id}")
	public String getUserById(@PathVariable Integer id, ModelMap model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "index";
	}
	
	@GetMapping(value = "/")
	public String getAllUser(ModelMap model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "list";
	}
	
	@GetMapping("/add")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "add_user";
	}
		
	@PostMapping(value = "/add")
	public String createUser(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/";
	}

	@GetMapping("/{id}/edit")
	public String edit(@PathVariable("id") int id, ModelMap model){
		model.addAttribute("user", userService.getUserById(id) );
		return "edit";
	}

	@PatchMapping("/{id}")
	public String update(@ModelAttribute("user") User user, @PathVariable("id") int id){
		userService.updateUser(id, user);
		return "redirect:/";
	}

}