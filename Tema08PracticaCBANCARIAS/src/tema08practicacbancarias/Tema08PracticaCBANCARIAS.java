/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema08practicacbancarias;

import java.util.Scanner;

/**
 *
 * @author sportak
 */
public class Tema08PracticaCBANCARIAS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion, busquedaint;
        Banco banco1 = null;
        Clientes cliente1;
        Clientes activo;
        Cuentas activa;
        String eleccion, busqueda;

        do {
            mostrarMenu();
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    opcion = teclado.nextInt();
                    if (opcion == 1) { // 1.1
                        try {
                            banco1 = new Banco("Bankia", "Av de la paz 21 , Canals 46690");
                            System.out.println("Banco dado de alta exitosamente");
                        } catch (Exception ex) {
                            System.out.println("No puedo darse de alta : " + ex.getMessage());
                        }
                    }
                    if (opcion == 2) { // 1.2
                        if (banco1.getListaClientes().size() > 0) {
                            System.out.println("Sobre que cliente quieres revisar cuentas? Introduzca nombre o ALL para todas");
                            teclado.nextLine();
                            eleccion = teclado.nextLine();
                            if (!eleccion.equalsIgnoreCase("ALL")) {
                                banco1.mostrarClientesTodos();
                            } else {
                                activo = banco1.buscarCliente(eleccion);
                                if (activo != null) {
                                    activo.mostrarListaCuentas();
                                } else {
                                    System.out.println("Cliente no encontrado!");
                                }
                            }
                        } else {
                            System.out.println("No hay clientes en el banco");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Bienvenido al gestor de clientes, que desea hacer? ALTA BAJA o MODIFICACION");
                    teclado.nextLine();
                    eleccion = teclado.nextLine();
                    if (eleccion.equalsIgnoreCase("ALTA")) {
                        cliente1 = new Clientes("X5514136R", "Tihomir", "Stoychev", "C mestre serrano", 603680594);
                        banco1.añadirCliente(cliente1);
                        System.out.println("Dado exitosamente de alta");
                    }
                    if (eleccion.equalsIgnoreCase("BAJA")) {
                        System.out.println("Que cliente deseas eliminar? Introduce su Nombre");
                        busqueda = teclado.nextLine();
                        activo = banco1.buscarCliente(busqueda);

                        if (activo != null) {
                            banco1.getListaClientes().remove(activo);
                            System.out.println("Cliente dado de baja exitosamente ");
                        } else {
                            System.out.println("No se pudo dar de baja ");
                        }
                    }
                    if (eleccion.equalsIgnoreCase("MODIFICACION")) {
                        System.out.println("Que cliente deseas modificar? Introduce su Nombre");
                        busqueda = teclado.nextLine();
                        activo = banco1.buscarCliente(busqueda);
                        if (activo != null) {
                            System.out.println("Nuevo nombre");
                            busqueda = teclado.nextLine();
                            activo.setNombre(busqueda);
                            System.out.println("Nuevos apellidos");
                            busqueda = teclado.nextLine();
                            activo.setApellidos(busqueda);
                            System.out.println("Nueva direccion");
                            busqueda = teclado.nextLine();
                            activo.setDireccion(busqueda);
                            System.out.println("Nuevo DNI");
                            busqueda = teclado.nextLine();
                            activo.setDni(busqueda);
                            System.out.println("Nuevo telefono");
                            busquedaint = teclado.nextInt();
                            activo.setTelefono(busquedaint);
                            System.out.println(activo.toString());
                        } else {
                            System.out.println("No existe tal cliente, no se puede modificar");
                        }
                    }
                    break;

                case 3:
                    System.out.println("A que cliente deseas gestionar sus cuentas? Introduce su Nombre");
                    busqueda = teclado.nextLine();
                    activo = banco1.buscarCliente(busqueda);
                    activo.mostrarListaCuentas();
                    System.out.println("Que cuenta deseas gestionar? Introduce numero de cuenta");
                    busquedaint = teclado.nextInt();
                    
                    break;

            }
        } while (opcion != 0);
    }

    public static void mostrarMenu() {
        System.out.println("1.­ Administrador\n"
                + "1.1.­ Creación de banco\n"
                + "1.2.­ Revisión de todas las cuentas\n"
                + "2.­ Gestión de clientes (Alta, Baja, Modificación)\n"
                + "3.­ Gestión de cuentas (para un cliente seleccionado)\n"
                + "3.1.­ Crear cuenta\n"
                + "3.2.­ Ingresar dinero\n"
                + "3.3.­ Sacar dinero\n"
                + "3.4.­ Consultar saldo\n"
                + "3.5.­ Consulta puntos\n"
                + "3.6.­ Revisión mensual");
    }

}
