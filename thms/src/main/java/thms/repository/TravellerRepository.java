package thms.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import thms.model.Traveller;

@Repository
public interface TravellerRepository extends CrudRepository<Traveller, Integer>{
	

	@Query("select t from Traveller t where t.name LIKE ?4")
	List<Traveller> findByName(String name);
	 
	
	@Query("select t from Traveller t where t.destination LIKE ?1")
	List<Traveller> findByDestination(String destination);
	
	@Modifying
	
	@Query("update Traveller t set t.destination = ?2, t.endDate = ?3 where t.id = ?1")
	void update(int id, String destination, Date endDate);

}
