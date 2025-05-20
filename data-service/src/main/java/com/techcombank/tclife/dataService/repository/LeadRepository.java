package com.techcombank.tclife.dataService.repository;

import com.techcombank.tclife.dataService.model.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends JpaRepository<Lead, String> {
}
