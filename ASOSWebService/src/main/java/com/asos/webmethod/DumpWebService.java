package com.asos.webmethod;

import com.asos.database.JDBCUtil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created by Umut on 22.4.2016.
 */
@Path("/dumpWebService")
public class DumpWebService {

    @GET
    @Path("/{greenHouseId}/{dumpInfo}")
    public Response getMsg(@PathParam("greenHouseId") String greenHouseId, @PathParam("dumpInfo") String dumpInfo) {

        JDBCUtil jdbc = new JDBCUtil();

        jdbc.setGreenHouseDump(greenHouseId, dumpInfo);

        return Response.status(200).build();

    }
}
