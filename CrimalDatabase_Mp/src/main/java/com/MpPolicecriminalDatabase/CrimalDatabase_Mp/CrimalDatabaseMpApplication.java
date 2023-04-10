package com.MpPolicecriminalDatabase.CrimalDatabase_Mp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.MpPolicecriminalDatabase.CrimalDatabase_Mp.configuration.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties (AppProperties.class)
public class CrimalDatabaseMpApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrimalDatabaseMpApplication.class, args);
	}

}
