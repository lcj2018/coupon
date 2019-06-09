package top.juusok.couponapi.dao;

import top.juusok.couponapi.common.model.User;

public interface UserDao {
	
	int create(User user);
	
	User getInfo();

}
