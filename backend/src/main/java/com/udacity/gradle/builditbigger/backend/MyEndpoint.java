package com.udacity.gradle.builditbigger.backend;

import com.example.boringjokes.BoringJokes;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);
        BoringJokes jokes = new BoringJokes();

        return response;
    }


    @ApiMethod(name = "getBoringJoke")
    public MyBean getJoke(){
        BoringJokes boringJokes = new BoringJokes();

        MyBean myBean =new MyBean();
        myBean.setData(boringJokes.getJoke());

        return myBean;
    }

}
