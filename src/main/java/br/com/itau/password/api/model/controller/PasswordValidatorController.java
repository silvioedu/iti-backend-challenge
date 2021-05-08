package br.com.itau.password.api.model.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.password.api.model.Password;
import br.com.itau.password.domain.service.PasswordValidatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
	
@RestController
@RequestMapping("/v1/passwords")
@Tag(name = "password", description = "the password to check if is valid")
public class PasswordValidatorController {

	@Autowired
	private PasswordValidatorService service;

    @Operation(summary = "Check if password is valid", description = "Check if password is valid")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200"),
        @ApiResponse(responseCode = "400")
    })	
	@PostMapping(produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public boolean checkValidity(@Valid @RequestBody Password password) {
		return service.isValid(password.getPassword());
	}
}
