package com.ob.app.company.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ob.app.company.entity.Location;
import com.ob.app.company.exception.LocationNotFoundException;
import com.ob.app.company.repository.LocationRepository;
import com.ob.app.company.services.LocationService;

@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public Location saveLocation(Location location) {
		Location saveLocations = locationRepository.save(location);
		return saveLocations;	

	}

	@Override
	public Location updateLocation(Location location, int locationId) {
		Optional<Location> existingLocation	= locationRepository.findById(locationId);

		if(existingLocation.isPresent()) {
			Location newlocation = existingLocation.get();

			newlocation.setLocationId(location.getLocationId());
			newlocation.setLocationName(location.getLocationName());
			newlocation.setAddressLine1(location.getAddressLine1());
			newlocation.setAddressLine2(location.getAddressLine2());
			newlocation.setRegion(location.getRegion());
			newlocation.setCountry(location.getCountry());
			newlocation.setState(location.getState());
			newlocation.setPin(location.getPin());
			newlocation.setCity(location.getCity());
			newlocation.setContactNo1(location.getContactNo1());
			newlocation.setContactNo2(location.getContactNo2());

			return locationRepository.save(newlocation);		
		}else {
			throw new LocationNotFoundException("location not found with id :"+ locationId);
		}
	}

	
	@Override
	public String deleteLocation(int locationId) {
		locationRepository.deleteById(locationId);
		return "location is deleted";
	}

	@Override
	public Optional<Location> SearchLocationByCity(String city) {
		return locationRepository.findByCity(city);
	}

	@Override
	public List<Location> searchLocationByRegion(String region) {
		return locationRepository.findByRegion(region);
	}

	@Override
	public List<Location> getLocationByName(String locationName) {
		return locationRepository.findByLocationName(locationName);
	}

	@Override
	public List<Location> getLocatiobBylocationNameOrCity(String locationName, String city) {
		
		return locationRepository.findByLocationNameOrCity(locationName, city);
	}
}
