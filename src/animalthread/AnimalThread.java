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
public class AnimalThread extends Thread {

    private String nombre;
    private int x;
    private int y;
    private int limite;
    private JLabel animal;
    private JButton boton;

    public AnimalThread() {
    }

    public AnimalThread(String nombre, int x, int y, int limite, JLabel animal) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.limite = limite;
        this.animal = animal;
    }

    @Override
    public void run() {
        boolean llegoC = false, llegoT = false, llegoD = false;
        for (int i = x; i <= this.limite; i += 10) {
            System.out.println(this.nombre + " avanza");
            this.animal.setLocation(i,y);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        DesaparecerBotones verificador = new DesaparecerBotones(boton,true);
        verificador.cambiarEstado(true,this.nombre);
        System.out.println(this.nombre + " a llegado a la meta");

        yield();
    }

}
