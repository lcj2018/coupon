package top.juusok.couponapi.dao.impl;

import top.juusok.couponapi.common.model.Store;
import top.juusok.couponapi.dao.StoreDao;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDaoImpl implements StoreDao {

	@Override
	public int create(Store store) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Store getInfo() {
		// TODO Auto-generated method stub
		return new Store();
	}

}
