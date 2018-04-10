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
	String system_cf_index;

	@Value("${HOSTNAME:not_set}")
	String system_hostname;
	
	String getHostName(){

		if(!system_hostname.equals("not_set")) return system_hostname;
		if(!system_cf_index.equals("not_set")) return system_cf_index;
		return "no_host_info";

	}

	@GetMapping("/test")
	String test(){

		System.out.println(System.getProperties());
		System.out.println(System.getenv().toString());
		return system_cf_index + system_hostname + getHostName();

	}

	@GetMapping("/hello")
	String hello(){

		return getHostName()+": Hello, bootiful World! (v1) ";
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
