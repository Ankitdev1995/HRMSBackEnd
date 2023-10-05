package com.ob.app.vendor.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ob.app.vendor.entity.PointOfContact;
import com.ob.app.vendor.exception.PointOfContactNotFoundException;
import com.ob.app.vendor.repository.PointOfContactRepository;
import com.ob.app.vendor.service.PointOfContactService;

@Service
public class PointOfContactServiceImpl implements PointOfContactService {

	@Autowired
	private PointOfContactRepository pointOfContactRepository;

	@Override
	public PointOfContact savePointOfContact(PointOfContact pointOfContact) {
		PointOfContact saved = 	pointOfContactRepository.save(pointOfContact);
		return saved;
	}

	@Override
	public PointOfContact updatePointOfContact(PointOfContact pointOfContact ,int pointOfContactId) {

		Optional<PointOfContact> existingPoint = pointOfContactRepository.findById(pointOfContactId);

		if(existingPoint.isPresent()) {
			PointOfContact updatedPoint = existingPoint.get();

			updatedPoint.setCompanyName(pointOfContact.getCompanyName());
			updatedPoint.setMobileNo(pointOfContact.getMobileNo());
			updatedPoint.setEmaildId(pointOfContact.getEmaildId());

			return pointOfContactRepository.save(updatedPoint);
		}else {
			throw new PointOfContactNotFoundException("point of contact not found with id :"+ pointOfContactId);
		}		
	}

	@Override
	public List<PointOfContact> getAllPointOfContact() {
		List<PointOfContact> getall = pointOfContactRepository.findAll();
		return getall;
	}

	@Override
	public boolean deletePointOfContact(int pointOfContactId) {

		if (pointOfContactRepository.existsById(pointOfContactId)) {

			pointOfContactRepository.deleteById(pointOfContactId);

			return true; 
		}
		return false; 
	}

	@Override
	public List<PointOfContact> getPointOfContactCompanyName(String companyName) {
		List<PointOfContact> companyNames = pointOfContactRepository.findBycompanyName(companyName);
		return companyNames;
	}
}
