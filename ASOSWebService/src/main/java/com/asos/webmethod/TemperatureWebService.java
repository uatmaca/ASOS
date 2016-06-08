package com.asos.webmethod;

import com.asos.database.JDBCUtil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created by Umut on 22.4.2016.
 */

@Path("/temperatureWebService")
public class TemperatureWebService {


    @GET
    @Path("/{greenHouseId}/{temperatureInfo}")
    public Response getMsg(@PathParam("greenHouseId") String greenHouseId, @PathParam("temperatureInfo") String temperatureInfo) {

        JDBCUtil jdbc = new JDBCUtil();

        jdbc.setGreenHouseTemperature(greenHouseId, temperatureInfo);

        return Response.status(200).build();

    }

}
