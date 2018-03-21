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
        int opcion;

        do {
            mostrarMenu();
            opcion = teclado.nextInt();
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
