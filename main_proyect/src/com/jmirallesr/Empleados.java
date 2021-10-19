package com.jmirallesr;
import java.io.IOException;
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

            - Añadir empleado

            - Eliminar empleado
         */

public class Empleados {
    public static void main(String[]args) throws IOException {
        Teclado entrada=new Teclado();
        boolean fin=false;
        int opcionMenuEmpleados;
        do{
            opcionMenuEmpleados=menuEmpleados(entrada);
            switch (opcionMenuEmpleados){
                case 0 -> fin=true;
                case 1 -> consultarEmpleado(entrada);
                case 2 -> anadirEmpleado(entrada);
                case 3 -> eliminarEmpleado(entrada);
            }
        }while (!fin);
    }

    static int menuEmpleados(Teclado entrada)throws IOException{
        int opcion;
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("MENU EMPLEADOS");
        System.out.println();
        System.out.println("1- Consultar empleados");
        System.out.println("2- Añadir empleado");
        System.out.println("3- Eliminar empleado");
        System.out.println();
        do{
            System.out.println("Seleccione una opcion (0 para regresar al menu principal) : ");
            opcion=entrada.leerInt();
        }while(opcion<0 || opcion>3);
        return opcion;
    }

    static int menuConsultas(Teclado entrada)throws IOException{
        int opcion;
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("MENU CONSULTAS");
        System.out.println();
        System.out.println("1- General");
        System.out.println("2- Guias");
        System.out.println("3- Recepcionistas");
        System.out.println("4- Mantenimiento");
        System.out.println();
        do{
            System.out.println("Seleccione una opcion (0 para regresar al menu principal) : ");
            opcion=entrada.leerInt();
        }while(opcion<0 || opcion>3);
        return opcion;
    }

    static void consultarEmpleado(Teclado entrada){

    }

    static void anadirEmpleado(Teclado entrada){

    }

    static void eliminarEmpleado(Teclado entrada){

    }
}
