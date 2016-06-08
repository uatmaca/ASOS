package com.mkyong.rest;

import com.asos.database.JDBCUtil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created by Umut on 14.4.2016.
 */

@Path("/hello")
public class Hello {

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String greenHouseId) {

        JDBCUtil jdbc = new JDBCUtil();

        String output = jdbc.getLastSignalGreenHouse(1L);

        return Response.status(200).entity(output).build();

    }
}
