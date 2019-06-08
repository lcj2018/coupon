package top.juusok.couponapi.controller;

import top.juusok.couponapi.service.CouponService;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.juusok.couponapi.common.api.JsonResult;

@RestController
@RequestMapping("/coupons")
public class CouponController {
	
	private final CouponService couponService;
	
	@Autowired
	public CouponController(CouponService couponService)
	{
		this.couponService = couponService;
	}
	
}
