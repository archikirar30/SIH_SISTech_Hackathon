package com.sih_CriminalDatabaseSage.Criminal_Database.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig  extends WebSecurityConfigurerAdapter{
	private PasswordEncoder passwordencoder;
	@Autowired
    UserDetailsService userservice;
	@Autowired
	UserDetailsService userdetail;
    @Autowired
    ApplicationSecurityConfig (PasswordEncoder encoder){
    	this.passwordencoder=encoder;
    }
    @Autowired
    RolesHandler roles;
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		.authorizeRequests()
		.antMatchers("/","home","/signup","/about","/contact","/myreg" ,"/about","/login","/forms/**","/assets/**","/images/**" ,"/uploadedImage/**","/error").permitAll()
		.antMatchers("/assets/**","/uploadedImage/**","/uploadedImage/**","/error").permitAll()
		.antMatchers("/images/**").permitAll()
		.antMatchers("/forms/**").permitAll()
		.antMatchers("updateCar/{searchid}","/saveUpdateData","updateUser/{searchid}","/saveUpdateUserData","/profile","/error").hasAnyAuthority("ADMIN","USER")
		.antMatchers("delete/{searchid}","deactivate/{searchid}","assign/{searchid}","reject/{searchid}","approve/{searchid}","/viewallbid","/viewuser","/admin").hasAuthority("ADMIN")
		.antMatchers("/addcar","/mycar" ,"bidAppointment/{searchid}","/mybid/{searchid}").hasAuthority("USER")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.successHandler(roles)
        .loginPage("/login")
        .loginProcessingUrl("/login")
        .failureUrl("/error")
        .permitAll()
        .and()
        .csrf()
        .and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.clearAuthentication(true)
		.invalidateHttpSession(true);
	}
	@Autowired
	AuthenticationProvider authProvider() {
		DaoAuthenticationProvider  dao=new DaoAuthenticationProvider();
		dao.setPasswordEncoder(passwordencoder);
		dao.setUserDetailsService(userservice);
		
		return dao;
	}


}