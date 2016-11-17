package com.coderilla.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

/**
 * Created by tomek on 16.11.16.
 */
public class BusRouteResponse
{
    @NotNull
    private Integer depSId;

    @NotNull
    private Integer arrSId;

    @NotNull
    private Boolean directBusRoute;

    public BusRouteResponse(Integer depSId, Integer arrSId, Boolean directBusRoute) {
        this.depSId = depSId;
        this.arrSId = arrSId;
        this.directBusRoute = directBusRoute;
    }


    @JsonProperty("dep_sid")
    public Integer getDepSId() {
        return depSId;
    }

    @JsonProperty("arr_sid")
    public Integer getArrSId() {
        return arrSId;
    }

    @JsonProperty("direct_bus_route")
    public Boolean getDirectBusRoute() {
        return directBusRoute;
    }
}
