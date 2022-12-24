package com.dracoul.formations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dracoul.formations.repo.EmailService;

@RestController
@RequestMapping("/email")
public class EmailRessource {

	@Autowired
	private EmailService emailService;
	
	@PostMapping("/sendMail")
	public ResponseEntity<String> sendMail(@RequestBody EmailDetails details){
		String status = emailService.sendSimpleMail(details);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}
	
	@PostMapping("/sendMailWithAttachment")
	public ResponseEntity<String> sendMailWithAttachment(@RequestBody EmailDetails details){
		String status = emailService.sendMailWithAttachment(details);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}
}
