package com.lti.projectgladiator.ltinsure.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.projectgladiator.ltinsure.beans.Claim;
import com.lti.projectgladiator.ltinsure.beans.Vehicle;

@Repository
public class DashboardDaoImpl implements DashboardDao {
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Claim> fetchByProcessingStatus(String processingStatus){
			Query q = entityManager.createQuery("select claim from Claim as claim where claim.status= :stats")
					.setParameter("stats", processingStatus);
			List<Claim> list = q.getResultList();
			return list;
	}
	
	
	@Override
	public long getCountRenew() {
		Query q = entityManager.createQuery("select count(p.id) from Policy as p where p.status='Renewed'");
		long count = (Long) q.getSingleResult();
		return count;
	}
	
	@Override
	public long getCountCustomer() {
		Query q = entityManager.createQuery("select count(c.id) from Customer as c");
		long count = (Long) q.getSingleResult();
		return count;
	}
	
	@Override
	public long getCountClaim() {
		Query q = entityManager.createQuery("select count(claim.id) from Claim as claim where claim.status = 'PENDING'");
		long count = (Long) q.getSingleResult();
		return count;
	}
	
	@Override
	public long getCountPolicy() {
		Query q = entityManager.createQuery("select count(policy.id) from Policy as policy");
		long count = (Long) q.getSingleResult();
		return count;
	}
	
	public Vehicle fetchVehicleDetails(int id) {
		
		Query q = entityManager.createQuery("select vehicle from Vehicle as vehicle where vehicle.id = :id")
				.setParameter("id", id);
		 Vehicle vehicle = (Vehicle) q.getSingleResult();
		return vehicle;
	}
	
	public double fetchClaimAmount(int id) {
		Query query = entityManager.createQuery("select claim.amount from Claim as claim where claim.id = : id")
				.setParameter("id", id);
		double amount = (double) query.getSingleResult();
		return amount;
	}
	
	@Override
	public long getUserInsuranceCount(int id) {
		Query q = entityManager.createQuery("select count(p.id) from Policy p where p.customer.id=:id").setParameter("id", id);
		long count = (Long) q.getSingleResult();
		return count;
	}
	
	@Override
	public long getUserClaimCount(int id) {
		Query q = entityManager.createQuery("select count(c.id) from Claim c where c.customer.id=:id").setParameter("id", id);
		long count = (Long) q.getSingleResult();
		return count;
	}
	
	@Override
	public long getUserRenewCount(int id) {
		Query q = entityManager.createQuery("select count(c.id) from Claim c where c.customer.id=:id and c.status='Renewed'").setParameter("id", id);
		long count = (Long) q.getSingleResult();
		return count;
	}
	
	@Override
	public long getUserDashboardData(int id) {
		Query q = entityManager.createQuery("select count(c.id) from Claim c where c.customer.id=:id and c.status='Renewed'").setParameter("id", id);
		long count = (Long) q.getSingleResult();
		return count;
	}
	
}
