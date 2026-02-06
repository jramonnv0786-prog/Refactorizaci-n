package com.ilerna;

public class ProcesadordepedidosTest {

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
 
 
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

}
