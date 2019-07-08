/**
 * 
 */
package com.csf.whoami.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author TuanDQ
 *
 */
@Controller
@RequestMapping("/hello")
public class IndexController {

	@GetMapping
	public String helloPage() {
		return "hello";
	}
}
