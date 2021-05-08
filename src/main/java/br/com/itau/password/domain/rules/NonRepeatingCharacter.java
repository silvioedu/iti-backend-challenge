package br.com.itau.password.domain.rules;

public class NonRepeatingCharacter implements IPasswordRules {

	@Override
	public boolean check(String password) {
        return !password.matches("^.*(.).*\\1.*$");
	}

}
