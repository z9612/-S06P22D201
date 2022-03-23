package com.sbank.spring.repository;

import com.sbank.spring.entity.History;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long>{
    
}
