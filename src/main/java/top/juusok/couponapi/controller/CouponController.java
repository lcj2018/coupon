package top.juusok.couponapi.controller;

import top.juusok.couponapi.service.CouponService;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.juusok.couponapi.common.api.JsonResult;
import top.juusok.couponapi.common.dto.JwtUserDTO;
import top.juusok.couponapi.common.model.Coupon;
import top.juusok.couponapi.common.query.web.request.AdoptCouponReq;
import top.juusok.couponapi.common.query.web.request.DealCouponReq;
import top.juusok.couponapi.common.query.web.request.PutCouponReq;
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

	/*
	 * 发放优惠券
	 */
	@PostMapping
	public ResponseEntity<JsonResult<?>> create(@RequestAttribute("JwtUserDTO") JwtUserDTO jwtUserDTO, Coupon coupon) {
		couponService.create(jwtUserDTO.getId(), coupon);
		return ResponseEntity.ok(new JsonResult<>(null, "创建成功", 200));
	}

	/*
	 * 用户上架优惠券
	 */
	@PutMapping
	public ResponseEntity<JsonResult<?>> put(@RequestAttribute("JwtUserDTO") JwtUserDTO jwtUserDTO, PutCouponReq couponReq) {
		couponService.put(couponReq);
		return ResponseEntity.ok(new JsonResult<>(null, "上架成功", 200));
	}
	
	/*
	 * 获取所有优惠券
	 */
	@GetMapping
	public ResponseEntity<JsonResult<?>> getAll(@RequestAttribute("JwtUserDTO") JwtUserDTO jwtUserDTO) {
		ArrayList ret = couponService.getAll();
		return ResponseEntity.ok(new JsonResult<>(ret, "获取成功", 200));
	}
	
	/*
	 * 获取所有用户上架的优惠券
	 */
	@GetMapping("/4Sale/")
	public ResponseEntity<JsonResult<?>> getAll4Sale(@RequestAttribute("JwtUserDTO") JwtUserDTO jwtUserDTO) {
		ArrayList ret = couponService.getAll4Sale();
		return ResponseEntity.ok(new JsonResult<>(ret, "获取成功", 200));
	}
	
	/*
	 * 获取特定id优惠券
	 */
	@GetMapping("/{coupon_id}")
	public ResponseEntity<JsonResult<?>> getByID(@RequestAttribute("JwtUserDTO") JwtUserDTO jwtUserDTO, @PathVariable String coupon_id) {
		Coupon coupon = couponService.getByID(coupon_id);
		return ResponseEntity.ok(new JsonResult<>(coupon, "获取成功", 200));
	}
	
	/*
	 * 用户领取特定id优惠券（商家发放的）
	 */
	@PostMapping("/{coupon_id}")
	public ResponseEntity<JsonResult<?>> adoptByID(@RequestAttribute("JwtUserDTO") JwtUserDTO jwtUserDTO, @PathVariable String coupon_id, AdoptCouponReq couponReq) {
		couponReq.setCoupon(coupon_id);
		couponService.adoptByID(couponReq);
		return ResponseEntity.ok(new JsonResult<>(null, "领取成功", 200));
	}
	
	/*
	 * 用户购买特定id优惠券（用户上架的）
	 */
	@PutMapping("/{coupon_id}")
	public ResponseEntity<JsonResult<?>> dealByID(@RequestAttribute("JwtUserDTO") JwtUserDTO jwtUserDTO, @PathVariable String coupon_id, DealCouponReq couponReq) {
		couponReq.setCoupon(coupon_id);
		couponService.dealByID(couponReq);
		return ResponseEntity.ok(new JsonResult<>(null, "购买成功", 200));
	}
}
