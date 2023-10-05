package com.ob.app.company.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ob.app.company.entity.Location;
import com.ob.app.company.exception.LocationNotFoundException;
import com.ob.app.company.services.LocationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/company")
public class LocationController {

	@Autowired
	private LocationService locationService;

	@PostMapping("/newloc")
	public ResponseEntity<Location> saveLocation(@Valid @RequestBody Location location){
		Location savedLocation = locationService.saveLocation(location);
		return new ResponseEntity<Location>(savedLocation, HttpStatus.CREATED);
	}

	@PutMapping("/update/{locationId}")
	public ResponseEntity<Location> updateLocation(@RequestBody Location location, @PathVariable int locationId){
		Location updateloc = locationService.updateLocation(location, locationId);
		return new ResponseEntity<Location>(updateloc, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{locationId}")
	public ResponseEntity<String> deleteLocation(@PathVariable int locationId){
		String  deleteLocation = locationService.deleteLocation(locationId);
		return new ResponseEntity<String>(deleteLocation, HttpStatus.OK);
	}


	@GetMapping("/getByCity/{city}")
	public ResponseEntity<Location> getLocationByCity(@PathVariable String city) {
		Optional<Location> searchLocationByCity = locationService.SearchLocationByCity(city);

		if(searchLocationByCity.isPresent()) {
			Location location = searchLocationByCity.get();
			return new ResponseEntity<Location>(location, HttpStatus.OK);
		}else {
			throw new LocationNotFoundException("location is not found with city "+ city);
		}
	}

	@GetMapping("/getByRegion/{region}")
	public ResponseEntity<List<Location>> getLocationByRegion(@PathVariable String region){
		List<Location> searchLocationByRegion = locationService.searchLocationByRegion(region);
		if(!searchLocationByRegion.isEmpty()) {
			return new ResponseEntity<List<Location>>(searchLocationByRegion , HttpStatus.OK);
		}else {
			throw new LocationNotFoundException("location is not found with region : " + region);
		}
	}

	@GetMapping("/getByLocation/{locationName}")
	public ResponseEntity<List<Location>> getLocationByLocationName(@PathVariable String locationName){
		List<Location> searchLocationByName = locationService.getLocationByName(locationName);
		if(!searchLocationByName.isEmpty()){
			return new ResponseEntity<List<Location>>(searchLocationByName, HttpStatus.OK);
		}else {
			throw new LocationNotFoundException("location is not found with location name : " +locationName);
		}
	}
	
	@GetMapping("/{locationName}/{city}")
	public ResponseEntity<List<Location>> searchLocationByLocationNameOrCity(@PathVariable String locationName, @PathVariable String city){
		List<Location> list =	locationService.getLocatiobBylocationNameOrCity(locationName, city);
		return new  ResponseEntity<List<Location>>(list, HttpStatus.OK);
	}
}
