package com.ilerna;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProcesadorPedidosTest {

    @Test
    public void testProcesarPedidoConDescuento() {
        ProcesadorPedidos proc = new ProcesadorPedidos();
        ArrayList<String> nombres = new ArrayList<>(Arrays.asList("Monitor", "Teclado"));
        ArrayList<Double> precios = new ArrayList<>(Arrays.asList(150.0, 50.0));

        // Cálculos esperados:
        // 200 total -> -10% desc = 180 -> +21% IVA = 217.8 -> +15.95 envío = 233.75
        double resultado = proc.procesar(nombres, precios);
        assertEquals(233.75, resultado, 0.01);
    }
}
