package com.ob.app.partner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ob.app.partner.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer>{

	List<Location> findByCity(String city);

	@Query("FROM Location WHERE locationId>=:min and locationId<=:max")
	List<Location> findBylocationIdRange(int min, int max);
 
	@Query("SELECT l FROM Location l ORDER BY l.city ASC")
	public List<Location> searchbycity();

	@Query("SELECT l FROM Location l WHERE l.city LIKE :cityName%")
	public List<Location> findLocationsByCityStartingWith(@Param("cityName") String cityName);
	
	@Query("SELECT l FROM Location l where l.pin LIKE :pinCode%")
	public List<Location> findPincodeStartsWith(@Param("pinCode") String pinCode);
	
	
 	
}


