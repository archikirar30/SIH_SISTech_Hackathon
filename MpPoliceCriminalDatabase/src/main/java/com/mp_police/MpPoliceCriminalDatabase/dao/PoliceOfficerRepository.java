package com.mp_police.MpPoliceCriminalDatabase.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mp_police.MpPoliceCriminalDatabase.dto.PoliceOfficer;
import com.mp_police.MpPoliceCriminalDatabase.dto.User;

public interface PoliceOfficerRepository extends JpaRepository<PoliceOfficer, Long>{


}
