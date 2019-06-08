package top.juusok.couponapi.service;

import top.juusok.couponapi.common.model.User;

public interface UserService {

	int create(User user);
	
	int login(User user);
	
	int getInfo();
	
}
