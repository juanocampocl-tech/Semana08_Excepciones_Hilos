package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(1000.0);
        double montoRetiro = 400.0;

        Thread cajero1 = new Thread(new Cajero(cuenta, montoRetiro), "Cajero-1");
        Thread cajero2 = new Thread(new Cajero(cuenta, montoRetiro), "Cajero-2");
        Thread cajero3 = new Thread(new Cajero(cuenta, montoRetiro), "Cajero-3");

        cajero1.start();
        cajero2.start();
        cajero3.start();

        try {
            cajero1.join();
            cajero2.join();
            cajero3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Saldo final en la cuenta: " + cuenta.getSaldo());
    }
}