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
            - Cambiar datos empleado

            - Añadir empleado

            - Eliminar empleado
         */

public class Empleados {
    public static void main(String[]args) throws IOException {
        Teclado entrada=new Teclado();
        Menus menu=new Menus();
        boolean fin=false;
        int opcionMenuEmpleados;
        do{
            opcionMenuEmpleados=Menus.menuEmpleados(entrada);
            switch (opcionMenuEmpleados){
                case 0 -> fin=true;
                case 1 -> consultas(entrada);
                case 2 -> cambiarDatosEmpleado(entrada);
                case 3 -> anadirEmpleado(entrada);
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
        }while(numeroEmpleado==Integer.MIN_VALUE || numeroEmpleado<0/*|| el empleado no existe*/);

        // En caso de que el empleado exista se le pregunta al usuario lo que desea cambiar
        do{
            opcionMenuCambiarDatos=Menus.menuCambiarDatos(entrada);
            switch (opcionMenuCambiarDatos){
                case 0 -> fin=true;
            }
        }while (!fin);

    }

    static void anadirEmpleado(Teclado entrada){

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
