package top.juusok.couponapi.controller;

import top.juusok.couponapi.common.utils.JWTUtils;
import top.juusok.couponapi.common.dto.JwtUserDTO;
import top.juusok.couponapi.service.UserService;

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService)
	{
		this.userService = userService;
	}
	
	@ModelAttribute
	void beforeAction(HttpServletRequest request) {
		String jwt = request.getHeader("Authorization");
		request.setAttribute("JwtUserDTO", JWTUtils.decodeAndGet(jwt, JwtUserDTO.class));
	}
	
	@GetMapping
	void getInfo(@RequestAttribute("JwtUserDTO") JwtUserDTO jwtUserDTO)
	{
		
	}
}
