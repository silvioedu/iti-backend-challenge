package br.com.itau.password.domain.rules.checker;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.itau.password.domain.rules.IPasswordRules;
import br.com.itau.password.domain.rules.NineOrMoreCharacters;
import br.com.itau.password.domain.rules.NonRepeatingCharacter;
import br.com.itau.password.domain.rules.OneDigit;
import br.com.itau.password.domain.rules.OneLowercaseLetter;
import br.com.itau.password.domain.rules.OneSpecialCharacter;
import br.com.itau.password.domain.rules.OneUppercaseLetter;
import lombok.Getter;

@Getter
public class RulesChecker {

	private static final String MSG_INVALID = "Password %s is invalid: %s";

	private static final Logger logger = LoggerFactory.getLogger(RulesChecker.class);

	private ArrayList<IPasswordRules> rules;

	public RulesChecker() {
		rules = new ArrayList<>();

		rules.add(new NineOrMoreCharacters());
		rules.add(new NonRepeatingCharacter());
		rules.add(new OneDigit());
		rules.add(new OneLowercaseLetter());
		rules.add(new OneUppercaseLetter());
		rules.add(new OneSpecialCharacter());

	}

	public boolean isValid(String password) {
		for (IPasswordRules rule : this.getRules()) {
			if (!rule.check(password)) {
				logger.info(String.format(MSG_INVALID, password, rule.getClass().getSimpleName()));
				return false;
			}
		}
		return true;
	}
}
