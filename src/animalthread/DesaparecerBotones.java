/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalthread;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class DesaparecerBotones extends Thread {
   private static DesaparecerBotones instance;
    private boolean C = false;
    private boolean T = false;
    private boolean D = false;
//    private int limite;
//    private int locC;
//    private int locT;
//    private int locD;
    private JButton boton;
    private boolean estadoBoton;

    public DesaparecerBotones() {
    }

    public DesaparecerBotones(JButton boton, boolean estadoBoton) {
        this.boton = boton;
        this.estadoBoton = estadoBoton;
    }

//    public synchronized static DesaparecerBotones getInstance() {
//        if (instance == null) {
//            instance = new DesaparecerBotones();
//        }
//        return instance;
//    }

    @Override
    public void run() {
//        while (true) {
        if (C == true && T == true && D == true) {
            boton.setVisible(true);
        }
//            break;
//        }
        try {
            sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cambiarEstado(boolean estado, String nombre) {
        if (nombre.equals("canguro")) {
            C = estado;
        }
        if (nombre.equals("tortuga")) {
            T = estado;
        }
        if (nombre.equals("dragon")) {
            D = estado;
        }

    }
}
