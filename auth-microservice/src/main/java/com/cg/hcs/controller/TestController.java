package com.cg.hcs.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hcs/test")
public class TestController {
	@GetMapping("/home")
	public String allAccess() {
		return "Home Content.";
	}
	
	@GetMapping("/consumer")
	@PreAuthorize("hasAuthority('CONSUMER') or hasAuthority('FACILITATOR') or hasAuthority('ADMIN')")
	public String userAccess() {
		return "Consumer Content.";
	}

	@GetMapping("/facilitator")
	@PreAuthorize("hasAuthority('FACILITATOR')")
	public String moderatorAccess() {
		return "Facilitator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}