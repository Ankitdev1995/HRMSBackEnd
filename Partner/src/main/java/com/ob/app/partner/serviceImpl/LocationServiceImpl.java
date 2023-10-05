package com.ob.app.partner.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ob.app.partner.entity.Location;
import com.ob.app.partner.exception.LocationNotFoundException;
import com.ob.app.partner.repository.LocationRepository;
import com.ob.app.partner.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public Location saveLocation(Location location) {
		Location saved = locationRepository.save(location);
		return saved;
	}

	@Override
	public Location updateLocation(Location location, int locationId) {

		Optional<Location>	ExistLocation = locationRepository.findById(locationId);

		if(ExistLocation.isPresent() ) {

			Location updatelocation =  ExistLocation.get();

			updatelocation.setAddressLine1(location.getAddressLine1());
			updatelocation.setAddressLine2(location.getAddressLine2());
			updatelocation.setRegion(location.getRegion());
			updatelocation.setCountry(location.getCountry());
			updatelocation.setState(location.getState());
			updatelocation.setCity(location.getCity());
			updatelocation.setPin(location.getPin()); 

			return locationRepository.save(updatelocation);	
		} else {
			throw new LocationNotFoundException ("Location not found with ID: " + locationId);
		}
	}

	@Override
	public boolean deleteLocation(int locationId) {
		if(locationRepository.existsById(locationId)) {
		
			locationRepository.deleteById(locationId);

			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Location> getAllLocation() {
		List<Location> getAllLoc = locationRepository.findAll();
		return getAllLoc;
	}

	@Override
	public List<Location> getLocationByCity(String city) {
		List<Location> getloc = locationRepository.findByCity(city);
		return getloc;
	}

	@Override
	public List<Location> searchIdByRange(int min, int max) {
	List<Location> list	= locationRepository.findBylocationIdRange(min, max);
		return list;
	}

	
	@Override
	public List<Location> findByorder() {
		
		List<Location> list =  locationRepository.searchbycity();
		return list;
	}


	@Override
	public List<Location> findLocationsByCityStartingWith(String city) {
	return	locationRepository.findLocationsByCityStartingWith(city);
		
	}

	@Override
	public List<Location> searchPincode(String pin) {
	
		return locationRepository.findPincodeStartsWith(pin);

	}
}
