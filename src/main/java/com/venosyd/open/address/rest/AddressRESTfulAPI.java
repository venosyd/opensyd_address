package com.venosyd.open.address.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sergio lisan <sels@venosyd.com>
 */
@ApplicationPath(AddressRS.ADDRESS_BASE_URI)
public class AddressRESTfulAPI extends Application {

    public Set<Class<?>> getClasses() {
        var classes = new HashSet<Class<?>>();

        classes.add(AddressRSImpl.class);

        return classes;
    }
}
