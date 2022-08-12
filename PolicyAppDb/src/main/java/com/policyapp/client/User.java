package com.policyapp.client;

import java.util.Arrays;
import java.util.List;

import com.policyapp.model.Policy;
import com.policyapp.service.IPolicyService;
import com.policyapp.service.PolicyServiceImpl;

public class User {

	public static void main(String[] args) {
		IPolicyService policyService= new PolicyServiceImpl();
	
		//Policy policy=new Policy("Rose",1001,1500,"loan",5,"studentloan","education","Velly",150000);
	   
	    	//policyService.addPolicy(policy);
	    	//System.out.println("policy added");
	    	//policyService.getAll().forEach(System.out::println);
	    	try
	    	{
	    		System.out.println("policy by brand");
	    		policyService.getByBrand("motor").forEach(System.out::println);
	    		System.out.println();
	    		System.out.println("policy by type");
	    		policyService.getByType("loan").forEach(System.out::println);
	    		System.out.println();
	    		System.out.println("updating policy ");
	    		policyService.updatePolicy(4, "wealth");
	    		System.out.println();
	    		System.out.println("policy by invalid id ");
	    		System.out.println(policyService.getById(10));
	    	}
	    	catch (Exception e) {
	    		System.out.println(e.getMessage());
				// TODO: handle exception
			}
	    	
		///policyService.deletePolicy(3);
			//policyService.updatePolicy(1, "health");
	
		
	}
}
