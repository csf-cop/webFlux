/**
 * 
 */
package com.csf.whoami.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author TuanDQ
 *
 */
@Controller
public class IndexController {

	@GetMapping
	public String helloPage() {
		return "hello";
	}
}
