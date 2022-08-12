package com.voterapp.service;

import com.voterapp.exceptions.InValidVoterException;
import com.voterapp.exceptions.LocalityNotFoundException;
import com.voterapp.exceptions.NoVoterIdException;
import com.voterapp.exceptions.UnderAgeException;

public class ElectionBoothImpl implements IElectionBooth {

	static String[] localities = { "BTMLayout", "Hoskote", "yalahanka" };

	@Override
	public boolean checkEligibility(int age, String locality, int voterId) throws InValidVoterException {
		try {
			checkAge(age);
			checkLocality(locality);
			checkVoterId(voterId);
		} catch (UnderAgeException e) {
			throw e;

		} catch (NoVoterIdException e) {
			throw e;

		} catch (LocalityNotFoundException e) {
			throw e;

		}

		return true;
	}

	private boolean checkAge(int age) throws UnderAgeException {
		if (age < 18) {
			throw new UnderAgeException("age less than 18 exception ");
		}
		return true;
	}

	private boolean checkLocality(String locality) throws LocalityNotFoundException {
		for (String localPlace : localities) {
			if (locality.equalsIgnoreCase(localPlace)) {
				return true;
			}
		}
		throw new LocalityNotFoundException("locality no found exception");
	}

	private boolean checkVoterId(int voterId) throws NoVoterIdException {
		if (voterId < 1000 || voterId > 9999) {
			throw new NoVoterIdException("voter id card invalid");
		}
		return true;
	}

}
