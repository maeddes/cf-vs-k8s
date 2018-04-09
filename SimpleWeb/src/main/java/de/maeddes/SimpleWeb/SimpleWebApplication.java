package de.maeddes.SimpleWeb;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SimpleWebApplication {
	
	@Value("${HOSTNAME:null}")
	String hostname;

	@GetMapping("/hello")
	String hello(){

		return hostname+": Hello, bootiful World! (v1) ";
	}

	@GetMapping("/fail")
	String fail() {

		System.exit(0);
		return "fixed!";
	}

	public static void main(String[] args) {
		SpringApplication.run(SimpleWebApplication.class, args);
	}
}
