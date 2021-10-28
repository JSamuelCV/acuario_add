package com.jmirallesr;
import java.io.*;
public class Cliente {

    private String nombre,apellidos,dni,correoElectronico,nombreResponsable,horaEntrada,horaSalida;
    private int edad,valoracion,numVisitante;
    final int LONGNOMBRE = 30;
    final int LONGAPELLIDOS = 50;
    final int LONGDNI = 9;
    final int LONGCORREO=40;
    final int LONGNOMBRERESPONSABLE=30;
    final int LONGHORAENTRADA=5;
    final int LONGHORASALIDA=5;



    Cliente(){}
    Cliente(int numVisitante,String nombre, String apellidos, String dni, String correoElectronico, String nombreResponsable, int edad, String horaEntrada, String horaSalida, int valoracion){
        this.numVisitante=numVisitante;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.dni=dni;
        this.correoElectronico=correoElectronico;
        this.nombreResponsable=nombreResponsable;
        this.edad=edad;
        this.horaEntrada=horaEntrada;
        this.horaSalida=horaSalida;
        this.valoracion=valoracion;


    }
    public int getNumVisitante(){
        return this.numVisitante;
    }
    public String getnombre() {
        return this.nombre;
    }
    public String getapellidos(){
        return this.apellidos;
    }
    public String getdni(){
        return this.dni;
    }
    public String getcorreoElectronico(){
        return this.correoElectronico;
    }
    public String getnombreResponsable(){
        return this.nombreResponsable;
    }
    public int getedad(){
        return this.edad;
    }
    public String gethoraEntrada(){
        return this.horaEntrada;
    }
    public String gethoraSalida(){
        return this.horaSalida;
    }

    public int getvaloracion(){
        return this.valoracion;
    }

    void setnumVisitante(int numVisitante){
        this.numVisitante=numVisitante;
    }
    void setnombre(String nombre) {
        this.nombre = nombre;
    }
    void setapellidos(String apellidos){
        this.apellidos = apellidos;
    }
    void setdni(String dni){
        this.dni= dni;
    }
    void setcorreoElectronico(String correoElectronico){
        this.correoElectronico= correoElectronico;
    }
    void setnombreResponsable(String nombreResponsable){
        this.nombreResponsable=nombreResponsable;
    }
    void setedad(int edad){
        this.edad=edad;
    }
    void sethoraEntrada(String horaEntrada){
        this.horaEntrada=horaEntrada;
    }
    void setHoraSalida(String horaSalida){
        this.horaSalida=horaSalida;
    }

    void setvaloracion(int valoracion){
        this.valoracion=valoracion;
    }




    int tamano(){

        return(4+2+30+2+50+2+9+2+40+2+30+4+2+5+2+5+4);
    }
    String construirNombreParaFich(){
        String saux;
        int longrelleno;
        nombre.trim();
        longrelleno = LONGNOMBRE- nombre.length();
        saux = nombre + blancos(longrelleno);
        return (saux);
    }
    String construirApellidosParaFich(){
        String saux;
        int longrelleno;
        apellidos.trim();
        longrelleno = LONGAPELLIDOS- apellidos.length();
        saux = apellidos + blancos(longrelleno);
        return (saux);
    }
    String construirDNIParaFich(){
        String saux;
        int longrelleno;
        dni.trim();
        longrelleno = LONGDNI- dni.length();
        saux = dni + blancos(longrelleno);
        return (saux);
    }
    String construirCorreoParaFich(){
        String saux;
        int longrelleno;
        dni.trim();
        longrelleno = LONGDNI- dni.length();
        saux = dni + blancos(longrelleno);
        return (saux);
    }
    String construirNombreResponsableParaFich(){
        String saux;
        int longrelleno;
        nombreResponsable.trim();
        longrelleno = LONGNOMBRERESPONSABLE- nombreResponsable.length();
        saux = nombreResponsable + blancos(longrelleno);
        return (saux);
    }
    String construirHoraEntradaParaFich(){
        String saux;
        int longrelleno;
        horaEntrada.trim();
        longrelleno = LONGHORAENTRADA- horaEntrada.length();
        saux = horaEntrada + blancos(longrelleno);
        return (saux);
    }
    String construirHoraSalidaParaFich(){
        String saux;
        int longrelleno;
        horaSalida.trim();
        longrelleno = LONGHORASALIDA- horaSalida.length();
        saux = horaSalida + blancos(longrelleno);
        return (saux);
    }
    String blancos(int numblancos){
        char[] relleno = new char[numblancos];
        for(int i=0;i<numblancos;i++)
            relleno[i] = ' ';
        String srelleno = new String(relleno);
        return (srelleno);
    }
    void escribirEnArchivo(RandomAccessFile f){
        String saux;
        try{
            f.writeInt(numVisitante);
            saux = construirNombreParaFich();
            f.writeUTF(saux);
            saux = construirApellidosParaFich();
            f.writeUTF(saux);
            saux = construirDNIParaFich();
            f.writeUTF(saux);
            saux = construirCorreoParaFich();
            f.writeUTF(saux);
            saux = construirNombreResponsableParaFich();
            f.writeUTF(saux);
            f.writeInt(edad);
            saux = construirHoraEntradaParaFich();
            f.writeUTF(saux);
            saux = construirHoraSalidaParaFich();
            f.writeUTF(saux);
            f.writeInt(valoracion);



        }catch(IOException e){
            System.out.println("Error: "+e);
        }
    }
    boolean leerDeArchivo(RandomAccessFile f){
        boolean finArchivo = false;
        try{
            numVisitante=f.readInt();
            nombre=f.readUTF();
            apellidos=f.readUTF();
            dni=f.readUTF();
            correoElectronico=f.readUTF();
            nombreResponsable=f.readUTF();
            edad=f.readInt();
            horaEntrada=f.readUTF();
            horaSalida=f.readUTF();

            valoracion=f.readInt();


        }catch(EOFException eofe){
            finArchivo=true;
        }catch(IOException ioe){
            System.out.println("Error: "+ioe);
        }
        return (finArchivo);
    }
    void mostrarDatosEntrada(){
        System.out.println("El visitante numero "+numVisitante+" llamado "+nombre+" "+apellidos+" entró al acuario a las "+horaEntrada+" horas.");
    }
    void mostrarDatosSalida(){
        System.out.println("El visitante numero "+numVisitante+" llamado "+nombre+" "+apellidos+" salió del acuario a las "+horaSalida+" horas.");
    }
    void mostrarDatos(){
        System.out.println("Número de visitante: "+numVisitante+",Nombre: "+nombre+", Apellidos: "+apellidos+", DNI: "+dni+", Correo electrónico: "+correoElectronico+", Nombre de la persona responsable: "+nombreResponsable+", Edad:"+edad+", Hora de entrada al recinto: "+horaEntrada+", Hora de salida del recinto: "+horaSalida+", Valoracion: "+valoracion);
    }

}