package com.webclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.webclient.service.MMTServiceimpl;

@SpringBootApplication
public class MakeMyTripWebClientApplication {

	public static void main(String[] args) {
		 ConfigurableApplicationContext context = SpringApplication.run(MakeMyTripWebClientApplication.class, args);
		 MMTServiceimpl bean = context.getBean(MMTServiceimpl.class);
	}

}
