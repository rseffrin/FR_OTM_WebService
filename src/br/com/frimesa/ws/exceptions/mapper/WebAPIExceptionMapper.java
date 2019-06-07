package br.com.frimesa.ws.exceptions.mapper;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.frimesa.ws.model.ErrorMessage;


/*exce��o pai de todas as exce��es lan�adas pelo Jersey. Assim, 
 * as exce��es que n�o forem tratadas pelo c�digo ser�o tratadas por esse mapper 
 * e uma mensagem mais amig�vel ser� retornada para quem estiver consumindo o servi�o. 
 * Exemplo, URL errado, vai tratar o exception 404
 */


@Provider
public class WebAPIExceptionMapper implements ExceptionMapper<WebApplicationException> {

	@Override
	public Response toResponse(WebApplicationException ex) {
		System.out.println("Chamou a WebAPIExceptionMapper");
		ErrorMessage error = new ErrorMessage(ex.getMessage(), ex.getResponse().getStatus());
		return Response.status(ex.getResponse().getStatus())
				.entity(error)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}