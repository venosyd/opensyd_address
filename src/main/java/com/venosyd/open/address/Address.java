package com.venosyd.open.address;

import java.util.List;

import com.venosyd.open.address.lib.entities.Cidade;
import com.venosyd.open.address.lib.entities.Distrito;
import com.venosyd.open.address.lib.entities.Estado;
import com.venosyd.open.address.lib.entities.Logradouro;
import com.venosyd.open.address.logic.AddressBS;

/**
 * @author sergio lisan <sels@venosyd.com>
 */
public abstract class Address {

    /**
     * return a address by a zipCode
     */
    public static Logradouro getLogradouro(String zipCode) {
        return AddressBS.INSTANCE.getLogradouro(zipCode);
    }

    /**
     * returns a list of states
     */
    public static List<Estado> getStates(String countryID) {
        return AddressBS.INSTANCE.getStates(countryID);
    }

    /**
     * returns a list of cities
     */
    public static List<Cidade> getCities(String stateID) {
        return AddressBS.INSTANCE.getCities(stateID);
    }

    /**
     * returns a lista of districts
     */
    public static List<Distrito> getDistricts(String cityID) {
        return AddressBS.INSTANCE.getDistricts(cityID);
    }

    /**
     * adds a new place. can add country, state, city, district and placetype too
     */
    public static void addNewPlace(String countryName, String stateName, String cityName, String districtName,
            String placeTypeName, String placeName, String zipCode) {
        AddressBS.INSTANCE.addNewPlace(countryName, stateName, cityName, districtName, placeTypeName, placeName,
                zipCode);
    }

    /**
     * updates a place
     */
    public static void updatePlace(String zipCode, String newName) {
        AddressBS.INSTANCE.updatePlace(zipCode, newName);
    }

}
