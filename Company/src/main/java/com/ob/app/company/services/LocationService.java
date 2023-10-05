package com.ob.app.company.services;

import java.util.List;
import java.util.Optional;

import com.ob.app.company.entity.Location;

public interface LocationService {

	public Location saveLocation(Location location);
	
	public Location updateLocation(Location location, int locationId);
	
	public String deleteLocation( int locationId);
	
	public Optional<Location> SearchLocationByCity(String city);
	
	public List<Location> searchLocationByRegion(String region);
	
	public List<Location> getLocationByName(String locationName);
	
	public List<Location> getLocatiobBylocationNameOrCity(String locationName, String city);
	
	
}
