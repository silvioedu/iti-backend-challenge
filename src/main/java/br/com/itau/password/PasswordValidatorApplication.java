package br.com.itau.password;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PasswordValidatorApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

		SpringApplication.run(PasswordValidatorApplication.class, args);
	}

}
