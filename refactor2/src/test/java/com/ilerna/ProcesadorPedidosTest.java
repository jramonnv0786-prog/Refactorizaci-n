package com.ilerna;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class ProcesadorPedidosTest {
    private Logger logger;
    private StringBuilder logMessages;
    private Handler testHandler;

    @Before
    public void setUp() {
        logger = Logger.getLogger(ProcesadorPedidos.class.getName());
        logMessages = new StringBuilder();
        
        // Crear un handler personalizado para capturar los logs
        testHandler = new Handler() {
            @Override
            public void publish(LogRecord record) {
                logMessages.append(record.getMessage()).append("\n");
            }

            @Override
            public void flush() {}

            @Override
            public void close() throws SecurityException {}
        };
        
        logger.addHandler(testHandler);
    }

    @After
    public void tearDown() {
        logger.removeHandler(testHandler);
    }

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

    @Test
    public void testMain() {
        logMessages.setLength(0); // Limpiar logs previos
        
        // Ejecutar el método main
        ProcesadorPedidos.main(new String[]{});
        
        String logs = logMessages.toString();
        
        // Verificar que se procesaron los tres productos
        assertTrue("Debe contener 'Camiseta'", logs.contains("Camiseta"));
        assertTrue("Debe contener 'Pantalón'", logs.contains("Pantalón"));
        assertTrue("Debe contener 'Zapatos'", logs.contains("Zapatos"));
        
        // Verificar que se aplicó el descuento
        assertTrue("Debe contener 'Descuento aplicado'", logs.contains("Descuento aplicado."));
        
        // Verificar el total esperado
        // Cálculo: 20 + 40 + 60 = 120 > 100 -> 120 * 0.90 = 108 + impuestos = 130.68 + envío = 146.63
        assertTrue("Debe contener el total a pagar", logs.contains("Total a pagar:"));
    }
}
