package top.juusok.couponapi.dao;

import java.util.Date;

public interface CouponDao {
	
	int create(double money, Integer amount, Date validTime, Date invalidTime);

	int put(Integer[] arrCounponID);
	
	int	getAll();
	
	int getByID(Integer couponID);
	
	int dealByID(Integer couponID);
}
