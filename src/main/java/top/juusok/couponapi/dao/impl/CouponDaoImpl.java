package top.juusok.couponapi.dao.impl;

import java.util.Date;

import top.juusok.couponapi.dao.CouponDao;
import org.springframework.stereotype.Repository;

@Repository
public class CouponDaoImpl implements CouponDao {

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