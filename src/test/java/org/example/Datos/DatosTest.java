package org.example.Datos;

import org.example.Modelo.Inventario;
import org.example.Modelo.Producto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class DatosTest {

    private static final String PRODUCTOS_CSV = "productos.csv";
    private static final String USUARIOS_CSV = "usuarios.csv";

    @BeforeEach
    void setUp() {
        eliminarArchivo(PRODUCTOS_CSV);
        eliminarArchivo(USUARIOS_CSV);
    }

    @AfterEach
    void tearDown() {
        eliminarArchivo(PRODUCTOS_CSV);
        eliminarArchivo(USUARIOS_CSV);
    }

    @Test
    void asegurarArchivosCSV() {
        assertFalse(new File(PRODUCTOS_CSV).exists());
        assertFalse(new File(USUARIOS_CSV).exists());

        Datos.asegurarArchivosCSV();

        assertTrue(new File(PRODUCTOS_CSV).exists());
        assertTrue(new File(USUARIOS_CSV).exists());
    }

    @Test
    void cargarInventarioDesdeCSV() {
        crearArchivoCSVSimulado();

        assertTrue(Inventario.inventario.isEmpty());

        Datos.cargarInventarioDesdeCSV();

        assertFalse(Inventario.inventario.isEmpty());
        assertEquals(2, Inventario.inventario.size());

        Producto producto = Inventario.inventario.get("producto1");
        assertNotNull(producto);
        assertEquals("producto1", producto.getNombre());
        assertEquals(100.0, producto.getPrecio());
        assertEquals("Información adicional producto 1", producto.getInformacionAdicional());
        assertEquals("01/01/2023", producto.getFechaIngreso());
        assertEquals(10, producto.getCantidad());
    }

    private void crearArchivoCSVSimulado() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(PRODUCTOS_CSV))) {
            writer.println("producto1,100.0,Información adicional producto 1,01/01/2023,10");
            writer.println("producto2,50.0,Información adicional producto 2,02/02/2023,5");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void eliminarArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
    }
}
