package thms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import thms.model.Traveller;
import thms.service.TravelService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TravelController {
	
	@Autowired
	TravelService travelService;
	
	@GetMapping("/traveller")
	private List<Traveller> getAllTravellers(){
		
		return travelService.getAllTravellers();
	}
	
	@RequestMapping(value = "id/{id}", method = RequestMethod.GET)
	private Traveller getTravellerById(@PathVariable("id") int id)   
	{  
	return travelService.getTravellerById(id);  
	} 
	
	
	
	@RequestMapping(value ="name/{name}",method = RequestMethod.GET)
	private List<Traveller> getTravellerByName(@PathVariable("name") String name) {
		
		return travelService.findByName(name);
	}
	
	@RequestMapping(value = "destination/{destination}", method = RequestMethod.GET)
	private List<Traveller> getTravelleByDestination(@PathVariable("destination") String destination)   
	{  
	return travelService.findByDestination(destination);  
	}
	
	@PostMapping("/addTraveller")
	private int saveTraveller(@RequestBody Traveller newTraveller) {
		
		travelService.saveTraveller(newTraveller);
		return newTraveller.getId();
	}
	
	@PutMapping("/update/{id}")
	private void updateTraveller(@PathVariable int id, @RequestBody Traveller uTraveller) {
		
		travelService.updateTraveller(id, uTraveller);
	}
	
	

}
