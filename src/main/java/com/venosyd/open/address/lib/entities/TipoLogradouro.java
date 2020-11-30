package com.venosyd.open.address.lib.entities;

import com.venosyd.open.entities.infra.SerializableEntity;

/**
 * @author sergio lisan <sels@venosyd.com>
 * 
 *         nomes em portugues para diferenciar da biblioteca anterior
 * 
 *         venosyd © 2016-2020
 */
public class TipoLogradouro extends SerializableEntity {

    private String descricao;

    public TipoLogradouro() {
        setCollection_key(getClass().getSimpleName());
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
