/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema08practicacbancarias;

import java.util.ArrayList;

/**
 *
 * @author sportak
 */
public class Clientes {

    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private int telefono;
    private ArrayList<Cuentas> listaCuentas = new ArrayList<Cuentas>();

    public Clientes(String dni, String nombre, String apellidos, String direccion, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Cuentas> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<Cuentas> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public void mostrarListaCuentas() {
        for (int i = 0; i < this.listaCuentas.size(); i++) {
            System.out.println(this.listaCuentas.get(i).toString());
        }

    }

    public Cuentas buscarCuenta(int num) {
        for (int i = 0; i < this.listaCuentas.size(); i++) {
            if (this.listaCuentas.get(i).getNumeroCuenta() == num) {
                return this.listaCuentas.get(i);
            }
        }
        return null;
    }

    public void añadirCuenta(Cuentas c) {
        this.listaCuentas.add(c);
    }

    @Override
    public String toString() {
        return "Nombre " + this.nombre + "\t" + "Apellidos " + this.apellidos + "\t" + "DNI " + this.dni + "\t" + "Direccion " + this.direccion + "\t" + "Telefono " + this.telefono + "\t" + "Numero cuentas " + this.listaCuentas.size();
    }

}
