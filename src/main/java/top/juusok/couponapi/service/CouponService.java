package top.juusok.couponapi.service;

import top.juusok.couponapi.common.model.Coupon;

public interface CouponService {
	
	int create(String id, Coupon coupon);

	int put(Integer[] arrCounponID);
	
	int	getAll();
	
	int getByID(Integer couponID);
	
	int dealByID(Integer couponID);	
}
