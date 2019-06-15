package top.juusok.couponapi.service;

import top.juusok.couponapi.common.dto.JwtUserDTO;
import top.juusok.couponapi.common.model.User;

public interface UserService {

	int create(User user);
	
	String login(User user);
	
	User getInfo(String id);
	
}
