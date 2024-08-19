/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1.Backend;

import com.mycompany.practica1.Frontend.estadoCuenta;
import com.mycompany.practica1.Frontend.listadoSolicitudes;
import com.mycompany.practica1.Frontend.listadoTarjetas;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author alesso
 */
public class leerArchivos {

    public leerArchivos() {

    }

    public boolean leerSolicitud(String rutaArchivo, crearSolicitud solicitud) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("SOLICITUD")) {
                    linea = linea.replace("SOLICITUD(", "").replace(");", "");
                    String[] partes = linea.split(",");
                    int id = 0;
                    try {
                        id = Integer.parseInt(partes[0].trim());
                    } catch (NumberFormatException e) {
                        continue;
                    }
                    String fecha = partes[1].trim().replace("\"", "").replace("“", "").replace("”", "");
                    String convertirFecha = convertirFecha(fecha);
                    String tipo = partes[2].trim().replace("\"", "").replace("“", "").replace("”", "");
                    String nombre = partes[3].trim().replace("\"", "").replace("“", "").replace("”", "");
                    double salario = Double.parseDouble(partes[4].trim());
                    String direccion = partes[5].trim().replace("\"", "").replace("“", "").replace("”", "");
                    solicitud.setNumero(id);
                    solicitud.setFecha(convertirFecha);
                    solicitud.setTipo(tipo);
                    solicitud.setNombre(nombre);
                    solicitud.setSalario(salario);
                    solicitud.setDireccion(direccion);
                    return true;
                } else {
                    
                }

            }
        } catch (IOException e) {
            System.out.println("error a la hora de verifcar el documento");
        }
        return false;
    }

    public int leerAutorizacion(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("AUTORIZACION")) {
                    linea = linea.replace("AUTORIZACION_TARJETA(", "").replace(");", "");

                    String[] partes = linea.split(",");

                    int id = 0;
                    try {
                        id = Integer.parseInt(partes[0].trim());
                    } catch (NumberFormatException e) {
                        continue;
                    }
                    return id;
                } else {
                    return 2;
                }

            }
        } catch (IOException e) {
            System.out.println("error a la hora de verifcar el documento");
        }

        return 0;
    }

    private String convertirFecha(String fechaOriginal) {
        String formatoSalida = "yyyy-MM-dd";
        String[] formatosEntrada = {
            "dd/MM/yyyy", "MM/dd/yyyy", "yyyy/MM/dd", "yyyy-MM-dd",};

        for (String formato : formatosEntrada) {
            try {
                SimpleDateFormat sdfEntrada = new SimpleDateFormat(formato);
                sdfEntrada.setLenient(false);
                Date fecha = sdfEntrada.parse(fechaOriginal);

                SimpleDateFormat sdfSalida = new SimpleDateFormat(formatoSalida);
                return sdfSalida.format(fecha);
            } catch (ParseException e) {
                System.out.println("eror a la hora de cambiar la fecha");
            }
        }

        return fechaOriginal;
    }

    public boolean leerConsulta(String rutaArchivo, crearTarjeta tarjeta) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("CONSULTAR")) {
                    linea = linea.replace("CONSULTAR_TARJETA(", "").replace(");", "");

                    String numeroTarjeta = linea.trim().replace(" ", "");

                    tarjeta.setNumero(numeroTarjeta);

                    return true;
                } else {
                
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }

        return false;
    }

    public boolean leerCancelacion(String rutaArchivo, crearTarjeta tarjeta) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("CANCELACION")) {
                    linea = linea.replace("CANCELACION_TARJETA(", "").replace(");", "");

                    String numeroTarjeta = linea.trim().replace(" ", "");

                    tarjeta.setNumero(numeroTarjeta);

                    return true;
                } else {
                    
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }

        return false;
    }

    public boolean leerMovimientos(String rutaArchivo, movimiento movimiento) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("MOVIMIENTO")) {
                    linea = linea.replace("MOVIMIENTO(", "").replace(");", "");

                    String[] partes = linea.split(",");

                    String tarjeta = partes[0].trim().replace("\"", "").replace("“", "").replace("”", "").replace(" ", "");
                    String fecha = partes[1].trim().replace("\"", "").replace("“", "").replace("”", "");
                    String convertirFecha = convertirFecha(fecha);
                    String tipoMovimiento = partes[2].trim().replace("\"", "").replace("“", "").replace("”", "");
                    String descripcion = partes[3].trim().replace("\"", "").replace("“", "").replace("”", "");
                    String establecimiento = partes[4].trim().replace("\"", "").replace("“", "").replace("”", "");
                    double monto = Double.parseDouble(partes[5].trim());

                    movimiento.setTarjeta(tarjeta);
                    movimiento.setFecha(convertirFecha);
                    movimiento.setMovimiento(tipoMovimiento);
                    movimiento.setDescripcion(descripcion);
                    movimiento.setEstablecimiento(establecimiento);
                    movimiento.setMonto(monto);

                    return true;
                } else {
                    
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir un valor numérico");
        }
        return false;
    }

    public void leerListadoTarjeta(String rutaArchivo, listadoTarjetas tarjetas) {
        String tipo = "";
        String monto = "";
        String fechaInicio = "";
        String fechaFin = "";
        String estado = "";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("LISTADO_TARJETAS")) {
                    // Elimina el prefijo y los paréntesis
                    linea = linea.replace("LISTADO_TARJETAS(", "").replace(");", "");

                    // Divide la línea en partes usando la coma como delimitador
                    String[] partes = linea.split(",");

                    // Asigna valores a las variables, manejando posibles valores vacíos
                    if (partes.length > 0) {
                        tipo = partes[0].trim().replace("\"", "").replace("“", "").replace("”", "").replace(" ", "");
                    }
                    if (partes.length > 1) {
                        monto = partes[1].trim().replace("\"", "").replace("“", "").replace("”", "").replace(" ", "");
                    }
                    if (partes.length > 2) {
                        fechaInicio = partes[2].trim().replace("\"", "").replace("“", "").replace("”", "").replace(" ", "");
                    }
                    if (partes.length > 3) {
                        fechaFin = partes[3].trim().replace("\"", "").replace("“", "").replace("”", "").replace(" ", "");
                    }
                    if (partes.length > 4) {
                        estado = partes[4].trim().replace("\"", "").replace("“", "").replace("”", "").replace(" ", "");
                    }

                    fechaInicio = convertirFecha(fechaInicio);
                    fechaFin = convertirFecha(fechaFin);
                    tarjetas.llenarCampos(tipo, monto, fechaInicio, fechaFin, estado);
                } else {
                    tarjetas.formatoIncorrecto();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }

    public void leerListadoSolicitudes(String rutaArchivo, listadoSolicitudes solicitudes) {
        String tipo = "";
        String salario = "";
        String fechaInicio = "";
        String fechaFin = "";
        String estado = "";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("LISTADO_SOLICITUDES")) {
                    // Elimina el prefijo y los paréntesis
                    linea = linea.replace("LISTADO_SOLICITUDES(", "").replace(");", "");

                    // Divide la línea en partes usando la coma como delimitador
                    String[] partes = linea.split(",");

                    // Asigna valores a las variables, manejando posibles valores vacíos
                    if (partes.length > 0) {
                        fechaInicio = partes[0].trim().replace("\"", "").replace("“", "").replace("”", "").replace(" ", "");
                    }
                    if (partes.length > 1) {
                        fechaFin = partes[1].trim().replace("\"", "").replace("“", "").replace("”", "").replace(" ", "");
                    }
                    if (partes.length > 2) {
                        tipo = partes[2].trim().replace("\"", "").replace("“", "").replace("”", "").replace(" ", "");
                    }
                    if (partes.length > 3) {
                        salario = partes[3].trim().replace("\"", "").replace("“", "").replace("”", "").replace(" ", "");
                    }

                    if (partes.length > 4) {
                        estado = partes[4].trim().replace("\"", "").replace("“", "").replace("”", "").replace(" ", "");
                    }

                    fechaInicio = convertirFecha(fechaInicio);
                    fechaFin = convertirFecha(fechaFin);
                    solicitudes.llenarCampos(tipo, salario, fechaInicio, fechaFin, estado);
                } else {
                    solicitudes.formatoIncorrecto();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }

    public void leerListadoMovimientos(String rutaArchivo, estadoCuenta movimientos) {
        String numero = "";
        String tipo = "";
        String saldo = "";
        String interes = "";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("ESTADO_CUENTA")) {
                    // Elimina el prefijo y los paréntesis
                    linea = linea.replace("ESTADO_CUENTA(", "").replace(");", "");

                    // Divide la línea en partes usando la coma como delimitador
                    String[] partes = linea.split(",");

                    // Asigna valores a las variables, manejando posibles valores vacíos
                    if (partes.length > 0) {
                        numero = partes[0].trim().replace("\"", "").replace("“", "").replace("”", "").replace(" ", "");
                    }
                    if (partes.length > 1) {
                        tipo = partes[1].trim().replace("\"", "").replace("“", "").replace("”", "").replace(" ", "");
                    }
                    if (partes.length > 2) {
                        saldo = partes[2].trim().replace("\"", "").replace("“", "").replace("”", "").replace(" ", "");
                    }
                    if (partes.length > 3) {
                        interes = partes[3].trim().replace("\"", "").replace("“", "").replace("”", "").replace(" ", "");
                    }
                    movimientos.llenarCampos(numero, tipo, saldo, interes);
                } else {
                    movimientos.formatoIncorrecto();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }
}
