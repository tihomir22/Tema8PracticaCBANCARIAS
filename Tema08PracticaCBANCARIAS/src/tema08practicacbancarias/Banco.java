/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema08practicacbancarias;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *
 * @author sportak
 */
public class Banco {

    private String nombre;
    private String domicilio;
    private ArrayList<Clientes> listaClientes = new ArrayList<Clientes>();

    public Banco(String nombre, String domicilio) {
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public ArrayList<Clientes> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Clientes> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public void mostrarClientesTodos() {
        for (int i = 0; i < this.listaClientes.size(); i++) { //for que se usa para recorrer clientes
            System.out.println(this.listaClientes.get(i).toString());

        }
    }

    public Clientes buscarCliente(String n) {
        for (int i = 0; i < this.listaClientes.size(); i++) {
            if (this.listaClientes.get(i).getNombre().equalsIgnoreCase(n)) {
                return this.listaClientes.get(i);
            }
        }
        return null;
    }

    public void añadirCliente(Clientes c) {
        this.listaClientes.add(c);
    }

    public boolean contieneCliente(String n) {
        for (int i = 0; i < this.listaClientes.size(); i++) {
            if (this.listaClientes.get(i).getNombre().equalsIgnoreCase(n)) {
                
                return false;
            }
        }
        return true;
    }

}
