package top.juusok.couponapi.dao.impl;

import top.juusok.couponapi.common.constant.Const;
import top.juusok.couponapi.common.fabricentity.request.CreateStoreReq;
import top.juusok.couponapi.common.fabricentity.request.CreateUserReq;
import top.juusok.couponapi.common.model.Store;
import top.juusok.couponapi.common.model.User;
import top.juusok.couponapi.dao.UserDao;
import top.juusok.couponapi.service.HttpClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;

@Repository
public class UserDaoImpl implements UserDao {
	
	private HttpClient client;
	
	@Autowired
	public UserDaoImpl(HttpClient client) {
		this.client = client;
	}

	@Override
	public int create(User user) {
		String url = Const.baseUrl + "/org.network.coupon.User/";
		HttpMethod method = HttpMethod.POST;
		CreateUserReq req = new CreateUserReq(user);
		String strReq = JSONObject.toJSONString(req);
		String resp = client.work(url, method, strReq);
		
		return 0;
	}

	@Override
	public User getInfo(String id) {
		
		String url = Const.baseUrl + "/org.network.coupon.User/" + id;
		HttpMethod method = HttpMethod.GET;
		String strReq = "";
		String resp = client.work(url, method, strReq);
		
		User user = JSONObject.parseObject(resp, User.class);
		user.setId(user.getPhoneNumber());
		return user;
	}

}
