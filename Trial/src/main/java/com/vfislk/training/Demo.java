package com.vfislk.training;

import java.util.Scanner;

public class Demo {
public static void main(String[] args) {
	Delivery foodtypes=new Delivery();
	System.out.println("Welcome to FoodPlaza");
	System.out.println(foodtypes.greetMessage("priya"));
	System.out.println("enter the type :"+"\tindian"+"\tchinese"+"\titalian");
	Scanner sc=new Scanner(System.in);
	String type=sc.next();
	foodtypes.showFood(type).forEach(System.out::println);
	sc.close();
	
}
}
