package com.jmirallesr;

import java.io.*;

public class Main {

    static final String rutaSeresVivos = System.getProperty("user.home") + "/Desktop/e.txt";;

    public static void main(String[] args) {
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
