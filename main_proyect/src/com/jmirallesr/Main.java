package com.jmirallesr;

import java.io.*;

public class Main {

    static final String rutaSeresVivos = System.getProperty("user.home") + "/Desktop/SeresVivos.txt";;

    public static void main(String[] args) throws IOException {
        static final String rutaSeresVivos = System.getProperty("user.home") + "/Desktop/SeresVivos.txt";;

        public static void main(String[] args) {
            System.out.println("----------------------------------------------------------\n"+
                    "\t¡ATENCIÓN!: ESTO ES UNA PRE-ALFA.\n "+
                    "\tNO representa la calidad final del producto.\n"+
                    "----------------------------------------------------------\n\n\n"
            );
            comprobarArchivoSeresVivos();
            testTienda();
        comprobarArchivoSeresVivos();
    }






    //Empleados
    /*
        En el metodo main se pondra a disposicion del usuario un menu en el que se le
        daran las siguientes opciones:

            - Listar empleados : En este metodo se mostraran los empleados del acuario

            - Cambiar datos empleado : Añadir empleado/Eliminar empleado/Cambiar datos de un empleado

     */
    static void menuPrincipalEmpleados() throws IOException{
        final String rutaEmpleados="C:\\Users\\Developer\\Documents\\carpetaFicheros\\empleados.txt";
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
                case 1 -> lista(br);
                case 2 -> cambiarDatosEmpleado(rutaEmpleados);
            }
        }while(!fin);
    }

    static void lista(BufferedReader br) throws IOException{
        int i;
        String linea=" ";
        // Este for recorre el fichero 'empleados' y en caso de que no sean nulos los imprime
        // Cuando se encuentra una linea null se termina el for
        for(i=1;linea!=null;i++){
            linea=br.readLine();

            if(linea!=null){
                System.out.println();
                System.out.println("Empleado "+i+" : "+linea);
                System.out.println();
            }
        }
    }

    static void cambiarDatosEmpleado(String rutaEmpleados){
        System.out.println("Si desea cambiar los datos de un empleado puede hacerlo en el siguiente directorio: "+rutaEmpleados);
        System.out.println();
        System.out.println("Los datos deben de ser introducidos siguiendo el siguiente patron:");
        System.out.println("ID Nombre Apellidos DNI tipoTrabajo HorasTrabajo Sueldo Vacaciones");
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
                menuConsultasSerVivo();
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

    static void menuConsultasSerVivo() throws IOException {
        Teclado t = new Teclado();
        int op = 0;
        String valor = "";
        System.out.println("\n\tCONSULTAS SERES VIVOS\n\t====\n");
        System.out.println("1.- Por ID.");
        System.out.println("2.- Por especie.");
        System.out.println("3.- Por genero.");
        System.out.println("4.- Por fecha de compra.");
        System.out.println("5.- Por procedencia.");
        System.out.println("6.- Por estado.");
        System.out.println("7.- Por alimentacion.");
        System.out.println("8.- Volver.\n");
        do {
            System.out.print("\tTeclee opción ? ");
            op = t.leerInt();
        }while(op<1||op>8);
        if(op==8){
            menuPrincipalSerVivo();
        }else{
            System.out.print("\tTeclee valor a buscar ? ");
            valor = t.leerString();
            consultasSerVivo(op,valor);
        }
    }

    static void consultasSerVivo(int op,String valor) {
        int lineas=9;
        try{
            BufferedReader in=new BufferedReader(new FileReader(rutaSeresVivos));
            SerVivo serVivo = new SerVivo();
            switch (op){
                case 1:
                    for(int i=0;i<comprobarLineas();i+=lineas){
                        lineas=9;
                        lineas=serVivo.leerDatos(in);
                        if(serVivo.getId().equalsIgnoreCase(valor)){
                            serVivo.mostrarDatos();
                        }
                    }
                    break;
                case 2:
                    for(int i=0;i<comprobarLineas();i+=lineas){
                        lineas=9;
                        lineas=serVivo.leerDatos(in);
                        if(serVivo.getEspecie().equalsIgnoreCase(valor)){
                            serVivo.mostrarDatos();
                        }
                    }
                    break;
                case 3:
                    for(int i=0;i<comprobarLineas();i+=lineas){
                        lineas=9;
                        lineas=serVivo.leerDatos(in);
                        if(serVivo.getGenero().equalsIgnoreCase(valor)){
                            serVivo.mostrarDatos();
                        }
                    }
                    break;
                case 4:
                    for(int i=0;i<comprobarLineas();i+=lineas){
                        lineas=9;
                        lineas=serVivo.leerDatos(in);
                        if(serVivo.getFechaCompra().equalsIgnoreCase(valor)){
                            serVivo.mostrarDatos();
                        }
                    }
                    break;
                case 5:
                    for(int i=0;i<comprobarLineas();i+=lineas){
                        lineas=9;
                        lineas=serVivo.leerDatos(in);
                        if(serVivo.getProcedencia().equalsIgnoreCase(valor)){
                            serVivo.mostrarDatos();
                        }
                    }
                    break;
                case 6:
                    for(int i=0;i<comprobarLineas();i+=lineas){
                        lineas=9;
                        lineas=serVivo.leerDatos(in);
                        if(serVivo.getEstado().equalsIgnoreCase(valor)){
                            serVivo.mostrarDatos();
                        }
                    }
                    break;
                case 7:
                    for(int i=0;i<comprobarLineas();i+=lineas){
                        lineas=9;
                        lineas=serVivo.leerDatos(in);
                        if(serVivo.getAlimentacion().equalsIgnoreCase(valor)){
                            serVivo.mostrarDatos();
                        }
                    }
                    break;
            }
            in.close();
            menuConsultasSerVivo();
        }catch(IOException ioe) {}
    }

    static void listadosSerVivo(){
        int lineas=9;
        try {
            BufferedReader in=new BufferedReader(new FileReader(rutaSeresVivos));
            SerVivo serVivo = new SerVivo();
            for(int i=0;i<comprobarLineas();i+=lineas){
                lineas=9;
                lineas=serVivo.leerDatos(in);
                serVivo.mostrarDatos();
            }
            in.close();
            menuPrincipalSerVivo();
        }catch(IOException ioe) {}
    }

    static void infoAltasSerVivo(){
        System.out.println("Para realizar altas,bajas o modificaciones de algun ser vivo," +
                "debes acceder al archivo (" + rutaSeresVivos + ") ");
        System.out.println(" ");
        System.out.println("Debes seguir la siguiente estructura dentro del archivo para que los datos se guarden correctamente:\n" +
                "\tID (Ejemplo: a002)\n" +
                "\tEspecie (Ejemplo: Amphiprion akallopisos)\n" +
                "\tGenero (Macho/Hembra/Hermafrodita/Hermafrodita(Hembra)/Hermafrodita(Macho)\n" +
                "\tFecha compra (Ejemplo: 13/06/2009)\n" +
                "\tProcedencia (Ejemplo: tumundomarino.com)\n" +
                "\tComportamiento (Ejemplo: Tranquilo)\n" +
                "\tEstado (Normal/Enfermo/Gestación)\n" +
                "\tTratamiento (Ejemplo: CUPRACURE)\n" +
                "\tAlimentacion (Ejemplo: ARTEMIA ADULTA ENRIQUECIDA 10)\n" +
                "\tSimbiosis (True/False)\n" +
                "\tID Simbiosis (Ejemplo: a001)");
        System.out.println("Tratamiento e ID Simbiosis solo se utilizarán cuando el estado sea 'enfermo' o Simbiosis sea 'True'");
    }

    static int comprobarLineas(){
        String linea="";
        int cont = 0;
        try {
            BufferedReader in=new BufferedReader(new FileReader(rutaSeresVivos));
            while((linea = in.readLine())!=null) {
                cont++;
            }
            in.close();
        }catch(IOException ioe) {}
        return cont;
    }

    static void comprobarArchivoSeresVivos(){
        try {
            if(comprobarLineas()==0) {
                BufferedWriter out = new BufferedWriter(new FileWriter(rutaSeresVivos, false));
                out.write("a001");
                out.newLine();
                out.write("Amphiprion akallopisos");
                out.newLine();
                out.write("Macho");
                out.newLine();
                out.write("13/06/2009");
                out.newLine();
                out.write("tumundomarino.com");
                out.newLine();
                out.write("Tranquilo");
                out.newLine();
                out.write("Normal");
                out.newLine();
                out.write("ARTEMIA ADULTA ENRIQUECIDA 10");
                out.newLine();
                out.write("False");
                out.close();
            }
        }catch(IOException ioe) {}
    }
}

