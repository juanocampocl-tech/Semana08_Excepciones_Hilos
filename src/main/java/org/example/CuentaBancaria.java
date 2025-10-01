package org.example;

public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized void depositar(double monto) {
        saldo += monto;
        System.out.println(Thread.currentThread().getName() + " depositó: " + monto + ", saldo actual: " + saldo);
    }

    public synchronized void retirar(double monto) throws SaldoInsuficienteException {
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para retirar " + monto);
        }
        saldo -= monto;
        System.out.println(Thread.currentThread().getName() + " retiró: " + monto + ", saldo actual: " + saldo);
    }

    public double getSaldo() {
        return saldo;
    }
}

