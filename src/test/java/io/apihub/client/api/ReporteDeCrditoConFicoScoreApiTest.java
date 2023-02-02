
package io.apihub.client.api;

import io.apihub.client.ApiClient;
import io.apihub.client.ApiException;
import io.apihub.client.model.CatalogoEstados;
import io.apihub.client.model.Consultas;
import io.apihub.client.model.Creditos;
import io.apihub.client.model.Domicilio;
import io.apihub.client.model.Domicilios;
import io.apihub.client.model.Empleos;
import io.apihub.client.model.PersonaPeticion;
import io.apihub.client.model.Respuesta;
import io.apihub.client.model.Scores;
import io.apihub.interceptor.SignerInterceptor;
import okhttp3.OkHttpClient;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class ReporteDeCrditoConFicoScoreApiTest {
	private final ReporteDeCrditoConFicoScoreApi api = new ReporteDeCrditoConFicoScoreApi();
	private ApiClient apiClient;

	@Before()
	public void setUp() {
		this.apiClient = api.getApiClient();

		OkHttpClient okHttpClient = new OkHttpClient().newBuilder().readTimeout(30, TimeUnit.SECONDS)
				.addInterceptor(new SignerInterceptor()).build();
		apiClient.setHttpClient(okHttpClient);
	}

	@Test
	public void getReporteTest() throws ApiException {
		String xApiKey = "XXXXXXXXXXXXXXXXXXX";
		String username = "XXXXXXXXX";
		String password = "XXXXXXXXX";

		PersonaPeticion body = new PersonaPeticion();
		body.setPrimerNombre("XXXXXXXXX");
		body.setApellidoPaterno("XXXXXXXXX");
		body.setApellidoMaterno("XXXXXXXXX");
		body.setFechaNacimiento("YYYY-MM-DD");
		body.setRfc("XXXXXXXXX");
		Domicilio dom = new Domicilio();
		dom.setDireccion("XXXXXXXXXXX");
		dom.setColonia("XXXXXXXXX");
		dom.setMunicipio("XXXXXXXXX");
		dom.setCiudad("XXXXXXXXX");
		dom.setEstado(CatalogoEstados.GTO);
		dom.setCodigoPostal("XXXXXX");

		body.setDomicilio(dom);

		Respuesta response = api.getReporte(xApiKey, username, password, body);

		Assert.assertTrue(response.getFolioConsulta() != null);


	}
}
