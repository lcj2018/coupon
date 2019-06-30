package top.juusok.couponapi.common.validator;

import top.juusok.couponapi.common.exception.def.ProjectException;
import top.juusok.couponapi.common.model.User;

public class UserValidator {
	
	public static boolean checkForResgistration(User user)
	{
		if(user.getPhoneNumber().length() != 11)throw new ProjectException("手机号应为11位");
		return true;
	}

	public static boolean checkForLogin(User user)
	{
		if(user.getPhoneNumber().length() != 11)throw new ProjectException("手机号应为11位");
		return true;
	}
	
}
