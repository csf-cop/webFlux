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
public class IndexController {

	@GetMapping("/hello")
	public String helloPage() {
		return "hello";
	}

	@RequestMapping("/")
	public String indexPage() {
		return "index";
	}
}
