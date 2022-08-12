package com.policyapp.service;
import java.util.List;
import java.util.stream.Collectors;

import com.policyapp.dao.IPolicyDao;
import com.policyapp.dao.PolicyDaoImpl;
import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;

public class PolicyServiceImpl implements IPolicyService {
	IPolicyDao policyDao=new PolicyDaoImpl();

	@Override
	public void addPolicy(Policy policy) {
		policyDao.addPolicy(policy);
		System.out.println("policy added succesfully");
		
	}

	@Override
	public void deletePolicy(int policyId) {
		policyDao.deletePolicy(policyId);
		System.out.println("policy deleted successfully");
		
	}

	@Override
	public void updatePolicy(int policyId, String coverage) {
		policyDao.updatePolicy(policyId, coverage);
		System.out.println("policy updated successfully");
	}

	@Override
	public List<Policy> getAll() {
		
		return policyDao.findAll();
	}

	@Override
	public List<Policy> getByType(String type) throws PolicyNotFoundException {
		List<Policy>policies=policyDao.findByType(type).stream()
				.sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
				.collect(Collectors.toList());
		if(policies.isEmpty())
		{
			throw new PolicyNotFoundException("policy not found Exception");
		}
		return policies;
	}

	@Override
	public List<Policy> getByCategory(String category) throws PolicyNotFoundException {
		List<Policy>policies=policyDao.findByCategory(category).stream()
				.sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
				.collect(Collectors.toList());
		if(policies.isEmpty())
		{
			throw new PolicyNotFoundException("policy not found Exception");
		}
		return policies;
	}

	@Override
	public List<Policy> getByCoverage(String coverage) throws PolicyNotFoundException {
		List<Policy>policies=policyDao.findByCoverage(coverage).stream()
				.sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
				.collect(Collectors.toList());
		if(policies.isEmpty())
		{
			throw new PolicyNotFoundException("policy not found Exception");
		}
		return policies;
	}

	@Override
	public List<Policy> getByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		List<Policy>policies=policyDao.findByHighSumAssured(sumAssured)
				.stream().sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName())).collect(Collectors.toList());
		if(policies.isEmpty())
		{
			throw new PolicyNotFoundException("policy not found Exception");
		}
		return policies;
	}

	@Override
	public List<Policy> getByBrand(String brand) throws PolicyNotFoundException {
		List<Policy>policies=policyDao.findByBrand(brand)
				.stream().sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName())).collect(Collectors.toList());
		if(policies.isEmpty())
		{
			throw new PolicyNotFoundException("policy not found Exception");
		}
		return policies;
	}

	@Override
	public List<Policy> getByLessPremium(double premium) throws PolicyNotFoundException {
		List<Policy>policies=policyDao.findByLessPremium(premium)
				.stream().sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName())).collect(Collectors.toList());
		if(policies.isEmpty())
		{
			throw new PolicyNotFoundException("policy not found Exception");
		}
		return policies;
	}

	@Override
	public Policy getById(int policyId) throws IdNotFoundException {
		Policy policy=policyDao.findById(policyId);
		if(policy==null)
			throw new IdNotFoundException("policy Id is not there");
		return policy;
	}

	

}
