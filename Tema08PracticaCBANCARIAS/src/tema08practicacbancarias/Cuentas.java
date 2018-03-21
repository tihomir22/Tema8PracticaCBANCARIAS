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
        this.comision = comision;
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
    public String toString() {
        return "NumCuenta "+this.numeroCuenta+"\t"+"Saldo "+this.saldo+"\t"+"Interes "+this.interes+"\t"+"Comision "+this.comision+"\t";
    }
    
    
    
}
