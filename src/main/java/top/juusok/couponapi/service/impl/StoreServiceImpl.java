package top.juusok.couponapi.service.impl;

import top.juusok.couponapi.common.exception.def.ProjectException;
import top.juusok.couponapi.common.model.Store;
import top.juusok.couponapi.common.utils.DigestUtil;
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
			
			storeDao.create(store);
		} else {
			throw new ProjectException("数据不合法");
		}
		return 0;
	}

	@Override
	public Store getInfo() {
		// TODO Auto-generated method stub
		Store store = storeDao.getInfo();
		return store;
	}

	@Override
	public int login(Store store) {
		// TODO Auto-generated method stub
		if(StoreValidator.checkForLogin(store)) {
			Store retStore = getInfo();
			String salt = retStore.getSalt();
			String retPwd = retStore.getPassword();
			
			String encodedPwd = DigestUtil.md5Hash(store.getPassword(), salt);
			if(retPwd == encodedPwd)
			{
				
			} else {
				
			}
		} else {
			throw new ProjectException("数据不合法");
		}
		return 0;
	}

}
