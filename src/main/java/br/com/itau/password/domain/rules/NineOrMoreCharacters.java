package br.com.itau.password.domain.rules;

public class NineOrMoreCharacters implements IPasswordRules {

	@Override
	public boolean check(String password) {
        return password.matches("^.{9,}.*$");
	}

}
