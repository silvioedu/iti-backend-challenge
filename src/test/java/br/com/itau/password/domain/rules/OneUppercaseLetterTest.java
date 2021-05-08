package br.com.itau.password.domain.rules;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OneUppercaseLetterTest {

	private IPasswordRules rule = new OneUppercaseLetter();
	
	@Test
	public void mustReturnTrue_passwordHasOneUppercaseLetter() {
		assertThat(rule.check("A")).isTrue();
	}

	@Test
	public void mustReturnFalse_passwordHasNoLowercaseLetter() {
		assertThat(rule.check("asbh123")).isFalse();
	}

}
