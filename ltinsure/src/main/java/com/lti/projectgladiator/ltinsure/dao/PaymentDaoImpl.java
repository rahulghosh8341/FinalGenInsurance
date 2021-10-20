package com.lti.projectgladiator.ltinsure.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.projectgladiator.ltinsure.beans.Customer;
import com.lti.projectgladiator.ltinsure.beans.Payment;

@Repository
public class PaymentDaoImpl implements PaymentDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void save(Object obj) {
		//System.out.println("in repo.save");
		entityManager.merge(obj);
}
	@Override
	public Payment findPaymentDetailsByCustomerId(Customer customer) {
		int id = customer.getId();
		return (Payment) entityManager.createQuery("select pay from Payment where pay.customer = :id")
				.setParameter("id", id)
				.getSingleResult();
	}
	
	@Override
	public boolean isUserValid(String email) {
		return ((Number)entityManager.createNamedQuery("is-user-present")
				.setParameter("em", email)
				.getSingleResult()).intValue()== 1? true:false;
	}
	@Override
	public int findCustomerIdByEmail(String email)  {
		return ((Number)entityManager.createQuery("select cust.id from Customer cust where cust.emailId = :em")
				.setParameter("em", email)
				.getSingleResult()).intValue();
	}
	
	@Override
	public Customer getCustomerByEmail(String email) {
		//int id = customer.getId();
		return (Customer) entityManager.createQuery("select cust from Customer cust where cust.emailId = :em")
				.setParameter("em", email)
				.getSingleResult();
	}
}
