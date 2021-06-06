package com.dant.exception.mapper;

/* static imports */
import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

/* specific imports */
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * RuntimeExceptionMapper
 */
@Provider
public class RuntimeExceptionMapper
		implements ExceptionMapper<RuntimeException> {

	/**
	 * @param e RuntimeException
	 * @return Response
	 */
	@Override
	public Response toResponse(RuntimeException e) {
		return Response.status(INTERNAL_SERVER_ERROR).entity(e.getMessage()).type("plain/text").build();
	}
}
