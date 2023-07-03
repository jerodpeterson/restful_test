package com.example.restservice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {
	@GetMapping("/purchases")
	public @ResponseBody List<Purchase> reward() {
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String currDate = localDate.format(formatter);
		long[] prices = {20, 50, 70, 100, 120};
		List<Purchase> list = new ArrayList<>();
		for (int i = 0; i < 5; i++)
		{
			Purchase purchase = new Purchase(currDate, prices[i]);
			list.add(purchase);
		}
		return list;
	}
}
