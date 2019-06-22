package top.juusok.couponapi.dao.impl;

import top.juusok.couponapi.common.constant.Const;
import top.juusok.couponapi.common.fabricentity.request.CreateCouponReq;
import top.juusok.couponapi.common.fabricentity.request.CreateStoreReq;
import top.juusok.couponapi.common.fabricentity.response.CouponItemResp;
import top.juusok.couponapi.common.fabricentity.response.GetAllCouponResp;
import top.juusok.couponapi.common.model.Coupon;
import top.juusok.couponapi.dao.CouponDao;
import top.juusok.couponapi.service.HttpClient;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;

@Repository
public class CouponDaoImpl implements CouponDao {
	
	private HttpClient client;
	
	@Autowired
	public CouponDaoImpl(HttpClient client) {
		this.client = client;
	}

	@Override
	public int create(String id, Coupon coupon) {
		
		String url = Const.baseUrl + "/org.network.coupon.PublishCoupons/";
		HttpMethod method = HttpMethod.POST;
		CreateCouponReq req = new CreateCouponReq(id, coupon);
		String strReq = JSONObject.toJSONString(req);
		String resp = client.work(url, method, strReq);
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
		String url = Const.baseUrl + "/org.network.coupon.Coupon/";
		HttpMethod method = HttpMethod.GET;
		String strReq = "";
		String ret = client.work(url, method, strReq);
		
		ret = "{\"arrCoupons\":" + ret + "}";
		
		GetAllCouponResp resp = JSONObject.parseObject(ret, GetAllCouponResp.class);
		ArrayList<CouponItemResp> arrCoupons = new ArrayList<CouponItemResp>(); 
		for(int i = 0; i < resp.getArrCoupons().size(); ++i) {
			CouponItemResp item = JSONObject.parseObject(resp.getArrCoupons().get(i).toString(), CouponItemResp.class);
			arrCoupons.add(item);
		}
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
