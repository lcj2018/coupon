package top.juusok.couponapi.controller;

import top.juusok.couponapi.common.utils.JWTUtils;
import top.juusok.couponapi.common.api.JsonResult;
import top.juusok.couponapi.common.dto.JwtUserDTO;
import top.juusok.couponapi.common.model.User;
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
		String jwt = request.getHeader("Authorization").substring(7);
		request.setAttribute("JwtUserDTO", JWTUtils.decodeAndGet(jwt, JwtUserDTO.class));
	}
	
	@GetMapping
	public ResponseEntity<JsonResult<?>> getInfo(@RequestAttribute("JwtUserDTO") JwtUserDTO jwtUserDTO)
	{
		User user = userService.getInfo(jwtUserDTO.getId());
		return ResponseEntity.ok(new JsonResult<>(user, "获取成功", 200));
	}
}
