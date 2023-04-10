package com.MpPolicecriminalDatabase.CrimalDatabase_Mp.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MpPolicecriminalDatabase.CrimalDatabase_Mp.dao.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);
	
	 //Check or Find existing mail - return true or false
    //For Register (duplicate mail)
    Boolean existsByEmail(String email);
}

