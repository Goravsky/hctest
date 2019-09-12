package com.example.hctest.repository;

import com.example.hctest.model.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CodesRepository extends JpaRepository<Code, Long> {
    @Query("SELECT c FROM Code c WHERE c.code = ?1")
    Code findByCode(int code);
}
