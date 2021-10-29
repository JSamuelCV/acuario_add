package com.jmirallesr;

import com.jmirallesr.SeresVivos.MetodosSerVivo;
import com.jmirallesr.productos.Comida;
import com.jmirallesr.productos.Peluche;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class Main {


    static final String rutaCliente ="data\\clientes.dat";
    static final String rutaEmpleados = "data\\Empleados.txt";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        System.out.println("----------------------------------------------------------\n"+
                "\t¡ATENCIÓN!: ESTO ES UNA PRE-ALFA.\n "+
                "\tNO representa la calidad final del producto.\n"+
                "----------------------------------------------------------\n\n\n"
        );
        MetodosSerVivo.comprobarArchivoSeresVivos();
        mainTestMenu();
    }

    static void mainTestMenu() throws IOException, ParserConfigurationException, SAXException {
        Teclado t = new Teclado();
        boolean continuar=true;
        do {
            System.out.println("\n\nIntroduzca la opción que desea testear:\n"
                    +"1. Gestión de la tienda\n"
                    +"2. Clientes\n"
                    +"3. Empleados\n"
                    +"4. SeresVivos\n"
                    +"5. SALIR\n"
            );
            switch (Read.readInt()) {
                case 1 -> testTienda();
                case 2 -> menuClientes(t);
                case 3 -> menuPrincipalEmpleados();
                case 4 -> menuPrincipalSerVivo();
                case 5 -> continuar = false;
            }
        } while(continuar);
    }

    /* INICIO GESTIÓN DE LA TIENDA + PRODUCTOS */

    static void testTienda() {
        System.out.println("Bienvenido a la tienda del acuario:\n"+
                "El programa simula la gestión de la tienda del acuario.\n"+
                "Los artículos sólo se pueden vender si están disponibles en la tienda\n"+
                "El usuario puede:\n"+
                "\t Comprar productos de los existentes.\n"+
                "\t Añadir nuevos productos a la cesta.\n"+
                "\t Consultar el importe de la cuenta.");

        boolean continuar=true;
        int lecturaProducto, lecturaCantidad; //Variables para seleccionar el producto y la cantidad que se quiere comprar

        //Se instancian y cargan los productos
        Producto peluche1 = new Peluche("Pez Globo", 16.43, 10, true, "relleno");
        Producto peluche2 = new Peluche("Tiburón", 9.99, 12, true, "rígido");
        Producto chocolateBlanco = new Comida("Chocolate Edición Acuario", 4.55, 4, true, true);
        Producto golosinaMedusa = new Comida("Medusa Golosa", 0.45, 200, true, true);

        //Creamos el array "catálogo" para contener los productos. Su dimensión viene del número de veces que se instancia el constructor Producto
        Producto[] catalogo = new Producto[Producto.dimensionArray];
        //Se crea el objeto gestión para trabajar (mostrar y vender productos, y mostrar caja)
        GestionTienda gestion = new GestionTienda();

        catalogo[0] = peluche1;
        catalogo[1] = peluche2;
        catalogo[2] = chocolateBlanco;
        catalogo[3] = golosinaMedusa;

        do {
            System.out.println("\n\nIntroduzca la opción que desea realizar:\n"
                    +"1. Mostrar productos\n"
                    +"2. Vender productos\n"
                    +"3. Mostrar caja\n"
                    +"SALIR --> Pulse cualquier otro número\n"
            );
            switch (Read.readInt()) {
                case 1 -> gestion.mostrarProductos(catalogo);
                case 2 -> {
                    System.out.println("¿Que producto desea comprar?");
                    gestion.mostrarNombreProductos(catalogo);
                    lecturaProducto = Read.readInt();
                    System.out.println("¿Cuánta cantidad desea vender?");
                    lecturaCantidad = Read.readInt();
                    //Se carga el producto y la cantidad solicitada por el usuario
                    gestion.venderProducto(catalogo, lecturaProducto, lecturaCantidad);
                }
                case 3 -> System.out.println(gestion.mostrarCaja() + " €");
                default -> continuar = false;
            }

        } while(continuar);
    }

    /* FINAL DE LA TIENDA */



    /* INICIO EMPLEADOS */

    /*
        En el metodo main se pondra a disposicion del usuario un menu en el que se le
        daran las siguientes opciones:

            - Listar empleados : En este metodo se mostraran los empleados del acuario

            - Cambiar datos empleado : Añadir empleado/Eliminar empleado/Cambiar datos de un empleado

     */
    static void menuPrincipalEmpleados() throws IOException{
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
            }while(opcionMenuEmpleados<0 || opcionMenuEmpleados>2);

            switch (opcionMenuEmpleados){
                case 0 -> fin=true;
                case 1 -> listaEmpledos(br);
                case 2 -> cambiarDatosEmpleado(rutaEmpleados);
            }
        }while(!fin);
    }

    static void listaEmpledos(BufferedReader br) throws IOException{
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

    /* FINAL EMPLEADOS */


    /* INICIO SERVIVO */

    static void menuPrincipalSerVivo() throws IOException, ParserConfigurationException, SAXException {
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
                MetodosSerVivo.listadosSerVivo();
                break;
            case 3:
                MetodosSerVivo.infoAltasSerVivo();
                break;
            default:
                if(op!=4)
                    System.out.println("Valor introducido no corresponde con ninguna opcion");
                break;
        }
    }

    static void menuConsultasSerVivo() throws IOException, ParserConfigurationException, SAXException {
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
            MetodosSerVivo.consultasSerVivo(op,valor);
        }
    }

    /* FINAL SERVIVO */

    /* INICIO CLIENTES */

    static void menuClientes(Teclado t)throws IOException {

        int opcion;
        do{
            do{
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("MENU CLIENTES");
                System.out.println();
                System.out.println("1: Consultar datos entrada cliente");
                System.out.println("2: Consultar datos salida cliente");
                System.out.println("3: Consultar la valoracion de un cliente");
                System.out.println("4: Consultar la informacion personal de un cliente");
                System.out.println("5: Salir");
                System.out.println();

                System.out.println("Seleccione una opcion (5 para terminar) : ");
                opcion=t.leerInt();
            }while(opcion<1 || opcion>8);
            switch(opcion) {

                case 1:
                    entradaCliente();
                    break;
                case 2:
                    salidaCliente();
                    break;
                case 3:
                    valoracionCliente();
                    break;
                case 4:
                    mostrarCliente();
                    break;
                case 5:
                    System.out.print("Has elegido la opcion salir");
                    break;
            }
        }while(opcion!=5);
    }

    static void entradaCliente() throws IOException{
        Teclado t= new Teclado();
        Cliente c= new Cliente(0,"", "", "", "","", 0, "", "",0);
        int numVisitante;
        RandomAccessFile fich = new RandomAccessFile(rutaCliente,"rw");
        do {
            System.out.println("Teclee el numero de visitante de la persona a consultar: ");
            numVisitante= t.leerInt();
        }while(numVisitante==Integer.MIN_VALUE);
        fich.seek(numVisitante * c.tamano());
        c.leerDeArchivo(fich);
        if(c.getNumVisitante()!=0)
            c.mostrarDatosEntrada();
        else
            System.out.println("El registro buscado no existe.");
        fich.close();
    }

    static void salidaCliente() throws IOException{
        Teclado t= new Teclado();
        Cliente c = new Cliente(0,"", "", "", "","", 0, "", "",0);
        int numVisitante;
        RandomAccessFile fich = new RandomAccessFile(rutaCliente,"rw");
        do {
            System.out.println("Teclee el numero de visitante de la persona a consultar: ");
            numVisitante= t.leerInt();
        }while(numVisitante==Integer.MIN_VALUE);
        fich.seek(numVisitante * c.tamano());
        c.leerDeArchivo(fich);
        if(c.getNumVisitante()!=0)
            c.mostrarDatosSalida();
        else
            System.out.println("El registro buscado no existe.");
        fich.close();
    }
    static void mostrarCliente() throws IOException{
        Teclado t= new Teclado();
        Cliente c= new Cliente(0,"", "", "", "","", 0, "", "",0);
        int numVisitante;
        RandomAccessFile fich = new RandomAccessFile(rutaCliente,"rw");
        do {
            System.out.println("Teclee el numero de visitante de la persona a consultar: ");
            numVisitante= t.leerInt();
        }while(numVisitante==Integer.MIN_VALUE);
        fich.seek(numVisitante * c.tamano());
        c.leerDeArchivo(fich);
        if(c.getNumVisitante()!=0)
            c.mostrarDatos();
        else
            System.out.println("El registro buscado no existe.");
        fich.close();
    }
    static void valoracionCliente()throws IOException{
        Teclado t= new Teclado();
        int opcion;

        do{
            do{
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("  Elige una opcion");
                System.out.println();
                System.out.println("1: Valoracion de un cliente determinado");
                System.out.println("2: Media de las valoraciones(de todos los clientes)");
                System.out.println("3: Salir");
                System.out.println();

                System.out.println("Seleccione una opcion (3 para terminar) : ");
                opcion=t.leerInt();
            }while(opcion<1 || opcion>3);
            switch(opcion) {

                case 1:
                    valoracionIndividual();
                    break;
                case 2:
                    valoracionTotal();
                    break;
                case 3:
                    System.out.print("Has elegido la opcion salir");
                    break;
            }
        }while(opcion!=3);
    }
    static void valoracionIndividual()throws IOException{
        Teclado t= new Teclado();
        Cliente c= new Cliente(0,"", "", "", "","", 0, "", "",0);
        int numVisitante;
        RandomAccessFile fich = new RandomAccessFile(rutaCliente,"rw");
        do {
            System.out.println("Teclee el numero de visitante de la persona a consultar: ");
            numVisitante= t.leerInt();
        }while(numVisitante==Integer.MIN_VALUE);
        fich.seek(numVisitante * c.tamano());
        c.leerDeArchivo(fich);
        if(c.getNumVisitante()!=0)
            c.mostrarDatosValoracion();
        else
            System.out.println("El registro buscado no existe.");
        fich.close();
    }

    static void valoracionTotal() throws IOException {
        int i=0, totalValoracion=0;
        RandomAccessFile fich = new RandomAccessFile(rutaCliente,"r");
        do {
            i++;
            Cliente c = new Cliente (0,"", "", "", "","", 0, "", "",0);
            fich.seek(i * c.tamano());
            if(c.leerDeArchivo(fich)) {
                break;
            }
            totalValoracion += c.getvaloracion();
        } while(true);
        System.out.println("Media de valoraciones: "+(totalValoracion/i));
    }

    /* FINAL CLIENTES */
}