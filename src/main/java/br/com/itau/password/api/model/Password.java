package br.com.itau.password.api.model;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Password {

	@NotNull
	private String password;
}
