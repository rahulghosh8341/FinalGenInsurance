package com.lti.projectgladiator.ltinsure.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.projectgladiator.ltinsure.beans.Policy;
import com.lti.projectgladiator.ltinsure.dao.RenewDao;
import com.lti.projectgladiator.ltinsure.status.Status;
import com.lti.projectgladiator.ltinsure.status.Status.StatusType;

@Service
public class RenewServiceImpl implements RenewService {
	
	@Autowired
	private RenewDao renewRepository;
	Status status = new Status();
	@Override
	public Status renewIns(Policy policy) {
	  if(renewRepository.isPolicyPresent(policy.getId())) {
		if(renewRepository.isPolicyExpired(policy.getId())) {
			//System.out.println("in service");
			Policy existingPolicy = renewRepository.findByPolicyId(policy.getId());
			//System.out.println(existingPolicy.getStatus());
			existingPolicy.setStatus("Renewed");
			existingPolicy.setPlanAmount(policy.getPlanAmount()*policy.getDuration());
			existingPolicy.setPolicyAmount((policy.getPlanAmount()*100)/3);
			existingPolicy.setIssueDate(LocalDate.now());
			existingPolicy.setDuration(policy.getDuration());
			existingPolicy.setExpiryDate(LocalDate.of(LocalDate.now().getYear()+(policy.getDuration()),
					LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth()));
			renewRepository.save(existingPolicy);
			//Policy p = renewRepository.findByPolicyId(policy.getId());
			
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Your policy has been renewed!");
			return status;
			
		}
		else {
			status.setStatus(StatusType.FAILURE);
			status.setMessage("Policy has not expired yet. Cannot be renewed");
//			throw new RenewServiceException("Policy has not expired yet. Cannot be renewed");
			return status;
			}
	}
	  else {
		  status.setStatus(StatusType.FAILURE);
			status.setMessage("Policy does not exist");
//			throw new RenewServiceException("Policy has not expired yet. Cannot be renewed");
			return status;
	  }
}
}