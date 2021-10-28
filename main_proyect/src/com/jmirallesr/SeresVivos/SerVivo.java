package com.jmirallesr.SeresVivos;

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

    public void mostrarDatos(){
        if(id!=null){
            System.out.println("Id: " + id);
            if(especie!=null){
                System.out.println("Especie: " + especie);
            }
            if(genero!=null){
                if(genero.equalsIgnoreCase("Macho")||genero.equalsIgnoreCase("Hembra")||genero.equalsIgnoreCase("Hermafrodita")||genero.equalsIgnoreCase("Hermafrodita(Macho)")||genero.equalsIgnoreCase("Hermafrodita(Hembra)")) {
                    System.out.println("Genero: " + genero);
                }
            }
            if(fechaCompra!=null){
                System.out.println("Fecha de compra: " + fechaCompra);
            }
            if(procedencia!=null){
                System.out.println("Procedencia: " + procedencia);
            }
            if(comportamiento!=null){
                System.out.println("Comportamiento: " + comportamiento);
            }
            if(alimentacion!=null){
                System.out.println("Alimentacion: " + alimentacion);
            }
            if(estado!=null){
                if(estado.equalsIgnoreCase("Normal")||estado.equalsIgnoreCase("Enfermo")||estado.equalsIgnoreCase("Gestacion")){
                    System.out.println("Estado: " + estado);
                    if(estado.equalsIgnoreCase("Enfermo")&&tratamiento!=null){
                        System.out.println("Tratamiento: " + tratamiento);
                    }
                }
            }
            if(simbiosis!=null){
                if(simbiosis.equalsIgnoreCase("True")||simbiosis.equalsIgnoreCase("False")){
                    System.out.println("Simbiosis: " + simbiosis);
                    if(simbiosis.equalsIgnoreCase("True")&&idSimbiosis!=null){
                        System.out.println("Id Simbiosis: " + idSimbiosis);
                    }
                }
            }
            System.out.println("---------------------------------------------------------------------------------------------");
        }
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
