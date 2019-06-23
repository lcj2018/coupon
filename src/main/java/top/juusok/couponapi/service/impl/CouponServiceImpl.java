package top.juusok.couponapi.service.impl;

import top.juusok.couponapi.common.exception.def.ProjectException;
import top.juusok.couponapi.common.model.Coupon;
import top.juusok.couponapi.common.query.web.request.AdoptCouponReq;
import top.juusok.couponapi.common.query.web.request.DealCouponReq;
import top.juusok.couponapi.common.validator.CouponValidator;
import top.juusok.couponapi.dao.CouponDao;
import top.juusok.couponapi.common.query.web.request.PutCouponReq;
import top.juusok.couponapi.service.CouponService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService {
	
	private final CouponDao couponDao;
	
	@Autowired
	public CouponServiceImpl(CouponDao couponDao)
	{
		this.couponDao = couponDao;
	}

	@Override
	public int create(String id, Coupon coupon) {
		// TODO Auto-generated method stub double money, Integer amount, Date validTime, Date invalidTime
		if(CouponValidator.checkForCreate(coupon)) {
			couponDao.create(id, coupon);
		} else {
			throw new ProjectException("数据不合法");
		}
		return 0;
	}

	@Override
	public int put(PutCouponReq couponReq) {
		// TODO Auto-generated method stub
		couponDao.put(couponReq);
		return 0;
	}

	@Override
	public ArrayList getAll() {
		
		return couponDao.getAll();
		
	}
	
	@Override
	public ArrayList getAll4Sale() {
		
		return couponDao.getAll4Sale();
	}

	@Override
	public Coupon getByID(String couponID) {
		// TODO Auto-generated method stub
		return couponDao.getByID(couponID);
	}
	
	@Override
	public int adoptByID(AdoptCouponReq couponReq) {
		couponDao.adoptByID(couponReq);
		return 0;
	}

	@Override
	public int dealByID(DealCouponReq couponReq) {
		couponDao.dealByID(couponReq);
		return 0;
	}

}
