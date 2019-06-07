package br.com.frimesa.ws.exceptions.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.frimesa.ws.exceptions.ErrorCode;
import br.com.frimesa.ws.model.ErrorMessage;


@Provider
public class WebIllegalStateExceptionMapper implements ExceptionMapper<IllegalStateException> {

	@Override
	public Response toResponse(IllegalStateException ex) {
		// TODO Auto-generated method stub
		ErrorMessage error = new ErrorMessage(ex.getMessage().toString(), ErrorCode.SERVER_ERROR.getCode());
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(error)
				.type(MediaType.APPLICATION_JSON)
				.build();

	}     

}
