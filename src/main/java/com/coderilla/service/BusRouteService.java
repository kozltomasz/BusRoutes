package com.coderilla.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;


/**
 * Created by tomek on 16.11.16.
 */
@Path("/api/direct")
@Produces(MediaType.APPLICATION_JSON)
public class BusRouteService
{
    ArrayList<HashSet<Integer>> aRoutes;

    public BusRouteService(String filePath)
    {
        aRoutes = new ArrayList<HashSet<Integer>>();

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
            String line = null;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null)
            {
                // ignore number of lines
                if( isFirstLine )
                {
                    isFirstLine = false;
                    continue;
                }
                String[] aValues = line.split(" ");
                if(aValues.length > 2)
                {
                    HashSet<Integer> aIntegers = new HashSet<Integer>();
                    boolean isFirstElement = true;
                    // omit first value (route id)
                    for (String strVal : aValues)
                    {
                        if( !isFirstElement )
                        {
                            aIntegers.add(Integer.valueOf(strVal));
                        }
                        isFirstElement = false;
                    }
                    aRoutes.add(aIntegers);
                }
            }
            br.close();
        }
        catch (java.io.IOException e)
        {
            throw new RuntimeException(e);
        }

    }

    @GET
    public BusRouteResponse hasDirectBusRoute(@QueryParam("dep_sid") Integer depSId, @QueryParam("arr_sid") Integer arrSId)
    {
        for (HashSet<Integer> a: aRoutes)
        {
            if ( a.contains(depSId) && a.contains(arrSId) )
            {
                return new BusRouteResponse(depSId, arrSId, true);
            }
        }
        return new BusRouteResponse(depSId, arrSId, false);
    }
}
