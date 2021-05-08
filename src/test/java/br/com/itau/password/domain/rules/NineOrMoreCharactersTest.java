package br.com.itau.password.domain.rules;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NineOrMoreCharactersTest {

	private IPasswordRules rule = new NineOrMoreCharacters();
	
	@Test
	void mustReturnTrue_passwordHasNineCharacters() {
		assertThat(rule.check("abcdefghi")).isTrue();
	}

	@Test
	void mustReturnTrue_passwordHasTenCharacters() {
		assertThat(rule.check("1234567890")).isTrue();
	}

	@Test
	void mustReturnFalse_passwordHasFiveCharacters() {
		assertThat(rule.check("abcde")).isFalse();
	}

}
