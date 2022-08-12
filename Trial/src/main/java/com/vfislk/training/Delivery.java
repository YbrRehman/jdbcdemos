package com.vfislk.training;


import java.util.Arrays;
import java.util.List;

public class Delivery {

	List<String> showFood(String type)
	{
		if(type.equalsIgnoreCase("indian"))
			return Arrays.asList("dal rice","idli","dosa");
		if(type.equalsIgnoreCase("chinese"))
			return Arrays.asList("noodls","octopus","momo");
		if(type.equalsIgnoreCase("italian"))
			System.out.println("pasta");
			
		return null;
	}
	public String greetMessage(String name)
	{
		System.out.println("....");
		return null;
	}
}
