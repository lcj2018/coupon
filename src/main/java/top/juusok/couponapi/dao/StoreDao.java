package top.juusok.couponapi.dao;

import top.juusok.couponapi.common.model.Store;
import top.juusok.couponapi.common.model.User;

public interface StoreDao {
	
	int create(Store store);
	
	int getInfo();

}
