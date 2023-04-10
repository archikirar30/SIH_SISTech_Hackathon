package com.MpPolicecriminalDatabase.CrimalDatabase_Mp.configuration;

import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

@Target(PARAMETER)

@Documented
@AuthenticationPrincipal
public @interface CurrentUser {

}
