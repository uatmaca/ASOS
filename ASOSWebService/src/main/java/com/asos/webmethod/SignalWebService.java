package com.asos.webmethod;


import com.asos.database.JDBCUtil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created by Umut on 22.4.2016.
 */
@Path("/signalWebService")
public class SignalWebService {


    @GET
    @Path("/{greenHouseId}")
    public Response getMsg(@PathParam("greenHouseId") String greenHouseId) {

        JDBCUtil jdbc = new JDBCUtil();

        String output = jdbc.getLastSignalGreenHouse(Long.parseLong(greenHouseId));

        return Response.status(200).entity(output).build();

    }

}
