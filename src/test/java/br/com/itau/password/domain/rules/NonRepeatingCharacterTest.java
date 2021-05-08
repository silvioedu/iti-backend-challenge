package br.com.itau.password.domain.rules;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NonRepeatingCharacterTest {

	private IPasswordRules rule = new NonRepeatingCharacter();
	
	@Test
	void mustReturnTrue_passwordHasNonRepeatingCharacters() {
		assertThat(rule.check("abc")).isTrue();
	}

	@Test
	void mustReturnFalse_passwordHasRepeatingCharacters() {
		assertThat(rule.check("abca")).isFalse();
	}

}
