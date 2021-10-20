package com.lti.projectgladiator.ltinsure.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.projectgladiator.ltinsure.beans.Customer;
import com.lti.projectgladiator.ltinsure.beans.Policy;

@Repository
public class RenewDaoImpl implements RenewDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void save(Object obj) {
		//System.out.println("in repo.save");
		entityManager.merge(obj);
	}
	
	@Override
	public Policy findByPolicyId(int id) {
		return (Policy) entityManager.find(Policy.class, id);
	}
	
	@Override
	public boolean isPolicyPresent(int id) {
		return ((Number)entityManager.createQuery("select count(p.id) from Policy p where p.id = :id")
				.setParameter("id", id)
				.getSingleResult()).intValue() == 1 ? true : false;
	}
	
	@Override
	public boolean isPolicyExpired(int id) {
		return ((Long)entityManager.createQuery("select count(p.id) from Policy p where p.expiryDate <= CURRENT_DATE and p.id = :id")
				.setParameter("id", id)
				.getSingleResult()).longValue() == 1 ? true : false;
//		Policy existingPolicy = findByPolicyId(id);
//		if((existingPolicy.getStatus()).equals("Expired")) {
//			return true;
//		}
//		else return false;
	}
	@Override
	public Customer findCustomerByPolicyId(int id) {
		return (Customer) entityManager.createQuery("select c from Customer c, Policy p where p.customer = :id and c.id = :id")
				.setParameter("id", id)
				.getSingleResult();
	}
	
}
