package com.jmirallesr;

import java.io.IOException;

public class Menus {

    static int menuEmpleados(Teclado entrada)throws IOException {
        int opcion;
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("MENU EMPLEADOS");
        System.out.println();
        System.out.println("1- Consultar empleados");
        System.out.println("2- Cambiar datos de un empleado");
        System.out.println("3- Añadir empleado");
        System.out.println("4- Eliminar empleado");
        System.out.println();
        do{
            System.out.println("Seleccione una opcion (0 para terminar) : ");
            opcion=entrada.leerInt();
        }while(opcion<0 || opcion>4);
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
        System.out.println("5- Consultar empleado por numero");
        System.out.println();
        do{
            System.out.println("Seleccione una opcion (0 para regresar al menu principal) : ");
            opcion=entrada.leerInt();
        }while(opcion<0 || opcion>5);
        return opcion;
    }

    static int menuCambiarDatos(Teclado entrada) throws IOException{
        int opcion;
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("MENU CAMBIAR DATOS");
        System.out.println();
        System.out.println();
        do{
            System.out.println("Seleccione una opcion (0 para regresar al menu principal) : ");
            opcion=entrada.leerInt();
        }while(opcion<0 || opcion>5);
        return opcion;
    }
}
