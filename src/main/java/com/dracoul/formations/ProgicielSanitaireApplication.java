package com.dracoul.formations;


import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.dracoul.formations.service.EmailSenderService;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class ProgicielSanitaireApplication {
	@Autowired
    private EmailSenderService emailSenderService;
	public static void main(String[] args) {
		SpringApplication.run(ProgicielSanitaireApplication.class, args);
	}
	
	/* @EventListener(ApplicationReadyEvent.class)
	    public void triggerMail() throws MessagingException {
	        emailSenderService.sendMailWithAttachment("dramane.coulibalyd636@gmail.com",
	                "This is email body.",
	                "This email subject", "" +
	                        "C:\\MES_COURS\\2.png")
	        ;

	    }*/
	
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration 
		corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Request-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept","Authorization",
				"Access-Control-Allow-Origin","Access-Control-Allow-Origin","Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTION"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
	

}
