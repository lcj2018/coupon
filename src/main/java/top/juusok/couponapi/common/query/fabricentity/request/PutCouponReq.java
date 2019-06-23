package top.juusok.couponapi.common.query.fabricentity.request;

import java.util.ArrayList;

public class PutCouponReq {
	
	private ArrayList<String> arrCouponID = new ArrayList<String>();
	
	public void add(String item) {
		arrCouponID.add(item);
	}
	
	public ArrayList<String> getArrCouponID() {
		return arrCouponID;
	}
}
