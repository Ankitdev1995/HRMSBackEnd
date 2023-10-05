package com.ob.app.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ob.app.company.entity.TaxInfo;

public interface TaxInfoRepository extends JpaRepository<TaxInfo, Long> {

}
