/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_pokemon_g5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class PantallaInicio extends javax.swing.JFrame{
    public PantallaInicio() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Configurar el diseño del panel principal
        JPanel pnlPanelPrincipal = new JPanel(new BorderLayout());

        // Añadir la imagen al panel
        ImageIcon icon = new ImageIcon("C:\\Users\\dfons\\OneDrive\\Escritorio\\ProyectoDani\\ProyectoFinal_G5-master\\src\\main\\java\\com\\mycompany\\proyecto_pokemon_g5\\logo\\Pantalla Pokemon.png");
        JLabel lblImage = new JLabel(icon);
        pnlPanelPrincipal.add(lblImage, BorderLayout.CENTER);

        // Añadir el botón al panel
        JButton btnInicio = new JButton("Iniciar Juego");
        btnInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                BotonInicioJuegoActionPerformed(evt);
            }
        });
        pnlPanelPrincipal.add(btnInicio, BorderLayout.SOUTH);

        // Configurar la ventana principal
        getContentPane().add(pnlPanelPrincipal);
        pack();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    private void BotonInicioJuegoActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);

        String audioFilePath = "C:\\Users\\dfons\\OneDrive\\Escritorio\\ProyectoDani\\ProyectoFinal_G5-master\\src\\main\\java\\sonidos\\MusicaPelea.wav";

        try {
            // Obtener el archivo de audio
            File audioFile = new File(audioFilePath);
            // Crear un flujo de entrada de audio
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            // Obtener un Clip de audio
            Clip clip = AudioSystem.getClip();
            // Abrir el flujo de audio en el Clip
            clip.open(audioInputStream);
            //bajamos el volumen a la mitad
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            // Obtener los valores mínimo y máximo del control de volumen
            float minVolume = gainControl.getMinimum();
            float maxVolume = gainControl.getMaximum();
            // Calcular el valor para reducir el volumen a la mitad
            float targetVolume = (minVolume + maxVolume) / 2.0f;
            // Establecer el valor de volumen a la mitad
            gainControl.setValue(targetVolume);
            clip.start();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
        }
        new BatallaPokemon().setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaInicio().setVisible(true);
                String audioFilePath = "C:\\Users\\dfons\\OneDrive\\Escritorio\\ProyectoDani\\ProyectoFinal_G5-master\\src\\main\\java\\sonidos\\InicioJuego.wav";

                try {
                    // Obtener el archivo de audio
                    File audioFile = new File(audioFilePath);
                    // Crear un flujo de entrada de audio
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                    // Obtener un Clip de audio
                    Clip clip = AudioSystem.getClip();
                    // Abrir el flujo de audio en el Clip
                    clip.open(audioInputStream);
                    // Reproducir el audio
                    clip.start();
                } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}