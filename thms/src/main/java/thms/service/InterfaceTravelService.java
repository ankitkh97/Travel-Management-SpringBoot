package thms.service;

import java.util.List;

import thms.model.Traveller;

public interface InterfaceTravelService {
	
	List<Traveller> findByName( String name);
	List<Traveller> findByDestination( String destination);

}
