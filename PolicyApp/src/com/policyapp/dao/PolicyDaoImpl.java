package com.policyapp.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;

public class PolicyDaoImpl implements IPolicyDao {

	@Override
	public List<Policy> findAll() {

		return showAllPolicies();
	}

	@Override
	public List<Policy> findByType(String type) throws PolicyNotFoundException {
		return showAllPolicies().stream().filter(policy -> policy.getType().equalsIgnoreCase(type))
				.collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByCategory(String category) throws PolicyNotFoundException {

		return showAllPolicies().stream().filter(policy -> policy.getCategory().equalsIgnoreCase(category))
				.collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByCoverage(String coverage) throws PolicyNotFoundException {

		return showAllPolicies().stream().filter(policy -> policy.getCoverage().equalsIgnoreCase(coverage))
				.collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByHighSumAssured(double SumAssured) throws PolicyNotFoundException {

		return showAllPolicies().stream().filter(policy -> policy.getSumAssured() >SumAssured)
				.collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByLessPremium(double premium) throws PolicyNotFoundException {

		return showAllPolicies().stream().filter(policy -> policy.getPremium() < premium).collect(Collectors.toList());
	}

	@Override
	public Policy findById(int policyId) throws IdNotFoundException {
		return showAllPolicies().stream().filter(policy -> policy.getPolicyNumber() == policyId)
				.findFirst().get();
		
	}

	private List<Policy> showAllPolicies() {
		return Arrays.asList(new Policy("jeevan sath", 1001, 2000, "term", 10, "marriage", "general", 20000),
				new Policy("Jevan Anand", 1002, 3000, "endowment", 5, "life", "life", 250000),
				new Policy("life saral", 1003, 1600, "pension", 10, "retirement", "life", 600000),
				new Policy("Bajaj Allianz", 1004, 2000, "endowment", 10, "accidets", "motor", 200000),
				new Policy("Tata Allianz", 105, 2000, "term", 10, "sickness", "health", 800000),
				new Policy("ClickToProtect", 1006, 2000, "term", 10, "sickness", "wealth", 200000));
	}
}
