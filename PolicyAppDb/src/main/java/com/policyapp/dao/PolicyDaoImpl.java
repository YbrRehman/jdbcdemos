package com.policyapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;
import com.policyapp.util.DbConnection;

public class PolicyDaoImpl implements IPolicyDao {
	
	Connection connection;
	
	@Override
	public void addPolicy(Policy policy) {
		String sql = "insert into policy(policy_name,premium,type,duration,coverage, brand, category,sum_assured) values(?,?,?,?,?,?,?,?)";
		connection = DbConnection.opnConnection();
		PreparedStatement preparedstatement=null;


		try {
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, policy.getPolicyName());
			preparedstatement.setDouble(2, policy.getPremium());
			preparedstatement.setString(3, policy.getType());
			preparedstatement.setInt(4, policy.getDuration());
			preparedstatement.setString(5, policy.getCoverage());
			preparedstatement.setString(6, policy.getCategory());
			preparedstatement.setString(7, policy.getBrand());
			preparedstatement.setDouble(8, policy.getSumAssured());
			preparedstatement.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {

				DbConnection.closeConnection();
				if (preparedstatement != null) {
					preparedstatement.close();
				}
			} catch (SQLException e) {

			}
		}
	}

	@Override
	public void deletePolicy(int policyId) {
		PreparedStatement preparedstatement=null;
		String sql = "delete from policy where policy_id=?" ;
		connection = DbConnection.opnConnection();
		
		try {
			preparedstatement = connection.prepareStatement(sql);
             preparedstatement.setInt(1, policyId);
			preparedstatement.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {

				DbConnection.closeConnection();
				if (preparedstatement != null) {
					preparedstatement.close();
				}
			} catch (SQLException e) {

			}
		}
	}

	@Override
	public void updatePolicy(int policyId, String coverage) {
		PreparedStatement preparedstatement=null;
		String sql = "update policy set coverage=? where policy_id=?";
		connection = DbConnection.opnConnection();
		try {
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, coverage);
			preparedstatement.setInt(2, policyId);
			preparedstatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {

				DbConnection.closeConnection();
				if (preparedstatement != null) {
					preparedstatement.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public List<Policy> findAll() {

		String sql = "select * from policy";
		PreparedStatement preparedstatement=null;
		List<Policy>policies=new ArrayList<Policy>();
		connection = DbConnection.opnConnection();
		ResultSet resultset = null;
		preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(sql);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				
				String policyName = resultset.getString("policy_name");
				Integer policyNumber = resultset.getInt("policy_id");
				double premium = resultset.getInt("premium");
				String type = resultset.getString("type");
				int duration = resultset.getInt("duration");
				String coverage = resultset.getString("coverage");
				String category = resultset.getString("category");
				String brand = resultset.getString("brand");
				double sumAssured = resultset.getInt("sum_assured");
				Policy policy=new Policy(policyName,policyNumber,premium,type,duration,coverage,category,brand,sumAssured);
				policies.add(policy);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {

				DbConnection.closeConnection();
				if (preparedstatement != null) {
					preparedstatement.close();
				}
			} catch (SQLException e) {
                System.out.println(e.getMessage());
			}
		}
		return policies;

		
	}

	@Override
	public List<Policy> findByType(String ntype) throws PolicyNotFoundException {
		String sql = "select * from policy where type=?";
		PreparedStatement preparedstatement=null;
		List<Policy>policies=new ArrayList<Policy>();
		connection = DbConnection.opnConnection();
		ResultSet resultset = null;
		preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, ntype);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				
				String policyName = resultset.getString("policy_name");
				Integer policyNumber = resultset.getInt("policy_id");
				double premium = resultset.getInt("premium");
				String type = resultset.getString("type");
				int duration = resultset.getInt("duration");
				String coverage = resultset.getString("coverage");
				String category = resultset.getString("category");
				String brand = resultset.getString("brand");
				double sumAssured = resultset.getInt("sum_assured");
				Policy policy=new Policy(policyName,policyNumber,premium,type,duration,coverage,category,brand,sumAssured);
				policies.add(policy);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {

				DbConnection.closeConnection();
				if (preparedstatement != null) {
					preparedstatement.close();
				}
			} catch (SQLException e) {
                System.out.println(e.getMessage());
			}
		}
		return policies;


	}

	@Override
	public List<Policy> findByCategory(String catgory) throws PolicyNotFoundException {

		String sql = "select * from policy where category=?";
		PreparedStatement preparedstatement=null;
		List<Policy>policies=new ArrayList<Policy>();
		connection = DbConnection.opnConnection();
		ResultSet resultset = null;
		preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1,catgory);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				
				String policyName = resultset.getString("policy_name");
				Integer policyNumber = resultset.getInt("policy_id");
				double premium = resultset.getInt("premium");
				String type = resultset.getString("type");
				int duration = resultset.getInt("duration");
				String coverage = resultset.getString("coverage");
				String category = resultset.getString("category");
				String brand = resultset.getString("brand");
				double sumAssured = resultset.getInt("sum_assured");
				Policy policy=new Policy(policyName,policyNumber,premium,type,duration,coverage,category,brand,sumAssured);
				policies.add(policy);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {

				DbConnection.closeConnection();
				if (preparedstatement != null) {
					preparedstatement.close();
				}
			} catch (SQLException e) {
                System.out.println(e.getMessage());
			}
		}
		return policies;

		
	}

	@Override
	public List<Policy> findByCoverage(String covrage) throws PolicyNotFoundException {

		String sql = "select * from policy where coverage=?";
		PreparedStatement preparedstatement=null;
		List<Policy>policies=new ArrayList<Policy>();
		connection = DbConnection.opnConnection();
		ResultSet resultset = null;
		preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1,covrage);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				
				String policyName = resultset.getString("policy_name");
				Integer policyNumber = resultset.getInt("policy_id");
				double premium = resultset.getInt("premium");
				String type = resultset.getString("type");
				int duration = resultset.getInt("duration");
				String coverage = resultset.getString("coverage");
				String category = resultset.getString("category");
				String brand = resultset.getString("brand");
				double sumAssured = resultset.getInt("sum_assured");
				Policy policy=new Policy(policyName,policyNumber,premium,type,duration,coverage,category,brand,sumAssured);
				policies.add(policy);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {

				DbConnection.closeConnection();
				if (preparedstatement != null) {
					preparedstatement.close();
				}
			} catch (SQLException e) {
                System.out.println(e.getMessage());
			}
		}
		return policies;

	}

	@Override
	public List<Policy> findByHighSumAssured(double SumAssured) throws PolicyNotFoundException {
		String sql = "select * from policy where sum_asured>=?" ;
		PreparedStatement preparedstatement=null;
		List<Policy>policies=new ArrayList<Policy>();
		connection = DbConnection.opnConnection();
		ResultSet resultset = null;
		preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setDouble(1,SumAssured);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				
				String policyName = resultset.getString("policy_name");
				Integer policyNumber = resultset.getInt("policy_id");
				double premium = resultset.getInt("premium");
				String type = resultset.getString("type");
				int duration = resultset.getInt("duration");
				String coverage = resultset.getString("coverage");
				String category = resultset.getString("category");
				String brand = resultset.getString("brand");
				double sumAssured = resultset.getInt("sum_assured");
				Policy policy=new Policy(policyName,policyNumber,premium,type,duration,coverage,category,brand,sumAssured);
				policies.add(policy);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {

				DbConnection.closeConnection();
				if (preparedstatement != null) {
					preparedstatement.close();
				}
			} catch (SQLException e) {
                System.out.println(e.getMessage());
			}
		}
		return policies;

		
	}

	@Override
	public List<Policy> findByLessPremium(double npremium) throws PolicyNotFoundException {
		String sql = "select * from policy where premium<=?";
		PreparedStatement preparedstatement=null;
		List<Policy>policies=new ArrayList<Policy>();
		connection = DbConnection.opnConnection();
		ResultSet resultset = null;
		preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setDouble(1,npremium);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				
				String policyName = resultset.getString("policy_name");
				Integer policyNumber = resultset.getInt("policy_id");
				double premium = resultset.getInt("premium");
				String type = resultset.getString("type");
				int duration = resultset.getInt("duration");
				String coverage = resultset.getString("coverage");
				String category = resultset.getString("category");
				String brand = resultset.getString("brand");
				double sumAssured = resultset.getInt("sum_assured");
				Policy policy=new Policy(policyName,policyNumber,premium,type,duration,coverage,category,brand,sumAssured);
				policies.add(policy);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {

				DbConnection.closeConnection();
				if (preparedstatement != null) {
					preparedstatement.close();
				}
			} catch (SQLException e) {
                System.out.println(e.getMessage());
			}
		}
		return policies;

	}

	@Override
	public Policy findById(int policyId) throws IdNotFoundException {

		String sql = "select * from policy where policy_id=?";
		PreparedStatement preparedstatement=null;
		connection = DbConnection.opnConnection();
		ResultSet resultset = null;
		preparedstatement = null;
		Policy policy=null;
		try {
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setInt(1,policyId);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				
				String policyName = resultset.getString("policy_name");
				Integer policyNumber = resultset.getInt("policy_id");
				double premium = resultset.getInt("premium");
				String type = resultset.getString("type");
				int duration = resultset.getInt("duration");
				String coverage = resultset.getString("coverage");
				String category = resultset.getString("category");
				String brand = resultset.getString("brand");
				double sumAssured = resultset.getInt("sum_assured");
				 policy=new Policy(policyName,policyNumber,premium,type,duration,coverage,category,brand,sumAssured);
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {

				DbConnection.closeConnection();
				if (preparedstatement != null) {
					preparedstatement.close();
				}
			} catch (SQLException e) {
                System.out.println(e.getMessage());
			}
		}
		return policy;

	}

	@Override
	public List<Policy> findByBrand(String nbrand) throws PolicyNotFoundException {
		String sql = "select * from policy where brand=?";
		PreparedStatement preparedstatement=null;
		List<Policy>policies=new ArrayList<Policy>();
		connection = DbConnection.opnConnection();
		ResultSet resultset = null;
		preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1,nbrand);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				
				String policyName = resultset.getString("policy_name");
				Integer policyNumber = resultset.getInt("policy_id");
				double premium = resultset.getInt("premium");
				String type = resultset.getString("type");
				int duration = resultset.getInt("duration");
				String coverage = resultset.getString("coverage");
				String category = resultset.getString("category");
				String brand = resultset.getString("brand");
				double sumAssured = resultset.getInt("sum_assured");
				Policy policy=new Policy(policyName,policyNumber,premium,type,duration,coverage,category,brand,sumAssured);
				policies.add(policy);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {

				DbConnection.closeConnection();
				if (preparedstatement != null) {
					preparedstatement.close();
				}
			} catch (SQLException e) {
                System.out.println(e.getMessage());
			}
		}
		return policies;

	
	}

	
}
