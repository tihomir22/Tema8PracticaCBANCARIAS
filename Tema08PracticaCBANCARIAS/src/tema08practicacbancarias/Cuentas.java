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
public class Cuentas {

    protected int numeroCuenta;
    protected double saldo;
    protected double interes;
    protected double comision;

    public Cuentas(int numeroCuenta, double saldo, double interes, double comision) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.interes = interes;
        this.comision = 0.6;

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

    public boolean comprobarSaldo(double cantidad) {
        if (this.saldo - cantidad < 0) {
            return false;
        }
        return true;
    }

    public void ingresar(double cantidad) {
        this.saldo = this.saldo + cantidad;
    }

    public void retirar(double cantidad) {
        this.saldo = this.saldo - cantidad;
    }

    public void revisionMensual() {

        this.saldo = this.saldo * this.interes - this.comision;
        System.out.println("Revision realizada");
    }

    @Override
    public String toString() {
        return "NumCuenta " + this.numeroCuenta + "\t" + "Saldo " + this.saldo + "\t" + "Interes " + this.interes + "\t" + "Comision " + this.comision + "\t";
    }

}
