package com.ob.app.company.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ob.app.company.entity.DesignationGroup;
import com.ob.app.company.repository.DesignationGroupRepository;
import com.ob.app.company.services.DesignationGroupService;

@Service
public class DesignationGroupServiceImpl implements DesignationGroupService{

	@Autowired
	private DesignationGroupRepository designationGroupRepository;

	@Override
	public DesignationGroup saveDesignationGroup(DesignationGroup designationGroup) {
		DesignationGroup saved = designationGroupRepository.save(designationGroup);
		return saved;

	}

	@Override
	public String deleteDesignationGroup(int designationGroupId) {
		designationGroupRepository.deleteById(designationGroupId);
		return "designation group is deleted with id : " + designationGroupId;
	}

	@Override
	public List<DesignationGroup> getAllDesginationGroup() {
		List<DesignationGroup> group = designationGroupRepository.findAll();
		return group;
	}
}
