package com.jmirallesr;

public enum ElementoSerVivo {
    SER_VIVO("ser_vivo"),ID("id"),ESPECIE("especie"),GENERO("genero"),FECHA_COMPRA("fecha_compra"),
    PROCEDENCIA("procedencia"),COMPORTAMIENTO("comportamiento"),ESTADO("estado"),ALIMENTACION("alimentacion"),
    ID_SIMBIOSIS("id_simbiosis"),TRATAMIENTO("tratamiento"),SIMBIOSIS("simbiosis");

    private String etiqueta;

    private ElementoSerVivo(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
}
