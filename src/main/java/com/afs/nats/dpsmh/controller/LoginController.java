package com.afs.nats.dpsmh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

	@GetMapping
	public String hello() {
		return "Hello from login ";
	}

//	@GetMapping("/login-error")
//	public String loginError(Model model) {
//		model.addAttribute("loginError", true);
//		return "login";
//	}
//	@PostMapping
//	public String loginProcess() {
//		return "error";
//	}
}
