package com.lti.projectgladiator.ltinsure.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.projectgladiator.ltinsure.beans.Customer;
import com.lti.projectgladiator.ltinsure.beans.InsurancePlan;
import com.lti.projectgladiator.ltinsure.beans.Policy;
import com.lti.projectgladiator.ltinsure.beans.Vehicle;

@Repository
public class PolicyDaoImpl implements PolicyDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public int submissionOfBuyInsuranceData(Vehicle vehicle) {
		Vehicle v1 = entityManager.merge(vehicle);
		System.out.println(v1.getId());
		return v1.getId();
	}

	@Transactional
	public void submitPolicyDate(Policy policy) {
		entityManager.merge(policy);
	}
	
	public boolean isSameVehicleIsInsuredAlready(String registrationNo) {
		return (Long) entityManager.createQuery("select count(v.id) from Vehicle as v where v.registrationNo= :reNo ")
				.setParameter("reNo", registrationNo).getSingleResult() == 1 ? true : false;
	}
	
	

	@Override
	public Customer findById(int id) {
		return entityManager.find(Customer.class, id);
	}
	
	@Override
	public List<InsurancePlan> getAllInsuranceData() {
		Query q = entityManager.createQuery("select plan from InsurancePlan as plan");
		List<InsurancePlan> list = q.getResultList();
		return list;
	}

	@Override
	public InsurancePlan findInsuranceById(int id) {
		return entityManager.find(InsurancePlan.class, id);
	}

	@Override
	public List<Policy> getAllPolicy() {
		Query q = entityManager.createQuery("select policy from Policy as policy");
		List<Policy> list = q.getResultList();
		return list;
	}

	@Override
	public Vehicle findVehicleById(int id) {
		return entityManager.find(Vehicle.class, id);
	}
}
