package top.juusok.couponapi.controller;

import top.juusok.couponapi.service.StoreService;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores")
public class StoreController {
	
	private final StoreService storeService;
	
	@Autowired
	public StoreController(StoreService storeService)
	{
		this.storeService = storeService;
	}
	
}
