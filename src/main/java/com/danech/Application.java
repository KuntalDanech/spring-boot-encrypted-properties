package com.danech;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;

@SpringBootApplication
@RestController
@EncryptablePropertySource(value = "application.yml")
public class Application {

	// Password will be decrypted at runtime.
	@Value("${app.myname}")
	private String value;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@GetMapping("welcome")
	public String welcome() {
		// We will get actual properties in runtime
		return value;
	}

}