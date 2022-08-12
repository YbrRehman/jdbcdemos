package com.policyapp.client;

import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.service.IPolicyService;
import com.policyapp.service.PolicyServiceImpl;

public class User {

	public static void main(String[] args) {
		IPolicyService policyService= new PolicyServiceImpl();
		
		policyService.getAll().forEach(System.out::println);
		System.out.println();
	    try {
			policyService.getByType("term").forEach(System.out::println);
			System.out.println();
			System.out.println("policy by ID");
			System.out.println(policyService.getById(1001));
			System.out.println("policy by premium");
			policyService.getByLessPremium(2000).forEach(System.out::println);
		} catch (PolicyNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
