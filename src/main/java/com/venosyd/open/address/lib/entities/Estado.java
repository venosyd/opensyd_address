package com.venosyd.open.address.lib.entities;

import com.venosyd.open.entities.infra.SerializableEntity;

/**
 * @author sergio lisan <sels@venosyd.com>
 * 
 *         nomes em portugues para diferenciar da biblioteca anterior
 * 
 *         venosyd © 2016-2020
 */
public class Estado extends SerializableEntity {

    private String paisID;

    private String nome;

    private String sigla;

    public Estado() {
        setCollection_key(getClass().getSimpleName());
    }

    public String getPaisID() {
        return paisID;
    }

    public void setPaisID(String countryID) {
        this.paisID = countryID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String initials) {
        this.sigla = initials;
    }

}
