package br.com.frimesa.ws.exceptions.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.frimesa.ws.domain.TransmissionAck;
import br.com.frimesa.ws.exceptions.DAOException;
import br.com.frimesa.ws.exceptions.ErrorCode;
import br.com.frimesa.ws.model.ErrorMessage;
import br.com.frimesa.ws.util.Util;



@Provider
public class DAOExceptionMapper implements ExceptionMapper<DAOException> {

	@Override
	public Response toResponse(DAOException exception) {
		System.out.println("DAOExceptionMapper(-)");
		
		TransmissionAck t = Util.montaRetorno(Util.ERROR,exception.getMessage());

		//ErrorMessage error = new ErrorMessage(exception.getMessage(), exception.getCode());
		if (exception.getCode() == ErrorCode.BAD_REQUEST.getCode()) {
			return Response.status(Status.OK)				
					.entity(t)
					.type(MediaType.APPLICATION_XML)
					.build();
		} else if (exception.getCode() == ErrorCode.NOT_FOUND.getCode()) {
			return Response.status(Status.OK)				
					.entity(t)
					.type(MediaType.APPLICATION_XML)
					.build();
		} else if (exception.getCode() == ErrorCode.CONFLICT.getCode()) {
			return Response.status(Status.OK)
					.entity(t)
					.type(MediaType.APPLICATION_XML)
					.build();
		}else if (exception.getCode() == ErrorCode.UNAUTHORIZED.getCode()) {
				return Response.status(Status.OK)
						.entity(t)
						.type(MediaType.APPLICATION_XML)
						.build();
		}else if (exception.getCode() == ErrorCode.FORBIDDEN.getCode()) {
			return Response.status(Status.OK)
					.entity(t)
					.type(MediaType.APPLICATION_XML)
					.build();
		} else {
			return Response.status(Status.OK)				
					.entity(t)
					.type(MediaType.APPLICATION_XML)
					.build();
		}
	}
}