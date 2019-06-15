package top.juusok.couponapi.dao.impl;

import top.juusok.couponapi.common.model.User;
import top.juusok.couponapi.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public int create(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getInfo(String id) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId("15522222222");
		user.setPhoneNumber(user.getId());
		user.setPassword("123123123");
		return user;
	}

}
