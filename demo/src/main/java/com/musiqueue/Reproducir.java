package com.musiqueue;

import java.io.InputStream;
import javax.swing.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Reproducir {

    private boolean pausa;       // Para Play/Pause
    private boolean siguiente;  // Para Siguiente
    private final Object lock = new Object(); // al parecer todas las clases en java heredan java.lang.Object, y estos al usar  synchronized puedes usar wait, notify etc para la comunicacion con hilos en java entonces creamos un Object general basico 

    public void play(String nombre, String imagen) throws JavaLayerException {
        pausa = false;
        siguiente = false;

        // Carga del recurso MP3
        String rutaRecurso = "Files/" + nombre + ".mp3";
        InputStream is = getClass().getClassLoader().getResourceAsStream(rutaRecurso);

        if (is == null) {
            System.err.println(" No se encontró el archivo: " + rutaRecurso);
            return;
        }

      


        ImageIcon imagenFrame = new ImageIcon(getClass().getClassLoader().getResource(imagen));

  
        JFrame frame = new JFrame("Reproductor - " + nombre);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelImagen = new JLabel(imagenFrame);
        labelImagen.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(labelImagen, "Center");

        JButton playBtn = new JButton("Play/Pause");
        JButton siguienteBtn = new JButton("Siguiente");

        JPanel panel = new JPanel();
        panel.add(playBtn);
        panel.add(siguienteBtn);
        frame.add(panel, "South");

        frame.setVisible(true);

        final Player player = new Player(is);

        // boton de pauase solo se alterna
        playBtn.addActionListener(e-> {

            synchronized ( lock ){
                pausa = !pausa;
                if(!pausa ){lock.notify();}
            }

        } );

        siguienteBtn.addActionListener(e -> {
            synchronized (lock) {
                siguiente = true;
                lock.notify(); // sale del bucle y termina la canción
            }
        });

      
        Thread hilo = new Thread(() -> {
            try {
                while (true) {
                    if (!player.play(1)) break; // reproduce un frame de la cancion ( pedacito ) al hacer player.play (1) se eescucha un pedazo y con ayuda del while( true) pues se escucha normal

                    synchronized (lock) { // con quien estoy sincronizado quien es mi candado
                        while (pausa && !siguiente) {
                            lock.wait(); // pausa la reproducción, detiene el hilo
                        }
                        if (siguiente) break; // usuario presionó siguiente
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                frame.dispose(); // cierra la ventana al terminar
            }
        });

        hilo.start();

        // Espera a que el hilo termine antes de regresar esto pasa porque en la version anterior ( donde usabamos que el primer hilo el principal del metodo play se dormia pasaba lo siguiente): 1. ejectaba el hilo mientras play dormia,cambiabamos al terminar pausa a true para que el hilo se rompiera, epserabamos otra vez 1 segundo y volviamos a reprodicitr play de la siguiente cancion, en este caso el hilo termina no con un sleep si no con la variable siguiente que lo rompe y esperamos a que termine completamente con hilo.join ya que sin esto el programa play seguiria ejeucutandose para cada cancion 

        // sin join solo e lmetodo play abriria el hilo pero no lo espera como tal a q termine la cancion o se ejecute la logica sigue su curso y por ende terminaria
        try {
            hilo.join();    
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
