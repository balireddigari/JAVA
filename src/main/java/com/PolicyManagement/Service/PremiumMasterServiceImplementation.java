package com.PolicyManagement.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import com.PolicyManagement.Model.PaymentMethods;
import com.PolicyManagement.Model.PremiumMaster;
import com.PolicyManagement.Repository.PremiumMasterRepository;
import com.PolicyManagement.dto.DTOClass;

import ch.qos.logback.classic.Logger;

@Service
public class PremiumMasterServiceImplementation implements PremiumMasterService {
 
    private final PremiumMasterRepository premiumMasterRepository;
    
    @Autowired
    private RestTemplate restTemplate;
   
 
    @Autowired
    public PremiumMasterServiceImplementation(PremiumMasterRepository premiumMasterRepository) {
        this.premiumMasterRepository = premiumMasterRepository;
    }
    
   
    @Override
    public PremiumMaster addNewPremiumMaster(PremiumMaster premiumMaster) {
        return premiumMasterRepository.save(premiumMaster);
    }
    
    @Override
	public List<PremiumMaster> getDuePaymentUserDetails() {
		
		return premiumMasterRepository.getDuePaymentUserDetails();
	}
    
    
    @Override
	public Optional<PremiumMaster> getMaster(int id) {
		// TODO Auto-generated method stub
		Optional<PremiumMaster> masterId = premiumMasterRepository.findById(id);
		DTOClass forObj = restTemplate.getForObject(
				"http://localhost:8082/api/getByUserName/"+ masterId.get().getUsername(), DTOClass.class);
		System.out.println(forObj.getUsername());
		
		return masterId;
	}
    


        

}