package br.com.itau.password.domain.service;

import org.springframework.stereotype.Service;

import br.com.itau.password.domain.rules.checker.RulesChecker;

@Service
public class PasswordValidatorService {

	public boolean isValid(String password) {
		return new RulesChecker().isValid(password);
	}

}
