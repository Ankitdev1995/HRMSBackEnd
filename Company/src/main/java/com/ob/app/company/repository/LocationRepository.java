package com.ob.app.company.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ob.app.company.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer>{

	public Optional<Location> findByCity(String city);
	
	public List<Location> findByRegion(String region);
	
	public List<Location> findByLocationName(String locationName);
	
	@Query("Select l from Location l where l.locationName=:n or l.city=:c")
	public List<Location> findByLocationNameOrCity(@Param("n") String locationName, @Param("c") String city);
	
}
