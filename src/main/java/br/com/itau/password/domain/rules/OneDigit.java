package br.com.itau.password.domain.rules;

public class OneDigit implements IPasswordRules {

	@Override
	public boolean check(String password) {
        return password.matches("^(.*\\d).*$");
	}

}
