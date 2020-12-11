package thms.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thms.model.Traveller;
import thms.repository.TravellerRepository;

@Service
@Transactional
public class TravelService implements InterfaceTravelService {
	
	@Autowired
	TravellerRepository travellerRepository;
	
	public List<Traveller> getAllTravellers(){
		List<Traveller> travellers = new ArrayList<Traveller>();  
		travellerRepository.findAll().forEach(traveller -> travellers.add(traveller));  
		return travellers; 
		
	}
	
	public  Traveller getTravellerById(int id)   
	{  
	return travellerRepository.findById(id).get();  
	}  
	

	
	public void saveTraveller(Traveller newTraveller)   
	{  
	travellerRepository.save(newTraveller);  
	} 

	@Override
	public List<Traveller> findByName(String name) {
		
		List<Traveller> travellers = (List<Traveller>) travellerRepository.findByName(name);
		return travellers;		
	}

	@Override
	public List<Traveller> findByDestination(String destination) {
		List<Traveller> travellers = (List<Traveller>) travellerRepository.findByDestination(destination);
		return travellers;
	}

	public void updateTraveller(int id, Traveller uTraveller) {
		String destination=uTraveller.getDestination();
		Date endDate=uTraveller.getEndDate();
		travellerRepository.update(id, destination, endDate);
		
	}  
	

}
