package com.ilerna;

import java.util.ArrayList;

public class Procesadordepedidos {

    public static void main(String[] args) {
        System.out.println("Procesador de pedidos");

        import java.util.ArrayList;
 
 
/**
 * Código inicial para la práctica de refactorización.
 * Criterios: Nombres genéricos, números mágicos y métodos con demasiadas responsabilidades.
 */
public class ProcesadorPedidos {
 
 
    public double procesar(ArrayList<String> a, ArrayList<Double> b) {
        double t = 0;
        
        // Sumar precios de la lista
        for (int i = 0; i < b.size(); i++) {
            System.out.println("Añadiendo producto: " + a.get(i));
            t = t + b.get(i);
        }
        
        // Lógica de descuento (Magic Number 100 y 0.10)
        if (t > 100) {
            System.out.println("Descuento aplicado.");
            t = t - (t * 0.10); 
        }
        
        // Cálculo de impuestos (Magic Number 0.21)
        double res = t + (t * 0.21);
        
        // Gastos de envío (Magic Number 500 y 15.95)
        if (res < 500) {
            res = res + 15.95;
        }
        
        return res;
    }
}
    }

