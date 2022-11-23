package com.knf.dev.librarymanagementsystem.controller;

import com.knf.dev.librarymanagementsystem.entity.User;
import com.knf.dev.librarymanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	final UserService userService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public IndexController(UserService userService) {
		this.userService = userService;
	}


	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String showCreateForm(User user, Model model) {

		return "create-user";
	}

	@RequestMapping("/add-user")
	public String createUser(User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "create-user";
		}
		User usr = new User();
		usr.setFirstName(user.getFirstName());
		usr.setLastName(user.getLastName());
		usr.setEmail(user.getEmail());
		usr.setPassword(passwordEncoder.encode(user.getPassword()));

        userService.createUser(usr);
		return "redirect:/login";
	}

}
