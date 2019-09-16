package cursoRestAssured;

import org.junit.Assert;
import org.junit.Test;

//import groovy.json.JsonParser;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserJsonTest {

	@Test
	public void deveVerificarPrimeiroNivel() {
		given()
		.when()
			.get("http://restapi.wcaquino.me/users/1")
		.then()
			.statusCode(200)
			.body("id", is(1))
			.body("name", containsString("Silva"))
			.body("age", greaterThan(18));
	}
	
	@Test
	public void deveVerificarPrimeiroNivelOutrasFormas() {
		Response response = RestAssured.request(Method.GET, "http://restapi.wcaquino.me/users/1");
		System.out.println(response.path("id").toString());
		Assert.assertEquals(new Integer(1), response.path("%s", "id"));
		
//		JsonPath jpath = new JsonPath(response.toString());
//		Assert.assertEquals(1, jpath.getInt("id"));
		
		int id = JsonPath.from(response.asString()).getInt("id");
	}
	
	@Test
	public void deveVerificarSegundoNivel() {
		given()
		.when()
			.get("http://restapi.wcaquino.me/users/2")
		.then()
			.statusCode(200)
			.body("endereco.rua", is("Rua dos bobos"))
			.body("age", greaterThan(18));
	}
}
