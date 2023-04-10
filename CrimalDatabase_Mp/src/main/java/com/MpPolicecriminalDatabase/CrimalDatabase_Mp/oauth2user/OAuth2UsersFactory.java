package com.MpPolicecriminalDatabase.CrimalDatabase_Mp.oauth2user;

import java.util.Map;

import com.MpPolicecriminalDatabase.CrimalDatabase_Mp.dao.AuthProvider;
import com.MpPolicecriminalDatabase.CrimalDatabase_Mp.exception.OAuthAuthenticationException;
import com.educlaas.sociallogin.oauth2users.OAuth2Users;

import java.util.Map;

public class OAuth2UsersFactory{
	public static com.MpPolicecriminalDatabase.CrimalDatabase_Mp.oauth2user.OAuth2Users getInstance(String registerId, Map<String, Object> attributes) throws OAuthAuthenticationException {
		if(registerId.equalsIgnoreCase(AuthProvider.google.toString())) {
			return new GoogleOAuthUsers(attributes);
		}
		else if(registerId.equalsIgnoreCase(AuthProvider.facebook.toString())) {
			return new FacebookOAuthUsers(attributes);
		}
		else {
			throw new OAuthAuthenticationException("Login with" + registerId + "is not supported yet!!!");
		}
	}
}