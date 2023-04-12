package com.mp_police.MpPoliceCriminalDatabase.Service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.mp_police.MpPoliceCriminalDatabase.dto.Criminal;

@Service
@Transactional
public interface CriminalService {
	
	public List<Criminal> SearchByKeyword (String keyword);
	
	public Criminal addCriminal(Criminal criminal);
	
	public void deleteCriminal(long criminalId);
	
	public Criminal searchCriminal(Long id );
	
}

