package com.jmirallesr;

import java.io.*;

public class Read {

    public static String data() {
        String sdato = " ";
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader flujoE = new BufferedReader(isr);
            sdato = flujoE.readLine();
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
        return sdato;

    }

    public static int dataInt() {
        return Integer.parseInt(data());
    }

    public static float datoFloat() {
        return Float.parseFloat(data());
    }

    // Leer un char por teclado

    public static char dataChar() {
        char c = ' ';
        try {
            java.io.BufferedInputStream b = new BufferedInputStream(System.in);
            c = (char) b.read();
        } catch (IOException e) {
            System.out.println("Error al leer");
            e.printStackTrace();
        }
        return c;
    }

    public static long dataLong() {
        return Long.parseLong(data());
    }
}
