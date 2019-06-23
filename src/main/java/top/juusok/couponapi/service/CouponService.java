package top.juusok.couponapi.service;

import java.util.ArrayList;

import top.juusok.couponapi.common.model.Coupon;
import top.juusok.couponapi.common.query.web.request.AdoptCouponReq;
import top.juusok.couponapi.common.query.web.request.DealCouponReq;
import top.juusok.couponapi.common.query.web.request.PutCouponReq;

public interface CouponService {
	
	int create(String id, Coupon coupon);

	int put(PutCouponReq couponReq);
	
	ArrayList getAll();
	
	ArrayList getAll4Sale();
	
	Coupon getByID(String couponID);
	
	int adoptByID(AdoptCouponReq couponReq);
	
	int dealByID(DealCouponReq couponReq);	
}
