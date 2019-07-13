package top.juusok.couponapi.dao.impl;

import top.juusok.couponapi.common.constant.Const;
import top.juusok.couponapi.common.model.Coupon;
import top.juusok.couponapi.common.query.fabricentity.request.CreateCouponReq;
import top.juusok.couponapi.common.query.fabricentity.request.CreateStoreReq;
import top.juusok.couponapi.common.query.fabricentity.response.CouponItemResp;
import top.juusok.couponapi.common.query.fabricentity.response.GetAllCouponResp;
import top.juusok.couponapi.common.query.web.request.AdoptCouponReq;
import top.juusok.couponapi.common.query.web.request.DealCouponReq;
import top.juusok.couponapi.dao.CouponDao;
import top.juusok.couponapi.common.query.web.request.PutCouponReq;
import top.juusok.couponapi.common.query.web.response.Coupon4SaleResp;
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
	public int put(PutCouponReq couponReq) {

		String url = Const.baseUrl + "/org.network.coupon.SellCoupon";
		HttpMethod method = HttpMethod.POST;
		String strReq = JSONObject.toJSONString(couponReq);
		String resp = client.work(url, method, strReq);
		return 0;
	}

	@Override
	public ArrayList getAll() {

		String url = Const.baseUrl + "/org.network.coupon.Coupon/";
		HttpMethod method = HttpMethod.GET;
		String strReq = "";
		String ret = client.work(url, method, strReq);
		
		ret = ret.replace("resource:", "");
		ret = ret.replace("typeID", "couponID");
		ret = ret.replace("effectiveTime", "validTime");
		ret = ret.replace("expireTime", "invalidTime");
		ArrayList resp = JSONObject.parseObject(ret, ArrayList.class);
		ArrayList<Coupon> arrCoupons = new ArrayList<Coupon>(); 
		for(int i = 0; i < resp.size(); ++i) {
			Coupon item = JSONObject.parseObject(resp.get(i).toString(), Coupon.class);
			arrCoupons.add(item);
		}
		return arrCoupons;
	}
	
	@Override
	public ArrayList getAll4Sale() {
		
		String url = Const.baseUrl + "/org.network.coupon.SellCoupon/";
		HttpMethod method = HttpMethod.GET;
		String strReq = "";
		String ret = client.work(url, method, strReq);
		
		ret = ret.replace("resource:org.network.coupon.User#", "");
		ret = ret.replace("resource:org.network.coupon.Coupon#", "");
		ArrayList resp = JSONObject.parseObject(ret, ArrayList.class);
		ArrayList<Coupon4SaleResp> arr = new ArrayList<Coupon4SaleResp>();
		for(int i = 0; i < resp.size(); ++i) {
			Coupon4SaleResp item = JSONObject.parseObject(resp.get(i).toString(), Coupon4SaleResp.class);
			arr.add(item);
		}
		return arr;
	}

	@Override
	public Coupon getByID(String couponID) {

		String url = Const.baseUrl + "/org.network.coupon.Coupon/" + couponID;
		HttpMethod method = HttpMethod.GET;
		String strReq = "";
		String ret = client.work(url, method, strReq);
		
		ret = ret.replace("resource:", "");
		ret = ret.replace("typeID", "couponID");
		ret = ret.replace("effectiveTime", "validTime");
		ret = ret.replace("expireTime", "invalidTime");
		
		Coupon coupon = JSONObject.parseObject(ret, Coupon.class);
		return coupon;
	}
	
	@Override
	public int adoptByID(AdoptCouponReq couponReq) {
		
		String url = Const.baseUrl + "/org.network.coupon.GetCoupon/";
		HttpMethod method = HttpMethod.POST;
		String strReq = JSONObject.toJSONString(couponReq);
		String ret = client.work(url, method, strReq);
		return 0;
	}

	@Override
	public int dealByID(DealCouponReq couponReq) {
		
		String url = Const.baseUrl + "/org.network.coupon.BuyCoupon/";
		HttpMethod method = HttpMethod.POST;
		String strReq = JSONObject.toJSONString(couponReq);
		String ret = client.work(url, method, strReq);
		return 0;
	}

}
