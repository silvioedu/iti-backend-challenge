package br.com.itau.password.domain.rules;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OneDigitTest {

	private IPasswordRules rule = new OneDigit();
	
	@Test
	void mustReturnTrue_passwordHasOneDigit() {
		assertThat(rule.check("abc1")).isTrue();
	}

	@Test
	void mustReturnTrue_passwordHasFourDigits() {
		assertThat(rule.check("4a4b6c1")).isTrue();
	}

	@Test
	void mustReturnFalse_passwordHasNoDigits() {
		assertThat(rule.check("abcdef")).isFalse();
	}

}
