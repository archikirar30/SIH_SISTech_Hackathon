package com.mp_police.MpPoliceCriminalDatabase;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mp_police.MpPoliceCriminalDatabase.Controller.CarController;
import com.mp_police.MpPoliceCriminalDatabase.Controller.CriminalController;

@SpringBootApplication
public class MpPoliceCriminalDatabaseApplication {

	public static void main(String[] args) {
		
		new File(CriminalController.uploadDirectory).mkdir();
		SpringApplication.run(MpPoliceCriminalDatabaseApplication.class, args);
	}

}
