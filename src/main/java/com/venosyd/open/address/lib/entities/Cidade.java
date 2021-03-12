package com.venosyd.open.address.lib.entities;

import com.venosyd.open.entities.infra.SerializableEntity;

/**
 * @author sergio lisan <sels@venosyd.com>
 * 
 *         nomes em portugues para diferenciar da biblioteca anterior
 * 
 *         venosyd © 2016-2021
 */
public class Cidade extends SerializableEntity {

    private String estadoID;

    private String nome;

    public Cidade() {
        setCollection_key(getClass().getSimpleName());
    }

    public String getEstadoID() {
        return estadoID;
    }

    public void setEstadoID(String estadoID) {
        this.estadoID = estadoID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
