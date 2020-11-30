package com.venosyd.open.address.rest;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.venosyd.open.commons.util.JSONUtil;
import com.venosyd.open.commons.util.RESTService;
import com.venosyd.open.address.logic.AddressBS;

/**
 * @author sergio lisan <sels@venosyd.com>
 */
@Path("/")
public class AddressRSImpl implements AddressRS, RESTService {

    @Context
    private HttpHeaders headers;

    public AddressRSImpl() {

    }

    @Override
    public Response echo() {
        String message = "ADDRESS ECHO GRANTED" + Calendar.getInstance().get(Calendar.YEAR);

        var echoMessage = new HashMap<String, String>();
        echoMessage.put("status", "ok");
        echoMessage.put("message", message);

        return makeResponse(echoMessage);
    }

    @Override
    public Response getLogradouro(String body) {
        body = unzip(body);
        return process(body, (request) -> {
            var returned = AddressBS.INSTANCE.getLogradouro(request.get("cep"));

            if (returned != null) {
                var result = new HashMap<String, String>();
                result.put("status", "ok");
                result.put("payload", returned + "");

                return makeResponse(result);
            } else {
                return makeErrorResponse("Falha ao carregar Logradouro");
            }
        }, "getLogradouro");
    }

    @Override
    public Response getStates(String body) {
        body = unzip(body);
        return process(body, (request) -> {
            var result = new HashMap<String, String>();
            var returned = AddressBS.INSTANCE.getStates(request.get("pais"));

            if (returned != null) {
                result.put("status", "ok");
                result.put("payload", JSONUtil.toJSON(returned));

                return makeResponse(result);
            } else {
                return makeErrorResponse("Falha ao carregar estados");
            }
        }, "getStates");

    }

    @Override
    public Response getCities(String body) {
        body = unzip(body);
        return process(body, (request) -> {
            var result = new HashMap<String, String>();
            var returned = AddressBS.INSTANCE.getCities(request.get("estado"));

            if (returned != null) {
                result.put("status", "ok");
                result.put("payload", JSONUtil.toJSON(returned));

                return makeResponse(result);
            } else {
                return makeErrorResponse("Falha ao carregar cidades");
            }
        }, "getCities");

    }

    @Override
    public Response getDistricts(String body) {
        body = unzip(body);
        return process(body, (request) -> {
            var result = new HashMap<String, String>();
            var returned = AddressBS.INSTANCE.getDistricts(request.get("cidade"));

            if (returned != null) {
                result.put("status", "ok");
                result.put("payload", JSONUtil.toJSON(returned));

                return makeResponse(result);
            } else {
                return makeErrorResponse("Falha ao carregar distritos");
            }
        }, "getDistricts");

    }

    @Override
    public Response updateLogradouro(String body) {
        var arguments = Arrays.<String>asList("cep", "nome");

        return process(_unwrap(body), getauthcode(headers), arguments, (request) -> {
            var result = new HashMap<String, String>();

            var zipCode = request.get("cep");
            var newName = request.get("nome");

            try {
                AddressBS.INSTANCE.updatePlace(zipCode, newName);

                result.put("status", "ok");
                result.put("message", "Logradouro atualizado com sucesso");

                return makeResponse(result);

            } catch (Exception e) {
                return makeErrorResponse("Falha ao atualizar logradouro");
            }
        });
    }

    @Override
    public Response addNovoLogradouro(String body) {
        var arguments = Arrays.<String>asList("pais", "estado", "cidade", "distrito", "tipologradouro", "logradouro",
                "cep");

        return process(_unwrap(body), getauthcode(headers), arguments, (request) -> {
            var result = new HashMap<String, String>();

            var country = request.get("pais");
            var state = request.get("estado");
            var city = request.get("cidade");
            var district = request.get("distrito");
            var placeType = request.get("tipologradouro");
            var placeName = request.get("logradouro");
            var zipCode = request.get("cep");

            try {
                AddressBS.INSTANCE.addNewPlace(country, state, city, district, placeType, placeName, zipCode);

                result.put("status", "ok");
                result.put("message", "Novo logradouro adicionado com sucesso");

                return makeResponse(result);

            } catch (Exception e) {
                return makeErrorResponse("Falha ao adicionar novo logradouro");
            }
        });
    }

    //
    // PRIVATE METHODS
    //

    private Map<String, String> _unwrap(String body) {
        body = unzip(body);

        var request = JSONUtil.<String, String>fromJSONToMap(body);
        request.put("database", "e5d67ad6f5af2e4bf29c5de07a24c61a");

        return request;
    }

}
