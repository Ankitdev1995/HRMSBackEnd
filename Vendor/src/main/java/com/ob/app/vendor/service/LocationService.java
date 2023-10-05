package com.ob.app.vendor.service;

import java.util.List;

import com.ob.app.vendor.entity.Location;

public interface LocationService {

	public Location saveLocation(Location location);

	public Location updateLocation(Location location ,int locationId);

	public boolean deleteLocation(int locationId);

	public List<Location> getAllLocation();

	public List<Location> getLocationByCity(String city);

	public List<Location> getLocationByRegion(String region);

	public List<Location> searchLocationWithFirst(String cityName);

	public List<Location> searchLocationWthState(String stateName);

	public List<Location> searchLocationWithCountry(String country);
}
