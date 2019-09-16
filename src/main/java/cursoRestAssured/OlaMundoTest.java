package cursoRestAssured;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class OlaMundoTest {

	@Test
	public void testeOlaMundo() {
		Response response = request(Method.GET, "http://restapi.wcaquino.me/ola");
		Assert.assertTrue(response.getBody().asString().equals("Ola Mundo!"));
		Assert.assertTrue(response.statusCode() == 200);
		Assert.assertTrue("Status code deveria ser 201", response.statusCode() == 200);
		Assert.assertEquals(200, response.statusCode());
//		throw new RuntimeException();
		ValidatableResponse validacao = response.then();
		validacao.statusCode(200);
	}
	
	@Test
	public void devoConhecerOutrasFormasRestAssured() {
//		Response response = request(Method.GET, "http://restapi.wcaquino.me/ola");
//		ValidatableResponse validacao = response.then();
//		validacao.statusCode(200);
//		
//		get("http://restapi.wcaquino.me/ola")
//		.then().statusCode(200);
//		
		given()
		.when()
			.get("http://restapi.wcaquino.me/ola")
		.then()
			.statusCode(201);
	}
	
	// Utilizano o pacote hancrest
	@Test
	public void devoConhcerOsMetchers() {
		assertThat("Maria", Matchers.is("Maria"));		//verifica igualdade
		assertThat(128, Matchers.is(128));				//verifica igualdade
		assertThat(128, Matchers.isA(Integer.class));	//verifica o tipo
		assertThat(128d, Matchers.isA(Double.class));	//verifica o tipo
		assertThat(128d, Matchers.greaterThan(120d));	//verifica se é maior
		assertThat(128d, Matchers.lessThan(130d));		//verifica se é menor	
		
		List<Integer> impares = Arrays.asList(1, 3, 5, 7);
		assertThat(impares, hasSize(4));
		assertThat(impares, contains(1, 3, 5, 7));
		assertThat(impares, containsInAnyOrder(1, 3, 7, 5));
		assertThat(impares, hasItem(1));
		assertThat(impares, hasItems(1, 5));
		
		assertThat("Maria", is(not("João")));
		assertThat("Maria", not("João"));
		assertThat("Maria", anyOf(is("Maria"), is("Joaquina")));
		assertThat("Joaquina", allOf(startsWith("Joa"), endsWith("ina"), containsString("qui")));
	}
	
	@Test
	public void devoValidarOBody() {
		
		given()
		.when()
			.get("http://restapi.wcaquino.me/ola")
		.then()
			.statusCode(200)
			.body(containsString("Mundo"))
			.body(is(not(nullValue())));
	}
}
