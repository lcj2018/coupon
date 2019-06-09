package top.juusok.couponapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.juusok.couponapi.common.api.JsonResult;
import top.juusok.couponapi.common.model.Store;
import top.juusok.couponapi.common.model.User;
import top.juusok.couponapi.service.StoreService;
import top.juusok.couponapi.service.UserService;

@RestController
@RequestMapping("/common")
public class CommonController {

	private final StoreService storeService;
	private final UserService userService;
	
	public CommonController(StoreService storeService, UserService userService)
	{
		this.storeService = storeService;
		this.userService = userService;
	}

	@PutMapping("/stores")
	public ResponseEntity<JsonResult<?>> storeRegister(Store store)
	{
		storeService.create(store);
		return ResponseEntity.ok(new JsonResult<>(null, "注册成功"));
	}
	
	@PostMapping("/stores")
	public ResponseEntity<JsonResult<?>> storeLogin(Store store)
	{
		String jwt = storeService.login(store);
		JsonResult<?> result = new JsonResult<>(null, "登录成功");
		return ResponseEntity.ok().header("Authorization", jwt).body(result);
	}	
	
	@PutMapping("/users")
	public ResponseEntity<JsonResult<?>> userRegister(User user)
	{
		userService.create(user);
		return ResponseEntity.ok(new JsonResult<>(null, "注册成功"));
	}
	
	@PostMapping("/users")
	public ResponseEntity<JsonResult<?>> userLogin(User user)
	{
		String jwt = userService.login(user);
		JsonResult<?> result = new JsonResult<>(null, "登录成功");
		return ResponseEntity.ok().header("Authorization", jwt).body(result);
	}
	
}
