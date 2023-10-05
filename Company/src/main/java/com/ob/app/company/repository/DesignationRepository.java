package com.ob.app.company.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ob.app.company.entity.Designation;

public interface DesignationRepository extends JpaRepository<Designation, Integer> {

	public List<Designation> findByGroupName(String groupName);


}
