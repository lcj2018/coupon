package top.juusok.couponapi.service.impl;

import top.juusok.couponapi.common.dto.JwtUserDTO;
import top.juusok.couponapi.common.exception.def.ProjectException;
import top.juusok.couponapi.common.model.Store;
import top.juusok.couponapi.common.utils.DigestUtil;
import top.juusok.couponapi.common.utils.JWTUtils;
import top.juusok.couponapi.common.validator.StoreValidator;
import top.juusok.couponapi.dao.StoreDao;
import top.juusok.couponapi.service.StoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {
	
	private final StoreDao storeDao;
	private static final int JWT_AGE = 3600000;
	
	@Autowired
	public StoreServiceImpl(StoreDao storeDao) {
		this.storeDao = storeDao;
	}

	@Override
	public int create(Store store) {
		// TODO Auto-generated method stub String name, String address, String phoneNumber, String password
		if(StoreValidator.checkForResgistration(store)) {
			String salt = DigestUtil.createSalt();
			store.setSalt(salt);
			
			String encodedPwd = DigestUtil.md5Hash(store.getPassword(), salt);
			store.setPassword(encodedPwd);
			store.setId(store.getPhoneNumber());
			
			storeDao.create(store);
		} else {
			throw new ProjectException("数据不合法");
		}
		return 0;
	}

	@Override
	public Store getInfo(String id) {
		// TODO Auto-generated method stub
		Store store = storeDao.getInfo(id);
		return store;
	}
	
	private boolean equal(String a, String b){return a.contentEquals(b);}

	@Override
	public String login(Store store) {
		// TODO Auto-generated method stub
		if(!StoreValidator.checkForLogin(store)) {
			throw new ProjectException("数据不合法");
		}
		Store retStore = getInfo(store.getPhoneNumber());
		String salt = retStore.getSalt();
		String retPwd = retStore.getPassword();
	
		String encodedPwd = DigestUtil.md5Hash(store.getPassword(), salt);
		if(!equal(retPwd, encodedPwd)) {
			throw  new ProjectException("用户或密码错误");
		}

		JwtUserDTO jwtUserDTO = new JwtUserDTO(retStore.getId());
        String jwt = JWTUtils.createToken(jwtUserDTO, JWT_AGE);
        return jwt;
	}

}
