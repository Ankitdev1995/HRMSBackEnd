package com.ob.app.vendor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ob.app.vendor.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer>{

	List<Location> findByCity(String city);

	List<Location> findByRegion(String region);

	@Query("select l from Location l where l.city LIKE :cityName%")
	public List<Location> findLocationByCityStarting(@Param("cityName") String cityName);

	@Query("SELECT l FROM Location l where l.state LIKE :stateName%")
	public List<Location> findLocationByStateStartWith(@Param("stateName")String stateName);

	@Query("select l FROM Location l where l.country LIKE :countryName%")
	public List<Location> findByLocationCountryStartWith(@Param("countryName")String countryName);
	
	
	
}
