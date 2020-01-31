package io.RCCFicoScore.client.api;

import io.RCCFicoScore.client.ApiClient;
import io.RCCFicoScore.client.ApiException;
import io.RCCFicoScore.client.model.CatalogoEstados;
import io.RCCFicoScore.client.model.Consultas;
import io.RCCFicoScore.client.model.Creditos;import io.RCCFicoScore.client.model.DomicilioPeticion;
import io.RCCFicoScore.client.model.DomiciliosRespuesta;
import io.RCCFicoScore.client.model.Empleos;
import io.RCCFicoScore.client.model.Mensajes;
import io.RCCFicoScore.client.model.PersonaPeticion;
import io.RCCFicoScore.client.model.Respuesta;
import io.RCCFicoScore.client.model.Scores;
import io.RCCFicoScore.interceptor.SignerInterceptor;
import okhttp3.OkHttpClient;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Before;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class RCCFicoScoreApiTest {
	private final RCCFicoScoreApi api = new RCCFicoScoreApi();
	private Logger logger = LoggerFactory.getLogger(RCCFicoScoreApiTest.class.getName());

	private ApiClient apiClient;
	

	@Before()
	public void setUp() {
		this.apiClient = api.getApiClient();
		this.apiClient.setBasePath("the_url");
		OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
			    .readTimeout(30, TimeUnit.SECONDS)
			    .addInterceptor(new SignerInterceptor())
			    .build();
			apiClient.setHttpClient(okHttpClient);
	}

	@Test
	public void getReporteTest() throws ApiException {
		
		String xApiKey = "your_api_key";
		String username = "your_username";
		String password = "your_password";
		Boolean xFullReport = false;

		PersonaPeticion persona = new PersonaPeticion();
		DomicilioPeticion domicilio = new DomicilioPeticion();
		
		persona.setApellidoPaterno("PATERNO");
		persona.setApellidoMaterno("MATERNO");
		persona.setApellidoAdicional(null);
		persona.setPrimerNombre("PRIMERNOMBRE");
	    persona.setSegundoNombre(null);
	    persona.setFechaNacimiento("1952-05-13");
	    persona.setRFC("PAMP010101");
	    persona.setCURP(null);
	    persona.setNacionalidad(null);
	    persona.setResidencia(null);
	    persona.setEstadoCivil(null);
	    persona.setSexo(null);
	    persona.setClaveElectorIFE(null);
	    persona.setNumeroDependientes(null);
	    persona.setFechaDefuncion(null);
	    persona.setDomicilio(null);
		
	    
		domicilio.setDireccion("HIDALGO 32");
		domicilio.setColoniaPoblacion("CENTRO");
		domicilio.setDelegacionMunicipio("LA BARCA");
		domicilio.setCiudad("BENITO JUAREZ");
		domicilio.setEstado(CatalogoEstados.JAL);
		domicilio.setCP("47917");
		domicilio.setFechaResidencia(null);
		domicilio.setNumeroTelefono(null);
		domicilio.setTipoDomicilio(null);
		domicilio.setTipoAsentamiento(null);
		
		persona.setDomicilio(domicilio);
		
		Respuesta response = api.getReporte(xApiKey, username, password, persona, xFullReport);

		Assert.assertTrue(response.getFolioConsulta() != null);
		
		logger.info(response.toString());

		if (response.getFolioConsulta() != null && !xFullReport ) {
			String folioConsulta = response.getFolioConsulta();

			Consultas consultas2 = api.getConsultas(folioConsulta, xApiKey, username, password);
			Assert.assertTrue(consultas2.getConsultas() != null);

			Creditos creditos = api.getCreditos(folioConsulta, xApiKey, username, password);
			Assert.assertTrue(creditos.getCreditos() != null);

			DomiciliosRespuesta domicilios = api.getDomicilios(folioConsulta, xApiKey, username, password);
			Assert.assertTrue(domicilios.getDomicilios() != null);

			Empleos empleos = api.getEmpleos(folioConsulta, xApiKey, username, password);
			Assert.assertTrue(empleos.getEmpleos() != null);

			Scores scores = api.getScores(folioConsulta, xApiKey, username, password);
			Assert.assertTrue(scores.getScores() != null);
			
			Mensajes mensajes = api.getMensajes(folioConsulta, xApiKey, username, password);
			Assert.assertTrue(mensajes.getMensajes() != null);
		}

	}
        
}