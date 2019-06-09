package top.juusok.couponapi.dao;

import top.juusok.couponapi.common.model.Store;

public interface StoreDao {
	
	int create(Store store);
	
	Store getInfo();

}
