package top.juusok.couponapi.controller;

import top.juusok.couponapi.common.api.JsonResult;
import top.juusok.couponapi.common.model.Store;
import top.juusok.couponapi.service.StoreService;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.juusok.couponapi.common.api.JsonResult;
import top.juusok.couponapi.common.validator.StoreValidator;

@RestController
@RequestMapping("/stores")
public class StoreController {
	
	private final StoreService storeService;
	
	@Autowired
	public StoreController(StoreService storeService)
	{
		this.storeService = storeService;
	}
	
	@PutMapping
	public ResponseEntity<JsonResult<?>> register(Store store)
	{
		storeService.create(store);
		return ResponseEntity.ok(new JsonResult<>(null, "注册成功"));
	}
	
	@PostMapping
	public ResponseEntity<JsonResult<?>> login(Store store)
	{
		storeService.login(store);
		return ResponseEntity.ok(new JsonResult<>(null, "登录成功"));
	}
}
