package br.com.itau.password.api.model.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import br.com.itau.password.api.exceptionhandler.ProblemTypeEnum;
import br.com.itau.password.util.ResourceUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
class PasswordValidatorControllerIT {

	private static final String JSON_PATH = "/json/password";

	@LocalServerPort
	private int port;

	private String JSON_PARAMETER;
	private String JSON_VALID;
	private String JSON_BLANK;
	private String JSON_INCORRECT_LENGTH;
	private String JSON_REPEATED_UPPERCASE;
	private String JSON_REPEATED_LOWERCASE;
	private String JSON_SPACE;
	private String JSON_INCOMPREHENSIBLE;

	
	@BeforeAll
	void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/v1/passwords";
		
		loadJson();
	}

	private void loadJson() {
		JSON_PARAMETER = ResourceUtils.getContentFromResource(JSON_PATH + "/parameter.json");
		JSON_VALID = ResourceUtils.getContentFromResource(JSON_PATH + "/valid.json");
		JSON_BLANK = ResourceUtils.getContentFromResource(JSON_PATH + "/blank.json");
		JSON_INCORRECT_LENGTH = ResourceUtils.getContentFromResource(JSON_PATH + "/incorrect-length.json");
		JSON_REPEATED_UPPERCASE = ResourceUtils.getContentFromResource(JSON_PATH + "/repeated-uppercase.json");
		JSON_REPEATED_LOWERCASE = ResourceUtils.getContentFromResource(JSON_PATH + "/repeated-lowercase.json");
		JSON_SPACE = ResourceUtils.getContentFromResource(JSON_PATH + "/space.json");
		JSON_INCOMPREHENSIBLE = ResourceUtils.getContentFromResource(JSON_PATH + "/incomprehensible.json");
	}

	@Test
	void mustReturnStatus400_whenNotSendParameter() {

		RestAssured
			.given()
		        .contentType(ContentType.JSON)
				.accept(ContentType.JSON)
			.when()
				.post()
			.then()
				.statusCode(HttpStatus.BAD_REQUEST.value());

	}

	@Test
	void mustReturnStatus200_whenSendParameter() {

		RestAssured
			.given()
				.body(JSON_PARAMETER)
		        .contentType(ContentType.JSON)
				.accept(ContentType.JSON)
			.when()
				.post()
			.then()
				.statusCode(HttpStatus.OK.value());

	}

	@Test
	void mustReturnStatus200AndTrue_whenSendAValidPassword() {

		RestAssured
			.given()
				.body(JSON_VALID)
		        .contentType(ContentType.JSON)
				.accept(ContentType.JSON)
			.when()
				.post()
			.then()
				.statusCode(HttpStatus.OK.value())
				.body(containsString("true"));

	}

	@Test
	void mustReturnStatus200AndFalse_whenSendABlankParameter() {

		RestAssured
			.given()
				.body(JSON_BLANK)
		        .contentType(ContentType.JSON)
				.accept(ContentType.JSON)
			.when()
				.post()
			.then()
				.statusCode(HttpStatus.OK.value())
				.body(containsString("false"));

	}
	
	@Test
	void mustReturnStatus200AndFalse_whenSendIncorrectLengthParameter() {

		RestAssured
			.given()
				.body(JSON_INCORRECT_LENGTH)
		        .contentType(ContentType.JSON)
				.accept(ContentType.JSON)
			.when()
				.post()
			.then()
				.statusCode(HttpStatus.OK.value())
				.body(containsString("false"));

	}

	@Test
	void mustReturnStatus200AndFalse_whenSendRepeatedUppercaseCharacters() {

		RestAssured
			.given()
				.body(JSON_REPEATED_UPPERCASE)
		        .contentType(ContentType.JSON)
				.accept(ContentType.JSON)
			.when()
				.post()
			.then()
				.statusCode(HttpStatus.OK.value())
				.body(containsString("false"));

	}

	@Test
	void mustReturnStatus200AndFalse_whenSendRepeatedLowercaseCharacters() {

		RestAssured
			.given()
				.body(JSON_REPEATED_LOWERCASE)
		        .contentType(ContentType.JSON)
				.accept(ContentType.JSON)
			.when()
				.post()
			.then()
				.statusCode(HttpStatus.OK.value())
				.body(containsString("false"));

	}
	
	@Test
	void mustReturnStatus200AndFalse_whenSendSpaceCharacter() {

		RestAssured
			.given()
				.body(JSON_SPACE)
		        .contentType(ContentType.JSON)
				.accept(ContentType.JSON)
			.when()
				.post()
			.then()
				.statusCode(HttpStatus.OK.value())
				.body(containsString("false"));

	}

	@Test
	void mustReturnStatus400_whenSendIncomprehensibleMessage() {

		RestAssured
			.given()
				.body(JSON_INCOMPREHENSIBLE)
		        .contentType(ContentType.JSON)
				.accept(ContentType.JSON)
			.when()
				.post()
			.then()
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.body("status",equalTo(400))
				.body("timestamp", notNullValue())
				.body("title", equalTo(ProblemTypeEnum.INCOMPREHENSIBLE_MSG.getTitle()))
				.body("detail", notNullValue());

	}

}
