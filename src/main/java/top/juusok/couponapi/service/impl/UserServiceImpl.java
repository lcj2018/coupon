package top.juusok.couponapi.service.impl;

import top.juusok.couponapi.common.exception.def.ProjectException;
import top.juusok.couponapi.common.model.User;
import top.juusok.couponapi.common.utils.DigestUtil;
import top.juusok.couponapi.common.validator.UserValidator;
import top.juusok.couponapi.dao.UserDao;
import top.juusok.couponapi.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	private static final int JWT_AGE = 3600000;

	@Override
	public int create(User user) {
		// TODO Auto-generated method stub String phoneNumber, String password
		if(UserValidator.checkForResgistration(user)) {
			String salt = DigestUtil.createSalt();
			user.setSalt(salt);
			
			String encodedPwd = DigestUtil.md5Hash(user.getPassword(), salt);
			user.setPassword(encodedPwd);
			
			userDao.create(user);
		} else {
			throw new ProjectException("数据不合法");
		}
		return 0;
	}

	@Override
	public User getInfo() {
		// TODO Auto-generated method stub
		User user = userDao.getInfo();
		return user;
	}

	@Override
	public int login(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
