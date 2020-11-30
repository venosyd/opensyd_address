package com.venosyd.open.address.lib.entities;

import com.venosyd.open.entities.infra.SerializableEntity;

/**
 * @author sergio lisan <sels@venosyd.com>
 * 
 *         nomes em portugues para diferenciar da biblioteca anterior
 * 
 *         venosyd © 2016-2020
 */
public class Logradouro extends SerializableEntity {

    private String distritoID;

    private String nome;

    private String cep;

    private String tipoLogradouroID;

    public Logradouro() {
        setCollection_key(getClass().getSimpleName());
    }

    public String getDistritoID() {
        return distritoID;
    }

    public void setDistritoID(String distritoID) {
        this.distritoID = distritoID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTipoLogradouroID() {
        return tipoLogradouroID;
    }

    public void setTipoLogradouroID(String tipoLogradouroID) {
        this.tipoLogradouroID = tipoLogradouroID;
    }

}
