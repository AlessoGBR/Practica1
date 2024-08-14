/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1.Backend;

/**
 *
 * @author alesso
 */
public class crearSolicitud {

    private int numero;
    private String nombre;
    private double salario;
    private String direccion;
    private String fecha;
    private String tipo;

    public crearSolicitud(int numero, String nombre, double salario, String direccion, String fecha, String tipo) {
        this.numero = numero;
        this.nombre = nombre;
        this.salario = salario;
        this.direccion = direccion;
        this.fecha = fecha;
        this.tipo = tipo;
    }
    
    public void imprimir(){
        System.out.println(getNumero());
        System.out.println(getNombre()  );
        System.out.println(getSalario());
        System.out.println(getDireccion()   );
        System.out.println(getFecha());
        System.out.println(getTipo());
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
