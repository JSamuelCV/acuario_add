package com.jmirallesr;

import com.jmirallesr.SeresVivos.MetodosSerVivo;
import com.jmirallesr.productos.Comida;
import com.jmirallesr.productos.Peluche;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class Main {
    
    static final String rutaEmpleado = System.getProperty("user.home") + "/Escritorio/Empleados.txt";
    static final String rutaCliente = System.getProperty("user.home") + "/Escritorio/Clientes.txt";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        System.out.println("----------------------------------------------------------\n"+
                "\t¡ATENCIÓN!: ESTO ES UNA PRE-ALFA.\n "+
                "\tNO representa la calidad final del producto.\n"+
                "----------------------------------------------------------\n\n\n"
        );
        MetodosSerVivo.comprobarArchivoSeresVivos();
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
        Producto catalogo[] = new Producto[Producto.dimensionArray];
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
                case 1:
                    gestion.mostrarProductos(catalogo);
                    break;
                case 2:
                    System.out.println("¿Que producto desea comprar?");
                    gestion.mostrarNombreProductos(catalogo);
                    lecturaProducto=Read.readInt();
                    System.out.println("¿Cuánta cantidad desea vender?");
                    lecturaCantidad=Read.readInt();
                    //Se carga el producto y la cantidad solicitada por el usuario
                    gestion.venderProducto(catalogo, lecturaProducto, lecturaCantidad);
                    break;
                case 3:
                    System.out.println(gestion.mostrarCaja() +" €");
                    break;
                default:
                    continuar=false;
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
        FileReader lector = new FileReader (rutaEmpleado);
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
                case 2 -> cambiarDatosEmpleado();
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

    static void cambiarDatosEmpleado(){
        System.out.println("Si desea cambiar los datos de un empleado puede hacerlo en el siguiente directorio: "+rutaEmpleado);
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

    static void menuClientes(Teclado entrada)throws IOException {

        int opcion;
        do{
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("MENU CLIENTES");
            System.out.println();
            System.out.println("1: Consultar datos entrada cliente");
            System.out.println("2: Consultar datos salida cliente");
            System.out.println("3: Consultar la valoracion de un cliente");
            System.out.println("4: Estadistica");
            System.out.println("5: Consultar info personal cliente");
            System.out.println("6: Salir");
            System.out.println();

            System.out.println("Seleccione una opcion (5 para terminar) : ");
            opcion=entrada.leerInt();
        }while(opcion<1 || opcion>8);
        switch(opcion){
            case 7:
                Altas();
                break;
            case 8:
                Bajas();
                break;
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
                estadisticaCliente();
                break;

            case 5:
                datosCliente();
                break;
            case 6:
                System.out.print("Has elegido la opcion salir");
                break;
            default:

                break;
        }while(opcion!=6);
    }
    static void Altas()throws IOException{
        Cliente cvacio = new Cliente(0,"", "", "", "","", 0, "", "",0), c = new Cliente();
        Teclado t=new Teclado();
        String nombre, apellidos, dni, correoElectronico, nombreResponsable, horaEntrada, horaSalida;
        int edad, valoracion, numVisitante;
        char confirmar=' ';
        RandomAccessFile fich = new RandomAccessFile(rutaCliente+" clientes.dat","rw");
        System.out.println("\n\tNuevo cliente\n\t=====\n");
        do{
            System.out.print("Teclear numVisitante (0 = Fin)......: ");
            numVisitante=t.leerInt();
        }while(numVisitante == Integer.MIN_VALUE);
        while (numVisitante != 0) {
            fich.seek(numVisitante*cvacio.tamano());
            c.leerDeArchivo(fich);
            if(c.getNumVisitante() !=0 && numVisitante*cvacio.tamano() <fich.length())
                System.out.println("La persona ya estaba en la base de datos.");
            else{
                do{
                    System.out.println("Introduce nombre ");
                    nombre=t.leerString();
                }while(nombre.length()>30);
                do{
                    System.out.println("Introduce apellidos ");
                    apellidos=t.leerString();
                }while(apellidos.length()>50);
                do{
                    System.out.println("Introduce DNI ");
                    dni=t.leerString();
                }while(dni.length()>9);
                do{
                    System.out.println("Introduce correo electronico ");
                    correoElectronico=t.leerString();
                }while(correoElectronico.length()>40);
                do{
                    System.out.println("Introduce nombre de la persona encargada ");
                    nombreResponsable=t.leerString();
                }while(nombreResponsable.length()>30);

                do{
                    System.out.println("Introduce edad ");
                    edad=t.leerInt();
                }while(edad == Integer.MIN_VALUE);
                do{
                    System.out.println("Introduce la hora de entrada ");
                    horaEntrada=t.leerString();
                }while(horaEntrada.length()!=5);
                do{
                    System.out.println("Introduce la hora de salida ");
                    horaSalida=t.leerString();
                }while(horaSalida.length()!=5);
                do{
                    System.out.println("Introduce valoracion(1-5)");
                    valoracion=t.leerInt();
                }while(edad == Integer.MIN_VALUE && valoracion <5 && valoracion >0);
                do {
                    System.out.print("\nConfirmar el alta(s/n)? ");
                    confirmar = Character.toLowerCase(t.leerChar());
                }while(confirmar != 's' && confirmar != 'n');
                if(confirmar == 's') {
                    c = new Cliente (numVisitante,nombre,apellidos,dni,correoElectronico,nombreResponsable,edad,horaEntrada,horaSalida,valoracion);
                    if (numVisitante * c.tamano()>fich.length())
                        fich.seek(fich.length());
                    while(numVisitante*c.tamano()>fich.length())
                        cvacio.escribirEnArchivo(fich);
                    fich.seek(numVisitante * c.tamano());
                    c.escribirEnArchivo(fich);
                }

            }
            do{
                System.out.print("Teclear código (0 = Fin)......: ");
                numVisitante=t.leerInt();
            }while(numVisitante == Integer.MIN_VALUE);
        }fich.close();


    }
    static void Bajas()throws IOException{
        Cliente c = new Cliente(0,"", "", "", "","", 0, "", "",0);
        Teclado t = new Teclado();
        int codigo;
        String opcion;
        RandomAccessFile fich = new RandomAccessFile(rutaCliente+" clientes.dat","r");
        System.out.println("\n\tBAJAS\n\t=====\n");
        do{
            System.out.print("Teclee el código a dar de baja...: ");
            codigo = t.leerInt();
        }while(codigo==Integer.MIN_VALUE);
        fich.seek(codigo * c.tamano());
        c.leerDeArchivo(fich);
        if (c.getNumVisitante() != 0){
            c.mostrarDatos();
            System.out.println();
            do{
                System.out.print("\nConfirma la baja (s/n)? ");
                opcion = t.leerString();
            }while(!opcion.equalsIgnoreCase("s") && !opcion.equalsIgnoreCase("n"));
            if (opcion.equalsIgnoreCase("s")){
                c = new Cliente(0,"", "", "", "","", 0, "", "",0);
                fich.seek(codigo * c.tamano());
                c.escribirEnArchivo(fich);
            }
        }
        else{
            System.out.println("\nEl registro de dicha persona no existe.\n");
        }
        fich.close();
    }

    static void entradaCliente() throws IOException{
        Teclado t= new Teclado();
        Cliente c= new Cliente(0,"", "", "", "","", 0, "", "",0);
        int numVisitante;
        RandomAccessFile fich = new RandomAccessFile(rutaCliente+" clientes.dat","rw");
        do {
            System.out.println("Teclee el numero de visitante de la persona a consultar: ");
            numVisitante= t.leerInt();
        }while(numVisitante==Integer.MIN_VALUE);
        fich.seek(numVisitante * c.tamano());
        c.leerDeArchivo(fich);
        if(c.getNumVisitante()!=0)
            c.mostrarDatosEntrada();
        else
            System.out.println("El registro buscado no existe.)");
        fich.close();
    }

    static void salidaCliente() throws IOException{
        Teclado t= new Teclado();
        Cliente c = new Cliente(0,"", "", "", "","", 0, "", "",0);
        int numVisitante;
        RandomAccessFile fich = new RandomAccessFile(rutaCliente+" clientes.dat","rw");
        do {
            System.out.println("Teclee el numero de visitante de la persona a consultar: ");
            numVisitante= t.leerInt();
        }while(numVisitante==Integer.MIN_VALUE);
        fich.seek(numVisitante * c.tamano());
        c.leerDeArchivo(fich);
        if(c.getNumVisitante()!=0)
            c.mostrarDatosSalida();
        else
            System.out.println("El registro buscado no existe.)");
        fich.close();
    }
    static void datosCliente() throws IOException{
        Teclado t= new Teclado();
        Cliente c= new Cliente(0,"", "", "", "","", 0, "", "",0);
        int numVisitante;
        RandomAccessFile fich = new RandomAccessFile(rutaCliente+" clientes.dat","rw");
        do {
            System.out.println("Teclee el numero de visitante de la persona a consultar: ");
            numVisitante= t.leerInt();
        }while(numVisitante==Integer.MIN_VALUE);
        fich.seek(numVisitante * c.tamano());
        c.leerDeArchivo(fich);
        if(c.getNumVisitante()!=0)
            c.mostrarDatos();
        else
            System.out.println("El registro buscado no existe.)");
        fich.close();
    }
    static void valoracionCliente(){

    }
    static void estadisticaCliente(){

    }

    /* FINAL CLIENTES */
}