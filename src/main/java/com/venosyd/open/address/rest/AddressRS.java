package com.venosyd.open.address.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author sergio lisan <sels@venosyd.com>
 */
public interface AddressRS {

    String ADDRESS_BASE_URI = "/address";

    String ADDRESS_ECHO = "/echo";

    String ADDRESS_GET_PLACE = "/get/new/place";

    String ADDRESS_GET_STATES = "/get/states";

    String ADDRESS_GET_CITIES = "/get/cities";

    String ADDRESS_GET_DISTRICTS = "/get/districts";

    String ADDRESS_UPDATE_PLACE = "/update/place";

    String ADDRESS_ADD_PLACE = "/add/place";

    /**
     * Hello from the server siiiiiiide!
     */
    @GET
    @Path(ADDRESS_ECHO)
    @Produces({ MediaType.APPLICATION_JSON })
    Response echo();

    /**
     * retorna um logradouro com base no CEP (zipCode)
     * 
     * { "pais": "" }
     */
    @POST
    @Path(ADDRESS_GET_STATES)
    @Produces({ MediaType.APPLICATION_JSON })
    Response getStates(String body);

    /**
     * retorna um logradouro com base no CEP (zipCode)
     * 
     * { "estado": "" }
     */
    @POST
    @Path(ADDRESS_GET_CITIES)
    @Produces({ MediaType.APPLICATION_JSON })
    Response getCities(String body);

    /**
     * retorna um logradouro com base no CEP (zipCode)
     * 
     * { "cidade": "" }
     */
    @POST
    @Path(ADDRESS_GET_DISTRICTS)
    @Produces({ MediaType.APPLICATION_JSON })
    Response getDistricts(String body);

    /**
     * retorna um logradouro com base no CEP (zipCode)
     * 
     * { "cep": "" }
     */
    @POST
    @Path(ADDRESS_GET_PLACE)
    @Produces({ MediaType.APPLICATION_JSON })
    Response getLogradouro(String body);

    /**
     * retorna um logradouro com base no CEP (zipCode)
     * 
     * { "cep": "", "nome": "" }
     */
    @POST
    @Path(ADDRESS_UPDATE_PLACE)
    @Produces({ MediaType.APPLICATION_JSON })
    Response updateLogradouro(String body);

    /**
     * retorna um logradouro com base no CEP (zipCode)
     * 
     * { "pais": "", "estado": "", "cidade": "", "distrito": "", "tipologradouro":
     * "", "logradouro": "", "cep": "" }
     */
    @POST
    @Path(ADDRESS_ADD_PLACE)
    @Produces({ MediaType.APPLICATION_JSON })
    Response addNovoLogradouro(String body);

}
