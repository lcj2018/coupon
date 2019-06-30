package top.juusok.couponapi.common.validator;

import top.juusok.couponapi.common.exception.def.ProjectException;
import top.juusok.couponapi.common.model.Coupon;

public class CouponValidator {
	
	public static boolean checkForCreate(Coupon coupon) {
		if(coupon.getMoney() < 0) throw new ProjectException("价格需大于等于0");
		if(coupon.getAmount() <= 0)throw new ProjectException("数量需大于0");
		if(coupon.getInvalidTime().compareTo(coupon.getValidTime()) > 1)throw new ProjectException("有效时间不正确");
		return true;
	}

}
