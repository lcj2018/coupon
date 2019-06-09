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
		String jwt = request.getHeader("Authorization");
		request.setAttribute("JwtUserDTO", JWTUtils.decodeAndGet(jwt, JwtUserDTO.class));
	}

	@PostMapping
	public void create() {
		
	}

	@PutMapping
	public void put() {
		
	}
	
	@GetMapping
	public void getAll() {
		
	}
	
	@GetMapping("/{coupon_id}")
	public void getByID(@PathVariable int cid) {
		
	}
	
	@PutMapping("/{coupon_id}")
	public void dealByID(@PathVariable int cid) {
		
	}
}
