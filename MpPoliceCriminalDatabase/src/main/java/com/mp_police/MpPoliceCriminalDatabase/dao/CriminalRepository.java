package com.mp_police.MpPoliceCriminalDatabase.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.mp_police.MpPoliceCriminalDatabase.dto.Criminal;
@Repository
public interface CriminalRepository extends JpaRepository<Criminal, Long>{

	@Query("SELECT c FROM Criminal c WHERE c.criminalName LIKE %?1%"
			+ "OR c.ageOfCriminal LIKE %?1%"
			+ "OR c.longitude LIKE %?1%"
			+ "OR c.educated LIKE %?1%"
			+ "OR c.latitude LIKE %?1%"
			+ "OR c.typeOfCrime LIKE %?1%"
			+ "OR c.timeOfCrime LIKE %?1%"
			+ "OR c.crimeDate LIKE %?1%")
	public List<Criminal> findAll (String keyword);
}
