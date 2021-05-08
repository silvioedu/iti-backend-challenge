package br.com.itau.password.domain.enumeration;

public enum SpecialCharacterEnum {

    ALLOWED("!@#$^&*()\\-+"),
    NOT_ALLOWED("',./:;<=>_{}|`\\[]"),
    SPACE("\\h");

    private String characters;

    private SpecialCharacterEnum(String characters) {
		this.characters = characters;
	}
    
	public String getCharacters() {
		return this.characters;
	}

}
