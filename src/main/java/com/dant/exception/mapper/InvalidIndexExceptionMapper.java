package com.dant.exception.mapper;

import com.dant.exception.InvalidIndexException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

public class InvalidIndexExceptionMapper
        implements ExceptionMapper<InvalidIndexException> {

    @Override
    public Response toResponse(InvalidIndexException e) {
        return Response.status(INTERNAL_SERVER_ERROR).entity(e.getMessage()).type("plain/text").build();
    }
}