package de.maeddes.SimpleWeb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SimpleWebApplication {

	@Value("${CF_INSTANCE_GUID:not_set}")
	String cfInstance;

	@Value("${HOSTNAME:not_set}")
	String hostname;

	@Value("${spring.profiles.active: none}")
	String profile;

	private String getInstanceId(){

		if(!hostname.equals("not_set")) return hostname;
		if(!cfInstance.equals("not_set")) return cfInstance;
		return "probably localhost";

	}

	@GetMapping("/hello")
	String hello(){

		return getInstanceId()+" Hallo, Welt ! ";

	}

	@GetMapping("/fail")
	String fail() {

		System.exit(1);
		return "fixed!";
	}

	public static void main(String[] args) {
		SpringApplication.run(SimpleWebApplication.class, args);
	}
}
