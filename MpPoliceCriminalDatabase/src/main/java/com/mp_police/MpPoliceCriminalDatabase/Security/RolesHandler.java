package com.mp_police.MpPoliceCriminalDatabase.Security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class RolesHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//Role=== ROLE_USER== Admin page
		//Role === ROLE_POLICE_OFFICER == OFFICER Page
		//Role=== ROLE_SUPER_ADMIN== SUPER Admin page
		//Role === ROLE_POLICE_STATION_MASTER == POLICE STATION MASTER Page
		
		Collection<? extends GrantedAuthority> auth=authentication.getAuthorities();
		String myurl=null;
		for(GrantedAuthority my:auth) {
			System.out.println("roles is "+my);
			if(my.getAuthority().equals("SUPER_ADMIN")) {
				System.out.println("Admin role");
				myurl="/admin";
				break;
			}else if(my.getAuthority().equals("POLICE_STATION_MASTER")) {
				System.out.println("Admin role");
				myurl="/police_station_master";
				break;
			}else if(my.getAuthority().equals("POLICE_OFFICER")) {
				System.out.println("User role");
				myurl="/police_officer";
				break;
			}else if(my.getAuthority().equals("USER")) {
				System.out.println("User role");
				myurl="/user";
				break;
			}
		}
		System.out.println(myurl);
		new DefaultRedirectStrategy()
		.sendRedirect(request, response, myurl);
		
	}

}
