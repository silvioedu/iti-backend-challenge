package br.com.itau.password.core.messages;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessagesConfig {

	@Bean
	public ResourceBundleMessageSource messageSource() {

		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasenames("messages.properties");
		source.setUseCodeAsDefaultMessage(true);

		return source;
	}
}
