package com.jmirallesr;
import java.io.*;
/*
        En el metodo main se pondra a disposicion del usuario un menu en el que se le
        daran las siguientes opciones:
            - Consultar empleados : En este metodo se mostrara un menu para seleccionar
              el tipo de empleados que desea consultar y se mostraran sus atributos:

                                    - General (todos los empleados en orden alfabetico)
                                    - Guias
                                    - Mantenimiento
                                    - Cuidadores
                                    - Recepcionistas
            - Cambiar datos empleado

            - Añadir empleado

            - Eliminar empleado
         */

public class Empleados {
    public static void main(String[]args) throws IOException {
        RandomAccessFile ficheroEmpleados = new RandomAccessFile("C:\\ficheroEmpleados.txt", "rw");
        FileWriter escritor = new FileWriter("C:\\ficheroEmpleados.txt");
        BufferedWriter bw = new BufferedWriter(escritor);
        FileReader lector = new FileReader("C:\\ficheroEmpleados.txt");
        BufferedReader br = new BufferedReader(lector);
        Teclado entrada=new Teclado();
        boolean fin=false;
        int opcionMenuEmpleados;
        do{
            opcionMenuEmpleados=Menus.menuEmpleados(entrada);
            switch (opcionMenuEmpleados){
                case 0 -> fin=true;
                case 1 -> consultas(entrada);
                case 2 -> cambiarDatosEmpleado(entrada);
                case 3 -> anadirEmpleado(entrada, ficheroEmpleados, escritor, bw);
                case 4 -> eliminarEmpleado(entrada);
            }
        }while (!fin);
    }

    static void consultas(Teclado entrada) throws IOException{
        boolean fin=false;
        int opcionMenuConsultas;
        do{
            opcionMenuConsultas=Menus.menuConsultas(entrada);
            switch (opcionMenuConsultas){
                case 0 -> fin=true;
                case 1 -> consultaGeneral(entrada);
                case 2 -> consultaTipoTrabajo(entrada, opcionMenuConsultas);
                case 3 -> consultaTipoTrabajo(entrada, opcionMenuConsultas);
                case 4 -> consultaTipoTrabajo(entrada, opcionMenuConsultas);
                case 5 -> consultaNumeroEmpleado(entrada);
            }
        }while (!fin);
    }


    static void cambiarDatosEmpleado(Teclado entrada) throws IOException{
        boolean fin=false;
        int opcionMenuCambiarDatos, numeroEmpleado;
        // El usuario introduce el numero del usuario que va a alterar
        do{
            System.out.println();
            System.out.println("Introduza el ID del empleado en el que se aplicaran los cambios (0 para regresar al menu principal): ");
            numeroEmpleado= entrada.leerInt();
        }while(numeroEmpleado<0/*|| el empleado no existe*/);

        // En caso de que el empleado exista se le pregunta al usuario lo que desea cambiar
        do{
            opcionMenuCambiarDatos=Menus.menuCambiarDatos(entrada);
            switch (opcionMenuCambiarDatos){
                case 0 -> fin=true;
            }
        }while (!fin);

    }

    static void anadirEmpleado(Teclado entrada, RandomAccessFile ficheroEmpleados, FileWriter escritor, BufferedWriter bw) throws IOException{
        ficheroEmpleados.seek(ficheroEmpleados.length());
        bw.newLine();
        boolean fin=false;
        String nombreApellidos, tipoTrabajo, dni, valoracion, vacaciones;
        int id/*va a ser un contador*/, horasTrabajo, sueldo;


    }

    static void eliminarEmpleado(Teclado entrada){

    }


    // TIPOS DE CONSULTAS:

    static void consultaGeneral(Teclado entrada){

    }

    static void consultaTipoTrabajo(Teclado entrada, int tipoTrabajo){
        // En funcion del tipo de trabajo que se seleccione cambia el String
        String trabajoSeleccionado;
        switch (tipoTrabajo){
            case 2 -> trabajoSeleccionado="Guias";
            case 3 -> trabajoSeleccionado="Recepcionistas";
            case 4 -> trabajoSeleccionado="Mantenimiento";
        }

    }

    static void consultaNumeroEmpleado(Teclado entrada){

    }
}
