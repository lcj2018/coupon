package top.juusok.couponapi.controller;

import top.juusok.couponapi.common.api.JsonResult;
import top.juusok.couponapi.common.dto.JwtUserDTO;
import top.juusok.couponapi.common.model.Store;
import top.juusok.couponapi.common.utils.JWTUtils;
import top.juusok.couponapi.service.StoreService;

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

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
	
	@ModelAttribute
	void beforeAction(HttpServletRequest request) {
		String jwt = request.getHeader("Authorization").substring(7);
		request.setAttribute("JwtUserDTO", JWTUtils.decodeAndGet(jwt, JwtUserDTO.class));
	}
	
	/*
	 * 获取当前商家信息
	 */
	@GetMapping
	ResponseEntity<JsonResult<?>> getInfo(@RequestAttribute("JwtUserDTO") JwtUserDTO jwtUserDTO) {
		Store store = storeService.getInfo(jwtUserDTO.getId());
		return ResponseEntity.ok(new JsonResult<>(store, "获取成功", 200));
	}
}
