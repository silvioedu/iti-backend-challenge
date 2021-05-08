package br.com.itau.password.domain.rules;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OneLowercaseLetterTest {

	private IPasswordRules rule = new OneLowercaseLetter();
	
	@Test
	public void mustReturnTrue_passwordHasOneLowercaseLetter() {
		assertThat(rule.check("a")).isTrue();
	}

	@Test
	public void mustReturnFalse_passwordHasNoLowercaseLetter() {
		assertThat(rule.check("ASBH123")).isFalse();
	}

}
