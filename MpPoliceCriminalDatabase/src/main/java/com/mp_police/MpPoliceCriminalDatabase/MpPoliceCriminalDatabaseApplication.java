package com.mp_police.MpPoliceCriminalDatabase;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mp_police.MpPoliceCriminalDatabase.Controller.CarController;

@SpringBootApplication
public class MpPoliceCriminalDatabaseApplication {

	public static void main(String[] args) {
		
		new File(CarController.uploadDirectory).mkdir();
		SpringApplication.run(MpPoliceCriminalDatabaseApplication.class, args);
	}

}
