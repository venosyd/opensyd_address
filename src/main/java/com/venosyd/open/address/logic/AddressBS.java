package com.venosyd.open.address.logic;

import java.util.List;

import com.venosyd.open.address.lib.entities.Cidade;
import com.venosyd.open.address.lib.entities.Distrito;
import com.venosyd.open.address.lib.entities.Estado;
import com.venosyd.open.address.lib.entities.Logradouro;

/**
 * @author sergio lisan <sels@venosyd.com>
 */
public interface AddressBS {

    /**
     * INSTANCE
     */
    AddressBS INSTANCE = new AddressBSImpl();

    /**
     * return a address by a zipCode
     */
    Logradouro getLogradouro(String zipCode);

    /**
     * returns a list of states
     */
    List<Estado> getStates(String countryID);

    /**
     * returns a list of cities
     */
    List<Cidade> getCities(String stateID);

    /**
     * returns a lista of districts
     */
    List<Distrito> getDistricts(String cityID);

    /**
     * adds a new place. can add country, state, city, district and placetype too
     */
    void addNewPlace(String countryName, String stateName, String cityName, String districtName, String placeTypeName,
            String placeName, String zipCode);

    /**
     * updates a place
     */
    void updatePlace(String zipCode, String newName);

}
