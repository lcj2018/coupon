package top.juusok.couponapi.common.validator;

import top.juusok.couponapi.common.exception.def.ProjectException;
import top.juusok.couponapi.common.model.Store;

public class StoreValidator {
	
	public static boolean checkForResgistration(Store store)
	{
		if(store.getPhoneNumber().length() != 11)throw new ProjectException("手机号应为11位");
		return true;
	}

	public static boolean checkForLogin(Store store)
	{
		if(store.getPhoneNumber().length() != 11)throw new ProjectException("手机号应为11位");
		return true;
	}
	
}
