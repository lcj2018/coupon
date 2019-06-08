package top.juusok.couponapi.service.impl;

import java.util.Date;
import top.juusok.couponapi.service.CouponService;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService {

	@Override
	public int create(double money, Integer amount, Date validTime, Date invalidTime) {
		// TODO Auto-generated method stub
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
