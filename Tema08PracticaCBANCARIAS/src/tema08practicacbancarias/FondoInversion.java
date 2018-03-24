/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema08practicacbancarias;

/**
 *
 * @author sportak
 */
public class FondoInversion extends Cuentas {

    public FondoInversion(int numeroCuenta, double saldo, double interes, double comision) {
        super(numeroCuenta, saldo, interes = 1.34, comision);

    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    @Override
    public boolean comprobarSaldo(double cantidad) {

        if (this.saldo - cantidad > -500) {
            return true;
        }

        System.out.println("Cuenta bloqueada");
        return false;
    }

}
