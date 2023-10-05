package com.ob.app.partner.service;

import java.util.List;

import com.ob.app.partner.entity.Location;

public interface LocationService {
	
	public Location saveLocation(Location location);
	
	public Location updateLocation(Location location ,int locationId);
	
	public boolean deleteLocation(int locationId);
	
	public List<Location> getAllLocation();
	
	public List<Location> getLocationByCity(String city);
	
	public List<Location> searchIdByRange(int min, int max);
	
	public List<Location> findByorder();
	
	public List<Location> findLocationsByCityStartingWith(String city);

	public List<Location> searchPincode(String pin);
}
