package com.jmirallesr;

import com.jmirallesr.productos.Comida;
import com.jmirallesr.productos.Peluche;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.List;

public class Main {

    static final String rutaSeresVivos = System.getProperty("user.home") + "/Desktop/SeresVivos.xml";

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        System.out.println("----------------------------------------------------------\n"+
                "\t¡ATENCIÓN!: ESTO ES UNA PRE-ALFA.\n "+
                "\tNO representa la calidad final del producto.\n"+
                "----------------------------------------------------------\n\n\n"
        );
        comprobarArchivoSeresVivos();
        testTienda();
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
            //consultasSerVivo()
        }
    }

    static void consultasSerVivo() {

    }

    static void listadosSerVivo() throws ParserConfigurationException, SAXException, IOException{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        SerVivoHandler handler = new SerVivoHandler();
        saxParser.parse(rutaSeresVivos, handler);
        List<SerVivo> list = handler.getSeres();
        System.out.println("---------------------------------------------------------------------------------------------");
        for (SerVivo serVivo : list) {
            if(serVivo.getId()!=null){
                System.out.println("Id: " + serVivo.getId());
                if(serVivo.getEspecie()!=null){
                    System.out.println("Especie: " + serVivo.getEspecie());
                }
                if(serVivo.getGenero()!=null){
                    if(serVivo.getEstado().equalsIgnoreCase("Macho")||serVivo.getEstado().equalsIgnoreCase("Hembra")||serVivo.getEstado().equalsIgnoreCase("Hermafrodita")||serVivo.getEstado().equalsIgnoreCase("Hermafrodita(Macho)")||serVivo.getEstado().equalsIgnoreCase("Hermafrodita(Hembra)")) {
                        System.out.println("Genero: " + serVivo.getGenero());
                    }
                }
                if(serVivo.getFechaCompra()!=null){
                    System.out.println("Fecha de compra: " + serVivo.getFechaCompra());
                }
                if(serVivo.getProcedencia()!=null){
                    System.out.println("Procedencia: " + serVivo.getProcedencia());
                }
                if(serVivo.getComportamiento()!=null){
                    System.out.println("Comportamiento: " + serVivo.getComportamiento());
                }
                if(serVivo.getAlimentacion()!=null){
                    System.out.println("Alimentacion: " + serVivo.getAlimentacion());
                }
                if(serVivo.getEstado()!=null){
                    if(serVivo.getEstado().equalsIgnoreCase("Normal")||serVivo.getEstado().equalsIgnoreCase("Enfermo")||serVivo.getEstado().equalsIgnoreCase("Gestacion")){
                        System.out.println("Estado: " + serVivo.getEstado());
                        if(serVivo.getEstado().equalsIgnoreCase("Enfermo")&&serVivo.getTratamiento()!=null){
                            System.out.println("Tratamiento: " + serVivo.getTratamiento());
                        }
                    }
                }
                if(serVivo.getSimbiosis()!=null){
                    if(serVivo.getSimbiosis().equalsIgnoreCase("True")||serVivo.getSimbiosis().equalsIgnoreCase("False")){
                        System.out.println("Simbiosis: " + serVivo.getSimbiosis());
                        if(serVivo.getSimbiosis().equalsIgnoreCase("True")&&serVivo.getIdSimbiosis()!=null){
                            System.out.println("Id Simbiosis: " + serVivo.getIdSimbiosis());
                        }
                    }
                }
                System.out.println("---------------------------------------------------------------------------------------------");
            }
        }
    }

    static void infoAltasSerVivo(){
        System.out.println("Para realizar altas,bajas o modificaciones de algun ser vivo," +
                "debes acceder al archivo (" + System.getProperty("user.home") + "\\Desktop\\SeresVivos.xml)");
        System.out.println(" ");
        System.out.println("Debes seguir la siguiente estructura dentro del archivo para cada ser vivo:\n" +
                "\t<ser_vivo>\n" +
                "\t\t<id>(String)</id>\n" +
                "\t\t<especie>(String)</especie>\n" +
                "\t\t<genero>(Macho/Hembra/Hermafrodita/Hermafrodita(Hembra)/Hermafrodita(Macho))</genero>\n" +
                "\t\t<fecha_compra>(String)</fecha_compra>\n" +
                "\t\t<procedencia>(String)</procedencia>\n" +
                "\t\t<comportamiento>(String)</comportamiento>\n" +
                "\t\t<alimentacion>(String)</alimentacion>\n" +
                "\t\t<estado>(Normal/Gestacion/Enfermo)</estado>\n" +
                "\t\t<tratamiento>(String)</tratamiento>\n" +
                "\t\t<simbiosis>(True/False)</simbiosis>\n" +
                "\t\t<id_simbiosis>(String)</id_simbiosis>\n" +
                "\t</ser_vivo>");
        System.out.println(" ");
        System.out.println("La unica etiqueta obligatoria por ser vivo es <id>, el resto se pueden omitir, pero cuanto mas se complete mejor.");
        System.out.println("Tratamiento e ID Simbiosis solo se mostrarán cuando el estado sea 'enfermo' y Simbiosis sea 'True' respectivamente");
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
                out.write("<?xml version=\"1.0\"?>");
                out.newLine();
                out.write("<seres_vivos>");
                out.newLine();
                out.write("\t<ser_vivo>");
                out.newLine();
                out.write("\t\t<id>a001</id>");
                out.newLine();
                out.write("\t\t<especie>Amphiprion akallopisos</especie>");
                out.newLine();
                out.write("\t\t<genero>Macho</genero>");
                out.newLine();
                out.write("\t\t<fecha_compra>13/06/2009</fecha_compra>");
                out.newLine();
                out.write("\t\t<procedencia>tumundomarino.com</procedencia>");
                out.newLine();
                out.write("\t\t<comportamiento>Tranquilo</comportamiento>");
                out.newLine();
                out.write("\t\t<alimentacion>ARTEMIA ADULTA ENRIQUECIDA 10</alimentacion>");
                out.newLine();
                out.write("\t\t<estado>Enfermo</estado>");
                out.newLine();
                out.write("\t\t<tratamiento>Cobre 5ml</tratamiento>");
                out.newLine();
                out.write("\t\t<simbiosis>True</simbiosis>");
                out.newLine();
                out.write("\t\t<id_simbiosis>a002</id_simbiosis>");
                out.newLine();
                out.write("\t</ser_vivo>");
                out.newLine();
                out.write("\t<ser_vivo>");
                out.newLine();
                out.write("\t\t<id>a002</id>");
                out.newLine();
                out.write("\t\t<especie>Amphiprion akallopisos</especie>");
                out.newLine();
                out.write("\t\t<genero>Hembra</genero>");
                out.newLine();
                out.write("\t\t<fecha_compra>13/06/2009</fecha_compra>");
                out.newLine();
                out.write("\t\t<procedencia>tumundomarino.com</procedencia>");
                out.newLine();
                out.write("\t\t<comportamiento>Agresiva cuando se invade su territorio</comportamiento>");
                out.newLine();
                out.write("\t\t<alimentacion>ARTEMIA ADULTA ENRIQUECIDA 10</alimentacion>");
                out.newLine();
                out.write("\t\t<estado>Gestacion</estado>");
                out.newLine();
                out.write("\t\t<simbiosis>True</simbiosis>");
                out.newLine();
                out.write("\t\t<id_simbiosis>a001</id_simbiosis>");
                out.newLine();
                out.write("\t</ser_vivo>");
                out.newLine();
                out.write("\t<ser_vivo>");
                out.newLine();
                out.write("\t\t<id>a003</id>");
                out.newLine();
                out.write("\t\t<especie>Amphiprion akallopisos</especie>");
                out.newLine();
                out.write("\t\t<genero>Macho</genero>");
                out.newLine();
                out.write("\t\t<fecha_compra>13/06/2009</fecha_compra>");
                out.newLine();
                out.write("\t\t<procedencia>tumundomarino.com</procedencia>");
                out.newLine();
                out.write("\t\t<comportamiento>Tranquilo</comportamiento>");
                out.newLine();
                out.write("\t\t<alimentacion>ARTEMIA ADULTA ENRIQUECIDA 10</alimentacion>");
                out.newLine();
                out.write("\t\t<estado>Normal</estado>");
                out.newLine();
                out.write("\t\t<simbiosis>False</simbiosis>");
                out.newLine();
                out.write("\t</ser_vivo>");
                out.newLine();
                out.write("</seres_vivos>");
                out.close();
            }
        }catch(IOException ioe) {}
    }

    /* FINAL SERVIVO */
}

