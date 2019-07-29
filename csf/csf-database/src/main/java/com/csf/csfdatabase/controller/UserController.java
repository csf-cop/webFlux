/**
 * 
 */
package com.csf.csfdatabase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tuan
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping("/{id}")
	public String getUserById() {
		return null;
	}
	
}
