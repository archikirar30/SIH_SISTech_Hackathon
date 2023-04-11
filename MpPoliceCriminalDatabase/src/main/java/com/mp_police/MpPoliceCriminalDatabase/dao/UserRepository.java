package com.mp_police.MpPoliceCriminalDatabase.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mp_police.MpPoliceCriminalDatabase.dto.Car;
import com.mp_police.MpPoliceCriminalDatabase.dto.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserName(String username);

}
