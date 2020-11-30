package com.venosyd.open.address.lib.entities;

import com.venosyd.open.entities.infra.SerializableEntity;

/**
 * @author sergio lisan <sels@venosyd.com>
 * 
 *         nomes em portugues para diferenciar da biblioteca anterior
 * 
 *         venosyd © 2016-2020
 */
public class Distrito extends SerializableEntity {

    private String cidadeID;

    private String nome;

    public Distrito() {
        setCollection_key(getClass().getSimpleName());
    }

    public String getCidadeID() {
        return cidadeID;
    }

    public void setCidadeID(String cidadeID) {
        this.cidadeID = cidadeID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
