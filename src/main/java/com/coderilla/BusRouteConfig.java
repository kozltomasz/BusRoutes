package com.coderilla;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by tomek on 16.11.16.
 */
public class BusRouteConfig extends Configuration
{
    @NotEmpty
    private String filePath;

    @JsonProperty
    public String getFilePath()
    {
        return filePath;
    }

    @JsonProperty
    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

}
