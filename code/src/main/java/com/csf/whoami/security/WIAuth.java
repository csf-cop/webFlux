/**
 * 
 */
package com.csf.whoami.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author TuanDQ
 *
 */
@Controller
@RequestMapping("/auth")
public class WIAuth {
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
}
