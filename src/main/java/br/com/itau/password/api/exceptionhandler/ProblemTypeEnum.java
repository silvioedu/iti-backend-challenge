package br.com.itau.password.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemTypeEnum {

	INCOMPREHENSIBLE_MSG("Incomprehensible message");
	
	private String title;
	
	private ProblemTypeEnum(String title) {
		this.title = title;
	}
}
