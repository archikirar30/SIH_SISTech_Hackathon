package com.mp_police.MpPoliceCriminalDatabase.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mp_police.MpPoliceCriminalDatabase.dto.Criminal;

public interface CriminalRepository extends JpaRepository<Criminal, Long>{

}
