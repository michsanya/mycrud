package crud.mycrud.controller;

import crud.mycrud.model.User;
import crud.mycrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping(value = "/user")
	public String getUserById(ModelMap model) {
		User user = userService.getUserById(1);
		model.addAttribute("user", user);
		return "index";
	}
	
}