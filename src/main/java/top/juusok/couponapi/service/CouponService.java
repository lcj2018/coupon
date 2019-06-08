package top.juusok.couponapi.service;

import java.util.Date;

public interface CouponService {
	
	int create(double money, Integer amount, Date validTime, Date invalidTime);

	int put(Integer[] arrCounponID);
	
	int	getAll();
	
	int getByID(Integer couponID);
	
	int dealByID(Integer couponID);
	
}
