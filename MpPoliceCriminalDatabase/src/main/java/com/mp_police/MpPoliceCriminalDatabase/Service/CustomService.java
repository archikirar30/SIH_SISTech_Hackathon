package com.mp_police.MpPoliceCriminalDatabase.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mp_police.MpPoliceCriminalDatabase.Security.ApplicationUserDetail;
import com.mp_police.MpPoliceCriminalDatabase.dao.UserRepository;
import com.mp_police.MpPoliceCriminalDatabase.dto.User;

@Service
public class CustomService implements UserDetailsService {
	 @Autowired
		UserRepository userrepo;
	    User user;
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			// TODO Auto-generated method stub
			user=userrepo.findByUserName(username);
			if(user==null) {
				System.out.println("User name is Invalid");
			}
			return new ApplicationUserDetail(user);
		}

}
