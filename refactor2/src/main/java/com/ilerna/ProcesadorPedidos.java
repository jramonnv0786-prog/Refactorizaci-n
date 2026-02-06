package com.ilerna;

import java.util.ArrayList;

/**
 * Código inicial corregido (sin caracteres invisibles).
 */
public class ProcesadorPedidos {

    public double procesar(ArrayList<String> nombresproductos, ArrayList<Double> precios) {
        double subtotal = 0;

        // Sumar precios de la lista
        for (int i = 0; i < precios.size(); i++) {
            System.out.println("Añadiendo producto: " + nombresproductos.get(i));
            subtotal = subtotal + precios.get(i);
        }

        // Lógica de descuento
        if (subtotal > 100) {
            System.out.println("Descuento aplicado.");
            subtotal = subtotal - (subtotal * 0.10);
        }

        // Cálculo de impuestos
        double res = subtotal + (subtotal * 0.21);

        // Gastos de envío
        if (res < 500) {
            res = res + 15.95;
        }

        return res;
    }
}
