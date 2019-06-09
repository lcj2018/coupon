package top.juusok.couponapi.dao;

import top.juusok.couponapi.common.model.Coupon;

public interface CouponDao {
	
	int create(Coupon coupon);

	int put(Integer[] arrCounponID);
	
	int	getAll();
	
	int getByID(Integer couponID);
	
	int dealByID(Integer couponID);
}
