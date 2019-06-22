package top.juusok.couponapi.controller;

import top.juusok.couponapi.service.CouponService;

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.juusok.couponapi.common.api.JsonResult;
import top.juusok.couponapi.common.dto.JwtUserDTO;
import top.juusok.couponapi.common.model.Coupon;
import top.juusok.couponapi.common.utils.JWTUtils;

@RestController
@RequestMapping("/coupons")
public class CouponController {
	
	private final CouponService couponService;
	
	@Autowired
	public CouponController(CouponService couponService)
	{
		this.couponService = couponService;
	}
	
	@ModelAttribute
	void beforeAction(HttpServletRequest request) {
		String jwt = request.getHeader("Authorization").substring(7);
		request.setAttribute("JwtUserDTO", JWTUtils.decodeAndGet(jwt, JwtUserDTO.class));
	}

	@PostMapping
	public ResponseEntity<JsonResult<?>> create(@RequestAttribute("JwtUserDTO") JwtUserDTO jwtUserDTO, Coupon coupon) {
		couponService.create(jwtUserDTO.getId(), coupon);
		return ResponseEntity.ok(new JsonResult<>(null, "创建成功", 200));
	}

	@PutMapping
	public ResponseEntity<JsonResult<?>> put(@RequestAttribute("JwtUserDTO") JwtUserDTO jwtUserDTO, Coupon coupon) {
		return ResponseEntity.ok(new JsonResult<>(null, "上架成功", 200));
	}
	
	@GetMapping
	public ResponseEntity<JsonResult<?>> getAll(@RequestAttribute("JwtUserDTO") JwtUserDTO jwtUserDTO) {
		couponService.getAll();
		return ResponseEntity.ok(new JsonResult<>(null, "创建成功", 200));
	}
	
	@GetMapping("/{coupon_id}")
	public ResponseEntity<JsonResult<?>> getByID(@RequestAttribute("JwtUserDTO") JwtUserDTO jwtUserDTO, @PathVariable int cid) {
		return ResponseEntity.ok(new JsonResult<>(null, "创建成功", 200));
	}
	
	@PutMapping("/{coupon_id}")
	public ResponseEntity<JsonResult<?>> dealByID(@RequestAttribute("JwtUserDTO") JwtUserDTO jwtUserDTO, @PathVariable int cid) {
		return ResponseEntity.ok(new JsonResult<>(null, "创建成功", 200));
	}
}
