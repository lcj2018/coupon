package top.juusok.couponapi.service;

import top.juusok.couponapi.common.model.Store;

public interface StoreService {

	int create(Store store);
	
	String login(Store store);
	
	Store getInfo();
	
}
