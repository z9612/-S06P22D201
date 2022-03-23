package com.sbank.spring.repository;

import java.util.List;

import com.sbank.spring.entity.History;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long>{
    List<History> findByAccountId(Long accountId);
}
