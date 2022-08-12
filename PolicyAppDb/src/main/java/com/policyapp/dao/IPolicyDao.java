package com.policyapp.dao;

import java.util.List;

import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;

public interface IPolicyDao {
	void addPolicy(Policy policy);

	void deletePolicy(int policyId);

	void updatePolicy(int policyId, String coverage);

	List<Policy> findAll();

	List<Policy> findByType(String type) throws PolicyNotFoundException;

	List<Policy> findByCategory(String category) throws PolicyNotFoundException;

	List<Policy> findByCoverage(String coverage) throws PolicyNotFoundException;

	List<Policy> findByHighSumAssured(double SumAssured) throws PolicyNotFoundException;

	List<Policy> findByBrand(String brand) throws PolicyNotFoundException;

	List<Policy> findByLessPremium(double premium) throws PolicyNotFoundException;

	Policy findById(int policyId) throws IdNotFoundException;
}
