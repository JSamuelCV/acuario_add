package com.jmirallesr;

import java.io.BufferedReader;
import java.io.IOException;

public class SerVivo {
    private String id,especie,genero,fechaCompra,procedencia,comportamiento,estado,alimentacion,idSimbiosis,tratamiento,simbiosis;

    SerVivo(){}
    SerVivo(String id,String especie,String genero,String fechaCompra,String procedencia,String comportamiento,String estado,String alimentacion,String simbiosis){
        this.id=id;
        this.especie=especie;
        this.genero=genero;
        this.fechaCompra=fechaCompra;
        this.procedencia=procedencia;
        this.comportamiento=comportamiento;
        this.estado=estado;
        this.alimentacion=alimentacion;
        this.simbiosis=simbiosis;
    }

    void mostrarDatos(){
        System.out.println("---");
        System.out.println("\tID: " + id + "\n" +
                "\tEspecie: " + especie + "\n" +
                "\tGenero: " + genero + "\n" +
                "\tFecha de compra: " + fechaCompra +"\n" +
                "\tProcedencia: " + procedencia + "\n" +
                "\tComportamiento: " + comportamiento + "\n" +
                "\tEstado: " + estado);
        if(estado.equalsIgnoreCase("Enfermo")){
            System.out.println("\tTratamiento: " + tratamiento);
        }
        System.out.println("\tAlimentacion: " + alimentacion + "\n" +
                "\tSimbiosis: " + simbiosis);
        if(simbiosis.equalsIgnoreCase("True")){
            System.out.println("\tIDSimbiosis: " + idSimbiosis);
        }
        System.out.println("---");
    }

    int leerDatos(BufferedReader in){
        int lineas = 9;
        try {
            this.id=in.readLine();
            this.especie=in.readLine();
            this.genero=in.readLine();
            this.fechaCompra=in.readLine();
            this.procedencia=in.readLine();
            this.comportamiento=in.readLine();
            this.estado=in.readLine();
            if(estado.equalsIgnoreCase("Enfermo")){
                this.tratamiento=in.readLine();
                lineas++;
            }
            this.alimentacion=in.readLine();
            this.simbiosis=in.readLine();
            if(simbiosis.equalsIgnoreCase("True")){
                this.idSimbiosis=in.readLine();
                lineas++;
            }
        }catch(IOException ioe) {}
        return lineas;
    }

    public String getId() {
        return id;
    }
    public String getEspecie() {
        return especie;
    }
    public String getGenero() {
        return genero;
    }
    public String getFechaCompra() {
        return fechaCompra;
    }
    public String getProcedencia() {
        return procedencia;
    }
    public String getComportamiento() {
        return comportamiento;
    }
    public String getEstado() {
        return estado;
    }
    public String getAlimentacion() {
        return alimentacion;
    }
    public String getIdSimbiosis() {
        return idSimbiosis;
    }
    public String getTratamiento() {
        return tratamiento;
    }
    public String getSimbiosis() {
        return simbiosis;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }
    public void setComportamiento(String comportamiento) {
        this.comportamiento = comportamiento;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }
    public void setIdSimbiosis(String idSimbiosis) {
        this.idSimbiosis = idSimbiosis;
    }
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
    public void setSimbiosis(String simbiosis) {
        this.simbiosis = simbiosis;
    }
}
