package com.csf.whoami.security.controller;

import java.security.Principal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.csf.whoami.security.custome.TokenUtils;
import com.csf.whoami.security.model.Welcome;
import com.csf.whoami.security.redis.RedisConfiguration;

@RestController
@RequestMapping(value = { "/api/hello" }, produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	public Welcome greetings(@RequestParam("name") String name, Principal principal) {
		return new Welcome(name + " (" + principal.getName() + ")" + TokenUtils.extractCurrentToken());
	}

	@GetMapping("/test-redis")
	public String testRedisAccess() {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(RedisConfiguration.class);
		ctx.refresh();

		StringRedisTemplate stringRedisTemplate = ctx.getBean(StringRedisTemplate.class);
		// Using set to set value
		stringRedisTemplate.opsForValue().set("R", "Ram");
		stringRedisTemplate.opsForValue().set("S", "Shyam");
		// Fetch values from set
		System.out.println(stringRedisTemplate.opsForValue().get("R"));
		System.out.println(stringRedisTemplate.opsForValue().get("S"));
		// Using Hash Operation
		String mohan = "Mohan";
		stringRedisTemplate.opsForHash().put("M", String.valueOf(mohan.hashCode()), mohan);
		System.out.println(stringRedisTemplate.opsForHash().get("M", String.valueOf(mohan.hashCode())));

		return "success";
	}
}
