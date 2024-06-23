package com.nexus.processnet.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Cargo {
    VISTORIADOR("Vistoriador"),
    ANALISTA("Analista"),
    GESTOR("Gestor");

    private final String descricao;

    Cargo(String descricao) {
        this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static Cargo fromDescricao(String descricao) {
        for (Cargo cargo : Cargo.values()) {
            if (cargo.descricao.equalsIgnoreCase(descricao)) {
                return cargo;
            }
        }
        throw new IllegalArgumentException("Descrição de cargo inválida: " + descricao);
    }
}
