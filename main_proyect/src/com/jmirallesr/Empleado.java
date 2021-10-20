package com.jmirallesr;

public class Empleado {
    private String id, nombre, apellidos, dni, vacaciones, tipoTrabajo;
    private int sueldo, horasTrabajo, valoracion; // valoracion al final lo pongo en int porque va a ser una nota del 1 al 10

    Empleado(){}
    Empleado(String id,String nombre,String apellidos, String dni, String tipoTrabajo, int horasTrabajo, int sueldo, String vacaciones, int valoracion){
        this.id=id;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.dni=dni;
        this.tipoTrabajo=tipoTrabajo;
        this.horasTrabajo=horasTrabajo;
        this.sueldo=sueldo;
        this.vacaciones=vacaciones;
        this.valoracion =valoracion;
    }

    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getDni() {
        return dni;
    }
    public String getTipoTrabajo() {
        return tipoTrabajo;
    }
    public String getVacaciones() {return vacaciones;}
    public int getSueldo() {return sueldo;}
    public int getHorasTrabajo() {return horasTrabajo;}
    public int getValoracion() {return valoracion;}
}
