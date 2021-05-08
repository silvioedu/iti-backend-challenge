package br.com.itau.password.domain.rules;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OneSpecialCharacterTest {

	private IPasswordRules rule = new OneSpecialCharacter();

	@Test
	void mustReturnTrue_passwordHasSpecialOneSCharacter() {
		assertThat(rule.check("!")).isTrue();
	}

	@Test
	void mustReturnTrue_passwordHasSpecialTwoCharacter() {
		assertThat(rule.check("@")).isTrue();
	}

	@Test
	void mustReturnTrue_passwordHasSpecialThreeCharacter() {
		assertThat(rule.check("#")).isTrue();
	}

	@Test
	void mustReturnTrue_passwordHasSpecialFourCharacter() {
		assertThat(rule.check("$")).isTrue();
	}

	@Test
	void mustReturnTrue_passwordHasSpecialFiveCharacter() {
		assertThat(rule.check("^")).isTrue();
	}

	@Test
	void mustReturnTrue_passwordHasSpecialSixCharacter() {
		assertThat(rule.check("&")).isTrue();
	}

	@Test
	void mustReturnTrue_passwordHasSpecialSevenCharacter() {
		assertThat(rule.check("*")).isTrue();
	}

	@Test
	void mustReturnTrue_passwordHasSpecialEightCharacter() {
		assertThat(rule.check("(")).isTrue();
	}

	@Test
	public void mustReturnTrue_passwordHasSpecialNineCharacter() {
		assertThat(rule.check(")")).isTrue();
	}

	@Test
	void mustReturnTrue_passwordHasSpecialTenCharacter() {
		assertThat(rule.check("-")).isTrue();
	}

	@Test
	void mustReturnTrue_passwordHasSpecialElevenCharacter() {
		assertThat(rule.check("+")).isTrue();
	}

	@Test
	void mustReturnFalse_passwordHasSpecialTwelveCharacter() {
		assertThat(rule.check("'")).isFalse();
	}

	@Test
	void mustReturnFalse_passwordHasSpecialThirteenCharacter() {
		assertThat(rule.check(",")).isFalse();
	}

	@Test
	void mustReturnFalse_passwordHasSpecialFourteenCharacter() {
		assertThat(rule.check(".")).isFalse();
	}

	@Test
	void mustReturnFalse_passwordHasSpecialFifteenCharacter() {
		assertThat(rule.check("/")).isFalse();
	}

	@Test
	void mustReturnFalse_passwordHasSpecialSixteenCharacter() {
		assertThat(rule.check(":")).isFalse();
	}

	@Test
	void mustReturnFalse_passwordHasSpecialSeventeenCharacter() {
		assertThat(rule.check(";")).isFalse();
	}

	@Test
	void mustReturnFalse_passwordHasSpecialEighteenCharacter() {
		assertThat(rule.check("<")).isFalse();
	}

	@Test
	void mustReturnFalse_passwordHasSpecialNineteenCharacter() {
		assertThat(rule.check("=")).isFalse();
	}

	@Test
	void mustReturnFalse_passwordHasSpecialTwentyCharacter() {
		assertThat(rule.check(">")).isFalse();
	}

	@Test
	void mustReturnFalse_passwordHasSpecialTwentyOneCharacter() {
		assertThat(rule.check("_")).isFalse();
	}

	@Test
	void mustReturnFalse_passwordHasSpecialTwentyTwoCharacter() {
		assertThat(rule.check("{")).isFalse();
	}

	@Test
	void mustReturnFalse_passwordHasSpecialTwentyThreeCharacter() {
		assertThat(rule.check("}")).isFalse();
	}

	@Test
	void mustReturnFalse_passwordHasSpecialTwentyFourCharacter() {
		assertThat(rule.check("|")).isFalse();
	}

	@Test
	void mustReturnFalse_passwordHasSpecialTwentyFiveCharacter() {
		assertThat(rule.check("`")).isFalse();
	}

	@Test
	void mustReturnFalse_passwordHasSpecialTwentySixCharacter() {
		assertThat(rule.check("[")).isFalse();
	}

	@Test
	void mustReturnFalse_passwordHasSpecialTwentySevenCharacter() {
		assertThat(rule.check("]")).isFalse();
	}

	@Test
	void mustReturnFalse_passwordHasSpaceCharacter() {
		assertThat(rule.check(" ")).isFalse();
	}

}
