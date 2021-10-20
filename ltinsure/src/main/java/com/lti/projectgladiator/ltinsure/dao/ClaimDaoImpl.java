package com.lti.projectgladiator.ltinsure.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.projectgladiator.ltinsure.beans.Claim;
import com.lti.projectgladiator.ltinsure.beans.Customer;
import com.lti.projectgladiator.ltinsure.beans.Policy;

@Repository
public class ClaimDaoImpl implements ClaimDao{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Claim submitAndUpdatingOfClaimInsurance(Claim claim) {
		return entityManager.merge(claim);
	}

	@Override
	public Claim fetchDataByIdForClaimInsurance(int id) {
		Claim claim = entityManager.find(Claim.class, id);
		return claim;
	}
	

	@Override
	public List<Claim> fetchAllClaimData() {
		Query q = entityManager.createQuery("select claim from Claim as claim");
		List<Claim> list = q.getResultList();
		return list;
	}

	@Override
	public Customer findByCustomerId(int id) {
		return entityManager.find(Customer.class, id);
	}

	@Override
	public Policy findByPolicyId(int id) {
		return entityManager.find(Policy.class, id);
	}

	@Override
	public Claim getRecent() {
		
		return null;
	}
}
