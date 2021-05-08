package br.com.itau.password.domain.rules;

public class OneUppercaseLetter implements IPasswordRules {

	@Override
	public boolean check(String password) {
        return password.matches("^(.*[A-Z]).*$");
	}

}
