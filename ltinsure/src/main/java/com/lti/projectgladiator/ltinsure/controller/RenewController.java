package com.lti.projectgladiator.ltinsure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.projectgladiator.ltinsure.beans.Policy;
import com.lti.projectgladiator.ltinsure.dao.RenewDao;
import com.lti.projectgladiator.ltinsure.exception.RenewServiceException;
import com.lti.projectgladiator.ltinsure.service.RenewService;
import com.lti.projectgladiator.ltinsure.status.Status;
import com.lti.projectgladiator.ltinsure.status.Status.StatusType;

@RestController
@CrossOrigin
public class RenewController {
	
	@Autowired
	private RenewService renewService;
	Status stu = new Status();	
	
	@Autowired
	private RenewDao renewRepo;
	
	@PostMapping(path = "/renew", consumes = "application/json", produces = "application/json")
	public Status renew(@RequestBody Policy policy) {
		Policy newPolicy = new Policy();
	  try {
		  //System.out.println(policy.getId()+" "+policy.getDuration()+" "+policy.getExpiryDate()+" "+policy.getIssueDate()+" "+policy.getPlanAmount()+" "+policy.getPolicyAmount()+" "+policy.getStatus());
		  stu = renewService.renewIns(policy);
		  //System.out.println("Renewed");
		  newPolicy =  renewRepo.findByPolicyId(policy.getId());
		  
		//System.out.println("renewed");
		//return "success";
		
		//Status status = new Status();
		//status.setStatus(StatusType.SUCCESS);
		//status.setMessage("Policy renewed!");
		//return status;
	   }
		catch(RenewServiceException e) {
			//Status status = new Status();
			//status.setStatus(StatusType.FAILURE);
			//status.setMessage(e.getMessage());
			//return status;
			System.out.println(e.getMessage());
		//}
			//return newPolicy;
	}
	return stu;
	
	
}
}