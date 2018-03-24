/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema08practicacbancarias;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
        int opcion, busquedaint, numC = 0, opcion2, res;
        Banco banco1 = null;
        Clientes cliente1;
        Clientes activo;
        Cuentas activa;
        Cuentas cuenta1;
        CuencaCorriente cuentaC1;
        CuentaVivienda cuentaV1;
        FondoInversion fondo1;
        double s, i, c;
        double puntosA;
        double puntos;
        String eleccion, busqueda;
        ArrayList<Cuentas> listaPuntos = new ArrayList<>();
        ArrayList listaPuntos2 = new ArrayList<>();
        do {
            mostrarMenu();
            try {
                opcion = teclado.nextInt();
            } catch (InputMismatchException e3) {
                System.out.println("Error 003: No introduciste un numero!");
                break;
            }
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
                            if (eleccion.equalsIgnoreCase("ALL")) {
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
                        try {
                            if (banco1.contieneCliente(cliente1.getNombre())) {
                                banco1.añadirCliente(cliente1);
                            } else {
                                throw new InputMismatchException();
                            }
                            System.out.println("Dado exitosamente de alta");

                        } catch (InputMismatchException e) {
                            System.out.println("Error 001: No se puede dar de ALTA , Ya existe el cliente ");
                        }
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
                    banco1.mostrarClientesTodos();
                    teclado.nextLine();
                    busqueda = teclado.nextLine();
                    activo = banco1.buscarCliente(busqueda);
                    if (activo != null) {
                        mostrarOpciones();
                        opcion = teclado.nextInt();
                        if (opcion == 1) {
                            System.out.println("Introduzca tipo de cuenta");
                            mostrarCuentas();
                            opcion2 = teclado.nextInt();
                            switch (opcion2) {

                                case 1:
                                    System.out.println("Introduzca saldo");
                                    s = teclado.nextDouble();
                                    cuentaC1 = new CuencaCorriente(numC, s, 0, 0);
                                    cuentaC1.setNumeroCuenta(cuentaC1.getNumeroCuenta() + 1);
                                    numC++;
                                    activo.añadirCuenta(cuentaC1);
                                    System.out.println("Añadida exitosamente");
                                    break;
                                case 2:
                                    System.out.println("Introduzca saldo");
                                    s = teclado.nextDouble();
                                    cuentaV1 = new CuentaVivienda(numC, s, 0, 0);
                                    cuentaV1.setNumeroCuenta(cuentaV1.getNumeroCuenta() + 1);
                                    numC++;
                                    activo.añadirCuenta(cuentaV1);
                                    System.out.println("Añadida exitosamente");
                                    break;
                                case 3:
                                    System.out.println("Introduzca saldo");
                                    s = teclado.nextDouble();
                                    fondo1 = new FondoInversion(numC, s, 0, 0);
                                    fondo1.setNumeroCuenta(fondo1.getNumeroCuenta() + 1);
                                    numC++;
                                    activo.añadirCuenta(fondo1);
                                    System.out.println("Añadida exitosamente");
                                    break;
                                default:
                                    System.out.println("No elegiste ninguna cuenta");
                                    break;
                            }
                        }
                        if (opcion == 2) { //INGRESAR 3.2
                            System.out.println("A que cuenta deseas ingresar? Introduce numero de cuenta");
                            activo.mostrarListaCuentas();
                            busquedaint = teclado.nextInt();
                            activa = activo.buscarCuenta(busquedaint);
                            if (activa != null) {
                                System.out.println("Que cantidad deseas ingresar?");
                                s = teclado.nextDouble();
                                activa.ingresar(s);
                                res = comprobarLista(activa, listaPuntos, listaPuntos2);
                                if (res != -1) {
                                    puntosA = (double) listaPuntos2.get(res);
                                    puntos = s / 6;
                                    listaPuntos2.set(res, puntos + puntosA);
                                } else {
                                    listaPuntos.add(activa);
                                    listaPuntos2.add(s / 6);
                                }
                                System.out.println("Ingreso exitoso");

                            } else {
                                System.out.println("Cuenta no encontrada...");
                            }

                        }
                        if (opcion == 3) { //SACAR 3.3
                            System.out.println("A que cuenta deseas retirar dinero? Introduce numero de cuenta");
                            activo.mostrarListaCuentas();
                            busquedaint = teclado.nextInt();
                            activa = activo.buscarCuenta(busquedaint);
                            if (activa != null) {
                                System.out.println("Que cantidad deseas retirar?");
                                s = teclado.nextDouble();
                                try {
                                    if (activa.comprobarSaldo(s)) {
                                        activa.retirar(s);
                                    } else {
                                        throw new InputMismatchException("");
                                    }
                                } catch (InputMismatchException e2) {
                                    System.out.println("No hay saldo suficiente");
                                }
                            } else {
                                System.out.println("Cuenta no encontrada...");
                            }
                        }
                        if (opcion == 4) {
                            System.out.println("A que cuenta deseas consultar el saldo? Introduce numero de cuenta");
                            activo.mostrarListaCuentas();
                            busquedaint = teclado.nextInt();
                            activa = activo.buscarCuenta(busquedaint);
                            System.out.println("El saldo es de " + activa.getSaldo() + "€");
                        }
                        if (opcion == 5) {
                            System.out.println("A que cuenta deseas consultar los puntos? Introduce numero de cuenta");
                            activo.mostrarListaCuentas();
                            busquedaint = teclado.nextInt();
                            activa = activo.buscarCuenta(busquedaint);
                            if (activa != null) {
                                res = comprobarLista(activa, listaPuntos, listaPuntos2);
                                System.out.println("El cliente con la cuenta " + activa.getNumeroCuenta() + "tiene " + listaPuntos2.get(res) + " puntos");
                            } else {
                                System.out.println("Cuenta no encontrada");
                            }

                        }
                        if (opcion == 6) {
                            System.out.println("A que cuenta deseas consultar los puntos? Introduce numero de cuenta");
                            activo.mostrarListaCuentas();
                            busquedaint = teclado.nextInt();
                            activa = activo.buscarCuenta(busquedaint);
                            if (activa != null) {
                                activa.revisionMensual();
                            } else {
                                System.out.println("Cuenta no encontrada");
                            }
                        }
                        System.out.println("**********************************");
                        activo.mostrarListaCuentas();
                        System.out.println("**********************************");

                    } else {
                        System.out.println("Cliente no encontrado");
                    }

                    break;

            }
        } while (opcion != 0);
    }

    public static void mostrarMenu() {
        System.out.println("1.­ Administrador\n"
                + "1.1.­ Creación de banco\n"
                + "1.2.­ Revisión de todas las cuentas\n"
                + "2.­ Gestión de clientes (Alta, Baja, Modificación)\n"
                + "3.­ Gestión de cuentas (para un cliente seleccionado)");

    }

    public static void mostrarOpciones() {
        System.out.println("1.­ Crear cuenta\n"
                + "2.­ Ingresar dinero\n"
                + "3.­ Sacar dinero\n"
                + "4.­ Consultar saldo\n"
                + "5.­ Consulta puntos\n"
                + "6.­ Revisión mensual");
    }

    public static void mostrarCuentas() {
        System.out.println("1.-Cuenta corriente");
        System.out.println("2.-CuentaVivienda");
        System.out.println("3.-FondoInversion");
    }

    public static int comprobarLista(Cuentas c, ArrayList<Cuentas> listaC, ArrayList listaP) {
        for (int i = 0; i < listaC.size() && i < listaP.size(); i++) {
            if (c.getNumeroCuenta() == listaC.get(i).getNumeroCuenta()) {
                System.out.println("Se ha encontrado");
                return i;
            }

        }
        return -1;
    }

}
