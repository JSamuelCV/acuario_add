package com.jmirallesr;

import java.io.*;

public class Main {

    static final String rutaSeresVivos = System.getProperty("user.home") + "/Desktop/e.txt";;

    public static void main(String[] args) {
    }






    //Empleados
    /*
        En el metodo main se pondra a disposicion del usuario un menu en el que se le
        daran las siguientes opciones:

            - Listar empleados : En este metodo se mostraran los empleados del acuario

            - Cambiar datos empleado : Añadir empleado/Eliminar empleado/Cambiar datos de un empleado

     */
    static void menuPrincipalEmpleados() throws IOException{
        final String rutaEmpleados="C:\\ficheroEmpleados.txt";
        File archivoEmpleados = new File (rutaEmpleados);
        FileReader lector = new FileReader (rutaEmpleados);
        BufferedReader br = new BufferedReader(lector);
        Teclado entrada=new Teclado();
        boolean fin=false;
        int opcionMenuEmpleados;
        do{
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("MENU EMPLEADOS");
            System.out.println();
            System.out.println("1- Listar empleados");
            System.out.println("2- Cambiar datos de un empleado");
            System.out.println();
            do{
                System.out.println("Seleccione una opcion (0 para terminar) : ");
                opcionMenuEmpleados=entrada.leerInt();
            }while(opcionMenuEmpleados<0 || opcionMenuEmpleados>4);

            switch (opcionMenuEmpleados){
                case 0 -> fin=true;
                case 1 -> lista(archivoEmpleados, br, lector);
                case 2 -> cambiarDatosEmpleado(rutaEmpleados);
            }
        }while(!fin);
    }

    static void lista(File archivoEmpleados, BufferedReader br, FileReader lector) throws IOException{
        int i;
        String linea;
        for(i=1;i<archivoEmpleados.length();i++){
            linea=br.readLine();
            System.out.println();
            System.out.println("Empleado "+i+" : "+linea);
            System.out.println();
        }
    }

    static void cambiarDatosEmpleado(String rutaEmpleados){
        System.out.println("Si desea cambiar los datos de un empleado puede hacerlo en el siguiente directorio: "+rutaEmpleados);
    }




    //SerVivo
    static void menuPrincipalSerVivo() throws IOException {
        Teclado t = new Teclado();
        int op = 0;
        System.out.println("\n\tMENU SERES VIVOS\n\t====\n");
        System.out.println("1.- Consultas.");
        System.out.println("2.- Listados.");
        System.out.println("3.- Altas/Bajas/Modificaciones.\n");
        System.out.println("4.- Volver.\n");
        do {
            System.out.print("\tTeclee opción ? ");
            op = t.leerInt();
        }while(op<1||op>4);

        switch(op){
            case 1:
                consultasSerVivo();
                break;
            case 2:
                listadosSerVivo();
                break;
            case 3:
                infoAltasSerVivo();
                break;
            default:
                if(op!=4)
                    System.out.println("Valor introducido no corresponde con ninguna opcion");
                break;
        }
    }

    static void consultasSerVivo(){

    }

    static void listadosSerVivo(){
        //TEST DE METODOS
        String linea="";
        try {
            BufferedReader in=new BufferedReader(new FileReader(rutaSeresVivos));
            while((linea = in.readLine())!=null) {
                System.out.println(linea);
            }
            in.close();
        }catch(IOException ioe) {}
    }

    static void infoAltasSerVivo(){
        System.out.println("Para realizar altas,bajas o modificaciones de algun ser vivo," +
                "debes acceder al archivo (" + rutaSeresVivos + ") ");
    }

    static void comprobarArchivoSeresVivos(){
        try {
            BufferedWriter out=new BufferedWriter(new FileWriter(rutaSeresVivos,false));
            out.write("Ejemplo1");
            out.newLine();
            out.write("Ejemplo2");
            out.newLine();
            out.write("Ejemplo3");
            out.newLine();
            out.close();
        }catch(IOException ioe) {}
    }
}
