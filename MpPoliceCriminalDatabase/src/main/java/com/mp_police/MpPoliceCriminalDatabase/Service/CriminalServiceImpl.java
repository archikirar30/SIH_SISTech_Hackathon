package com.mp_police.MpPoliceCriminalDatabase.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mp_police.MpPoliceCriminalDatabase.dao.CriminalRepository;
import com.mp_police.MpPoliceCriminalDatabase.dto.Criminal;

public class CriminalServiceImpl implements CriminalService {
	
	
	@Autowired
	CriminalRepository criminalrepo;

	@Override
	public void deleteCriminal(long criminalId) {
		criminalrepo.deleteById(criminalId);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Criminal searchCriminal(Long id) {
		criminalrepo.findById(id);
		return null;
	}

	@Override
	public Criminal addCriminal(Criminal criminal) {
		criminalrepo.save(criminal);
		return null;
	}

	@Override
	public List<Criminal> SearchByKeyword(String keyword) {
		if(keyword != null) {
    		return criminalrepo.findAll(keyword);
    	}
    	return criminalrepo.findAll();
	}

}
