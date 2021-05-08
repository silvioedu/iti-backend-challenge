package br.com.itau.password.domain.rules;

import br.com.itau.password.domain.enumeration.SpecialCharacterEnum;

public class OneSpecialCharacter implements IPasswordRules {

	@Override
	public boolean check(String password) {
		final String initialExpression = "^(.*[";
		final String finalExpression = "]).*$";
		
	    if (password.matches(initialExpression + SpecialCharacterEnum.ALLOWED.getCharacters() + finalExpression) &&
	    	!(password.matches(initialExpression + SpecialCharacterEnum.NOT_ALLOWED.getCharacters() + finalExpression)) &&
	    	!(password.matches(initialExpression + SpecialCharacterEnum.SPACE.getCharacters() + finalExpression))) {
	    	return true;
	    }
    	return false;
	}
	
}
