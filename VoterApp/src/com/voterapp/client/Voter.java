package com.voterapp.client;

import java.util.Scanner;

import com.voterapp.exceptions.InValidVoterException;
import com.voterapp.service.ElectionBoothImpl;
import com.voterapp.service.IElectionBooth;

public class Voter {
	public static void main(String[] args) {
		System.out.println("welcome to ElectionBooth");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your age");
		int age = sc.nextInt();
		System.out.println("enter your locality");
		String locality = sc.next();
		System.out.println("enter your voter card 4 digit");
		int cardNumber = sc.nextInt();
		IElectionBooth electionBooth = new ElectionBoothImpl();

		try {
			boolean check = electionBooth.checkEligibility(age, locality, cardNumber);
			if (check) {
				System.out.println("you are elegible");
			}
		} catch (InValidVoterException e) {
			System.out.println(e.getMessage());
		}
sc.close();
	}

}
