package com.ob.app.company.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ob.app.company.entity.Designation;
import com.ob.app.company.repository.DesignationRepository;
import com.ob.app.company.services.DesignationService;

@Service
public class DesignationServiceImpl implements DesignationService {


	@Autowired
	private DesignationRepository designationRepository;

	@Override
	public Designation saveDesignation(Designation designation) {
		Designation saved = designationRepository.save(designation);
		return saved;
	}

	@Override
	public String deleteDesignation(int designationId) {
		designationRepository.deleteById(designationId);
		return "delete designation with id :"+ designationId;
	}

	@Override
	public List<Designation> getAllDesignation() {
		List<Designation> findAll = designationRepository.findAll();
		return findAll;
	}

	@Override
	public List<Designation> getDesignationByGroupName(String groupName) {
		List<Designation> listDisignation = designationRepository.findByGroupName(groupName);
		return listDisignation;
	}

	@Override
	public Optional<Designation> getDesignationById(int designationId) {
	Optional<Designation> findById = designationRepository.findById(designationId);
		return findById;
	}

}
