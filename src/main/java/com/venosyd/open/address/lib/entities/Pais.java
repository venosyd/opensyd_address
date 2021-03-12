package com.venosyd.open.address.lib.entities;

import com.venosyd.open.entities.infra.SerializableEntity;

/**
 * @author sergio lisan <sels@venosyd.com>
 * 
 *         nomes em portugues para diferenciar da biblioteca anterior
 * 
 *         venosyd © 2016-2021
 */
public class Pais extends SerializableEntity {

    private Integer codigo;

    private String nome;

    public Pais() {
        setCollection_key(getClass().getSimpleName());
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer code) {
        this.codigo = code;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

}
