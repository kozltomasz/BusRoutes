package com.coderilla;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import com.coderilla.BusRouteConfig;
import com.coderilla.service.BusRouteService;

/**
 * Created by tomek on 16.11.16.
 */
public class BusRouteApplication extends Application<BusRouteConfig>
{

    public static void main(String[] args) throws Exception
    {
        new BusRouteApplication().run(args);
    }

    @Override
    public String getName()
    {
        return "BusRoute";
    }

    @Override
    public void run(final BusRouteConfig configuration, final Environment environment)
    {
        BusRouteService service = new BusRouteService( configuration.getFilePath() );
        environment.jersey().register(service);
    }
}
