package br.com.itau.password.domain.rules;

public class OneLowercaseLetter implements IPasswordRules {

	@Override
	public boolean check(String password) {
        return password.matches("^(.*[a-z]).*$");
	}

}
