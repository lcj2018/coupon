package top.juusok.couponapi.common.fabricentity.response;

import java.util.ArrayList;

public class GetAllCouponResp {

	private ArrayList arrCoupons;
	
	public GetAllCouponResp() {
		arrCoupons = new ArrayList();
	}
	
	public void setArrCoupons(ArrayList arr) {
		this.arrCoupons = arr;
	}
	
	public ArrayList getArrCoupons() {
		return arrCoupons;
	}
}
