package org.example;

public class Cajero implements Runnable {
    private CuentaBancaria cuenta;
    private double montoRetiro;

    public Cajero(CuentaBancaria cuenta, double montoRetiro) {
        this.cuenta = cuenta;
        this.montoRetiro = montoRetiro;
    }

    @Override
    public void run() {
        try {
            cuenta.retirar(montoRetiro);
        } catch (SaldoInsuficienteException e) {
            System.out.println(Thread.currentThread().getName() + " - " + e.getMessage());
        }
    }
}

