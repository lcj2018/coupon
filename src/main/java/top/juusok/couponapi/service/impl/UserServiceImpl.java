package top.juusok.couponapi.service.impl;

import top.juusok.couponapi.common.dto.JwtUserDTO;
import top.juusok.couponapi.common.exception.def.ProjectException;
import top.juusok.couponapi.common.model.User;
import top.juusok.couponapi.common.utils.DigestUtil;
import top.juusok.couponapi.common.utils.JWTUtils;
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
			user.setId(user.getPassword());
			
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
	public String login(User user) {
		// TODO Auto-generated method stub
		if(!UserValidator.checkForLogin(user)) {
			throw new ProjectException("数据不合法");
		}
		User retUser = getInfo();
		String salt = retUser.getSalt();
		String retPwd = retUser.getPassword();
	
		String encodedPwd = DigestUtil.md5Hash(user.getPassword(), salt);
		if(retPwd != encodedPwd) {
			throw  new ProjectException("用户或密码错误");
		}

		JwtUserDTO jwtUserDTO = new JwtUserDTO(retUser.getId());
        String jwt = JWTUtils.createToken(jwtUserDTO, JWT_AGE);
        return jwt;
	}

}
