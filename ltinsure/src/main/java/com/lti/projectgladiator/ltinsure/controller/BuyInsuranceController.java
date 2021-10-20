package com.lti.projectgladiator.ltinsure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.projectgladiator.ltinsure.beans.Customer;
import com.lti.projectgladiator.ltinsure.beans.InsurancePlan;
import com.lti.projectgladiator.ltinsure.beans.Policy;
import com.lti.projectgladiator.ltinsure.beans.Vehicle;
import com.lti.projectgladiator.ltinsure.dto.PolicyDto;
import com.lti.projectgladiator.ltinsure.dto.VehicleDto;
import com.lti.projectgladiator.ltinsure.exception.InsuranceServiceException;
import com.lti.projectgladiator.ltinsure.service.PolicyService;
import com.lti.projectgladiator.ltinsure.status.Status;
import com.lti.projectgladiator.ltinsure.status.Status.StatusType;

@RestController
@CrossOrigin
public class BuyInsuranceController {

	@Autowired
	private PolicyService service;

	@GetMapping(path = "/getAllInsurance", produces = "application/json")
	public List<InsurancePlan> getAllInsurancePlans() {
		return service.getAllInsurancePlan();
	}
	@GetMapping(path = "/getAllPolicy", produces = "application/json")
	public List<Policy> getAllPolicies() {
		return service.getAllPolicies();
	}

	@PostMapping(path="/generatepolicy", consumes = "application/json", produces = "application/json")
	public Status submitePolicy(@RequestBody PolicyDto policydto) throws InsuranceServiceException {
		Policy policy = new Policy();
		
		policy.setIssueDate(policydto.getIssueDate());
		policy.setExpiryDate(policydto.getExpiryDate().plusYears(Integer.parseInt(policydto.getDuration())));
		policy.setDuration(Integer.parseInt(policydto.getDuration()));
		policy.setPlanAmount(policydto.getPlanAmount());
		policy.setPolicyAmount((policydto.getPolicyAmount()*100)/3);
		policy.setStatus(policydto.getStatus());
		
		Customer customer = service.findById(policydto.getCustomerid());
		
		InsurancePlan insure = service.getInsuranceById(policydto.getInsurancePlanid());
		
		Vehicle vehicle = service.getVehicleById(policydto.getVehicleId());

		policy.setInsurancePlan(insure);
		

		policy.setVehicle(vehicle);
		policy.setCustomer(customer);
		
		
		
		service.submitePolicyDetails(policy);
		
		Status status = new Status();
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Policy Generated.");
		return status;
	}

	@PostMapping(path = "/buyInsurance", consumes = "application/json", produces = "application/json")
	public int submissionDetail(@RequestBody VehicleDto vehicleDto) throws InsuranceServiceException {

			Vehicle vehicle = new Vehicle();

			vehicle.setChassisNo(vehicleDto.getChassisNo());
			vehicle.setDrivingLicense(vehicleDto.getDrivingLicense());
			vehicle.setEngineType(vehicleDto.getEngineType());
			vehicle.setEngineNo(vehicleDto.getEngineNo());
			vehicle.setManufacturer(vehicleDto.getManufacture());
			vehicle.setModel(vehicleDto.getModel());
			vehicle.setType(vehicleDto.getType());
			vehicle.setPurchaseDate(vehicleDto.getPurchaseDate());
			vehicle.setLastRenewDate(vehicleDto.getLastRenewDate());
			vehicle.setRegistrationNo(vehicleDto.getRegistrationNo());

			Customer customer = service.findById(vehicleDto.getCustomerId());

			vehicle.setCustomer(customer);

			int vehicleid =service.submissionOfBuyInsuranceDetails(vehicle);

			return vehicleid;
		
		
	}
}
