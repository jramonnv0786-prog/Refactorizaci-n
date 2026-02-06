package com.ilerna;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Código inicial corregido (sin caracteres invisibles).
 */
public class ProcesadorPedidos {
    private static final Logger logger = Logger.getLogger(ProcesadorPedidos.class.getName());

    public static void main(String[] args) {
        ArrayList<String> nombresproductos = new ArrayList<>();
        ArrayList<Double> precios = new ArrayList<>();

        nombresproductos.add("Camiseta");
        precios.add(20.0);

        nombresproductos.add("Pantalón");
        precios.add(40.0);

        nombresproductos.add("Zapatos");
        precios.add(60.0);

        ProcesadorPedidos procesador = new ProcesadorPedidos();
        double total = procesador.procesar(nombresproductos, precios);
        logger.info("Total a pagar: " + total);
    }

    public double procesar(ArrayList<String> nombresproductos, ArrayList<Double> precios) {
        double subtotal = 0;

        // Sumar precios de la lista
        for (int i = 0; i < precios.size(); i++) {
            logger.info("Añadiendo producto: " + nombresproductos.get(i));
            subtotal = subtotal + precios.get(i);
        }

        // Lógica de descuento
        if (subtotal > 100) {
            logger.info("Descuento aplicado.");
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
