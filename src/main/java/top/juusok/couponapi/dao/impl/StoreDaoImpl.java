package top.juusok.couponapi.dao.impl;

import top.juusok.couponapi.common.model.Store;
import top.juusok.couponapi.common.query.fabricentity.request.CreateStoreReq;
import top.juusok.couponapi.common.utils.JacksonUtils;
import top.juusok.couponapi.dao.StoreDao;
import top.juusok.couponapi.service.HttpClient;
import top.juusok.couponapi.common.constant.Const;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;

@Repository
public class StoreDaoImpl implements StoreDao {
	
	private HttpClient client;
	
	@Autowired
	public StoreDaoImpl(HttpClient client) {
		this.client = client;
	}

	@Override
	public int create(Store store) {

		String url = Const.baseUrl + "/org.network.coupon.Seller/";
		HttpMethod method = HttpMethod.POST;
		CreateStoreReq req = new CreateStoreReq(store);
		String strReq = JSONObject.toJSONString(req);
		String resp = client.work(url, method, strReq);
		
		return 0;
	}

	@Override
	public Store getInfo(String id) {
		// TODO Auto-generated method stub
		String url = Const.baseUrl + "/org.network.coupon.Seller/" + id;
		HttpMethod method = HttpMethod.GET;
		String strReq = "";
		String resp = client.work(url, method, strReq);
		
		Store store = JSONObject.parseObject(resp, Store.class);
		store.setId(store.getPhoneNumber());
		return store;
	}

}
