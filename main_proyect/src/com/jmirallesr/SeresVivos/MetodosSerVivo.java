package com.jmirallesr.SeresVivos;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.List;

public class MetodosSerVivo {

    static final String rutaSeresVivos = System.getProperty("user.home") + "/Desktop/SeresVivos.xml";

    static void consultasSerVivo() {

    }

    public static void listadosSerVivo() throws ParserConfigurationException, SAXException, IOException{
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

    public static void infoAltasSerVivo(){
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

    public static void comprobarArchivoSeresVivos(){
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
}
