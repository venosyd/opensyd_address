package com.venosyd.open.address.lib.entities;

import com.venosyd.open.entities.infra.SerializableEntity;

/**
 * @author sergio lisan <sels@venosyd.com>
 * 
 *         nomes em portugues para diferenciar da biblioteca anterior
 * 
 *         venosyd © 2016-2020
 */
public class Endereco extends SerializableEntity {

    private String logradouroID;

    private Integer numero;

    private String complemento;

    private Double longitude;

    private Double latitude;

    public Endereco() {
        setCollection_key(getClass().getSimpleName());
    }

    public String getLogradouroID() {
        return logradouroID;
    }

    public void setLogradouroID(String logradouroID) {
        this.logradouroID = logradouroID;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplementos() {
        return complemento;
    }

    public void setComplementos(String complementos) {
        this.complemento = complementos;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

}
