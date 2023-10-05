package com.ob.app.partner.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ob.app.partner.entity.Location;
import com.ob.app.partner.service.LocationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/partner")
public class LocationController {

	@Autowired
	private LocationService locationService;

	@PostMapping("/new")
	public ResponseEntity<Location> saveLocation(@Valid  @RequestBody Location location){
		Location locationSaved = locationService.saveLocation(location);
		return new ResponseEntity<Location>(locationSaved, HttpStatus.CREATED);
	}

	@PutMapping("/update/{locationId}")
	public ResponseEntity<Object>updateLocation(@RequestBody Location location, @PathVariable int locationId){
		locationService.updateLocation(location, locationId);

		return new ResponseEntity<Object>("project is updated with location id:"+ locationId, HttpStatus.OK);
	}


	@DeleteMapping("/delete/{locationId}")
	public ResponseEntity<String> deleteLocation(@PathVariable int locationId){

		boolean deleteLocation = locationService.deleteLocation(locationId);	
		if(deleteLocation) {
			return new ResponseEntity<>("location is deleted :" + locationId, HttpStatus.OK);
		}else { 
			return new ResponseEntity<>("location is not found with id:"+ locationId ,HttpStatus.NOT_FOUND);
		}
	}


	@GetMapping("/getloc")
	public ResponseEntity<List<Location>> AllLocation(){
		List<Location> getLoc=  locationService.getAllLocation();
		return new ResponseEntity<List<Location>>(getLoc, HttpStatus.OK);
	}


	@GetMapping("/getlo/{city}")
	public ResponseEntity<List<Location>> getLocationByName(@PathVariable String city){
		List<Location> locationcity = locationService.getLocationByCity(city);
		if(!locationcity.isEmpty()) {
			return new ResponseEntity<List<Location>>(locationcity, HttpStatus.OK);
		}else {
			return new ResponseEntity("location is not found with given city :" + city, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/locations")
	public List<Location> getLocationsInRange(
			@RequestParam("min") int min,
			@RequestParam("max") int max)
	{
		return locationService.searchIdByRange(min, max);
	}

	@GetMapping("/ascf")
	public ResponseEntity<List<Location>> searchByAscending(){
		List<Location> listLoc = locationService.findByorder();
		return new ResponseEntity<List<Location>>(listLoc, HttpStatus.OK);
	}

	// http://localhost:8082/api/partner/cities?cityName=B
	@GetMapping("/cities")
	public ResponseEntity<List<Location>> getLocationsByCityStartingWith(@RequestParam("cityName") String cityName) {
		List<Location> cities =  locationService.findLocationsByCityStartingWith(cityName);
		if(!cities.isEmpty()) {
			return new ResponseEntity<List<Location>>(cities, HttpStatus.OK);
		}else {
			return new ResponseEntity(" cities not start with : " + cityName, HttpStatus.NOT_FOUND);
		}
	}

	// http://localhost:8082/api/partner/searchpin?pinCode=42
	@GetMapping("/searchpin")
	public ResponseEntity<List<Location>> searchPinStartesWith(@RequestParam("pinCode") String pinCode){
		List<Location> list =  locationService.searchPincode(pinCode);
		if(!list.isEmpty()) {
			return new ResponseEntity<List<Location>>(list, HttpStatus.OK);
		}else {
			return new ResponseEntity("pincode is not start with :" + pinCode, HttpStatus.NOT_FOUND);
		}
	}
}
