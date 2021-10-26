import java.io.*;
/*
clientes:
   1- entrada:
                registrodedatos(metodos)

                    nombre
                    apellidos
                    Dni
                    correo electronico
                    nombre responsable(opcional)
                    hora de entrada:

    2- salida cliente:
                    mostrarSalida(metodo)
                        hora de salida
                        horas que ha estado
                        valoracion(0-5)
    3- valoracion
                    mostrarvaloracion()
                        individual(todas)
                        media
    4-  estadistica
                   mostrarEstadistica()
                        Nº de gente en un dia


 */
public class Cliente {

    private String nombre,apellidos,dni,correoElectronico,nombreResponsable,horaEntrada,horaSalida,horasDentro;
    private int edad,valoracion,numGente,numVisitante;
    final int LONGNOMBRE = 30;
    final int LONGAPELLIDOS = 50;
    final int LONGDNI = 9;
    final int LONGCORREO=40;
    final int LONGNOMBRERESPONSABLE=30;
    final int LONGHORAENTRADA=5;
    final int LONGHORASALIDA=5;
    final int LONGHORASDENTRO=5;



    Cliente(){}
    Cliente(int numVisitante,String nombre, String apellidos, String dni, String correoElectronico, String nombreResponsable, int edad, String horaEntrada, String horaSalida, String horasDentro, int valoracion, int numGente){
        this.numVisitante=numVisitante;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.dni=dni;
        this.correoElectronico=correoElectronico;
        this.nombreResponsable=nombreResponsable;
        this.edad=edad;
        this.horaEntrada=horaEntrada;
        this.horaSalida=horaSalida;
        this.horasDentro=horasDentro;
        this.valoracion=valoracion;
        this.numGente=numGente;

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
    public String gethorasDentro(){
        return this.horasDentro;
    }
    public int getvaloracion(){
        return this.valoracion;
    }
    public int getNumGente(){
        return this.numGente;
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
    void setHorasDentro(String horasDentro){
        this.horasDentro=horasDentro;
    }
    void setvaloracion(int valoracion){
        this.valoracion=valoracion;
    }
    void setNumGente(int numGente){
        this.numGente=numGente;
    }


    public static void main (String[]args)throws IOException {
        Teclado entrada = new Teclado();


    }
    int tamano(){

        return(4+30+50+9+40+30+4+5+5+5+4+4);
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
    String construirHorasDentroParaFich(){
        String saux;
        int longrelleno;
        horasDentro.trim();
        longrelleno = LONGHORASDENTRO- horasDentro.length();
        saux = horasDentro + blancos(longrelleno);
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
            f.writeUTF(saux); //escribir el string
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
            saux = construirHorasDentroParaFich();
            f.writeUTF(saux);
            f.writeInt(valoracion);
            f.writeInt(numGente);

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
            horasDentro=f.readUTF();
            valoracion=f.readInt();
            numGente=f.readInt();

        }catch(EOFException eofe){
            finArchivo=true;
        }catch(IOException ioe){
            System.out.println("Error: "+ioe);
        }
        return (finArchivo);
    }
    void mostrarDatos(){
        System.out.println(numVisitante+" - "+nombre+" - "+apellidos+" - "+dni+" - "+correoElectronico+" - "+nombreResponsable+" - "+edad+" - "+horaEntrada+" - "+horaSalida+" - "+horasDentro+" - "+valoracion+" - "+numGente);
    }
}
