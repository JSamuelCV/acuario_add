package me.tau;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SerVivoHandler extends DefaultHandler {

    private Boolean id = false,especie = false,genero= false,
            fechaCompra= false,procedencia= false,comportamiento= false,
            estado= false,alimentacion= false,idSimbiosis= false,
            tratamiento= false,simbiosis= false;

    private SerVivo actual = new SerVivo();
    private List<SerVivo> seres = new ArrayList<>();

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals(ElementoSerVivo.ID.getEtiqueta())) {
            id = true;
        }
        if (qName.equals(ElementoSerVivo.ESPECIE.getEtiqueta())) {
            especie = true;
        }
        if (qName.equals(ElementoSerVivo.GENERO.getEtiqueta())) {
            genero = true;
        }
        if (qName.equals(ElementoSerVivo.FECHA_COMPRA.getEtiqueta())) {
            fechaCompra = true;
        }
        if (qName.equals(ElementoSerVivo.PROCEDENCIA.getEtiqueta())) {
            procedencia = true;
        }
        if (qName.equals(ElementoSerVivo.COMPORTAMIENTO.getEtiqueta())) {
            comportamiento = true;
        }
        if (qName.equals(ElementoSerVivo.ALIMENTACION.getEtiqueta())) {
            alimentacion = true;
        }
        if (qName.equals(ElementoSerVivo.ESTADO.getEtiqueta())) {
            estado = true;
        }
        if (qName.equals(ElementoSerVivo.TRATAMIENTO.getEtiqueta())) {
            tratamiento = true;
        }
        if (qName.equals(ElementoSerVivo.SIMBIOSIS.getEtiqueta())) {
            simbiosis = true;
        }
        if (qName.equals(ElementoSerVivo.ID_SIMBIOSIS.getEtiqueta())) {
            idSimbiosis = true;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (id) {
            actual.setId(new String(ch, start, length));
            id = false;
        }
        if (especie) {
            actual.setEspecie(new String(ch, start, length));
            especie = false;
        }
        if (genero) {
            actual.setGenero(new String(ch, start, length));
            genero = false;
        }
        if (fechaCompra) {
            actual.setFechaCompra(new String(ch, start, length));
            fechaCompra = false;
        }
        if (procedencia) {
            actual.setProcedencia(new String(ch, start, length));
            procedencia = false;
        }
        if (comportamiento) {
            actual.setComportamiento(new String(ch, start, length));
            comportamiento = false;
        }
        if (alimentacion) {
            actual.setAlimentacion(new String(ch, start, length));
            alimentacion = false;
        }
        if (estado) {
            actual.setEstado(new String(ch, start, length));
            estado = false;
        }
        if (tratamiento) {
            actual.setTratamiento(new String(ch, start, length));
            tratamiento = false;
        }
        if (simbiosis) {
            actual.setSimbiosis(new String(ch, start, length));
            simbiosis = false;
        }
        if (idSimbiosis) {
            actual.setIdSimbiosis(new String(ch, start, length));
            idSimbiosis = false;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(ElementoSerVivo.SER_VIVO.getEtiqueta())) {
            seres.add(actual);
            actual = new SerVivo();
        }
    }

    public List<SerVivo> getSeres() {
        return seres;
    }
}
