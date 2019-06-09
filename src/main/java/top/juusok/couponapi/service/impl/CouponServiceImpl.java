package top.juusok.couponapi.service.impl;

import top.juusok.couponapi.common.exception.def.ProjectException;
import top.juusok.couponapi.common.model.Coupon;
import top.juusok.couponapi.common.validator.CouponValidator;
import top.juusok.couponapi.dao.CouponDao;
import top.juusok.couponapi.service.CouponService;

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
	public int create(Coupon coupon) {
		// TODO Auto-generated method stub double money, Integer amount, Date validTime, Date invalidTime
		if(CouponValidator.checkForCreate(coupon)) {
			couponDao.create(coupon);
		} else {
			throw new ProjectException("数据不合法");
		}
		return 0;
	}

	@Override
	public int put(Integer[] arrCounponID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getByID(Integer couponID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int dealByID(Integer couponID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
