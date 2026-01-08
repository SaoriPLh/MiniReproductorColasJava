package com.hilos;

import javax.swing.*;

public class Hilos {

    public static boolean pausa;

    public static void main(String[] args) {
        pausa = false;
        Object candado = new Object();

        JFrame frame = new JFrame("Contador con pausa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panelPrincipal = new JPanel();
        frame.add(panelPrincipal);

        JLabel texto = new JLabel("Número: 0");
        JButton botonPausa = new JButton("Pausa");
        panelPrincipal.add(texto);
        panelPrincipal.add(botonPausa);

        frame.setVisible(true);

        // Acción del botón
        botonPausa.addActionListener(e -> {
            synchronized (candado) {
                pausa = !pausa;
                candado.notify(); // despierta al hilo si está esperando
            }
        });

        // Hilo contador
        Thread hilo = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                synchronized (candado) {
                    while (pausa) { // espera mientras esté en pausa
                        try {
                            candado.wait(); 
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }

                final int numero = i;
                SwingUtilities.invokeLater(() -> texto.setText("Número: " + numero));

                System.out.println("Número " + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        hilo.start();
    }
}
