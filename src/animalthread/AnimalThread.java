/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalthread;

import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class AnimalThread extends Thread {

    private String Nombre;
    private int limite;
    private JLabel animal;
    private int x;
    private int y;
    private String nombre;

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
        for (int i = x; i <= this.limite; i += 10) {
            System.out.println(this.nombre + "avanza"); 
            this.animal.setLocation(i, y);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.nombre="Ha llegado a la meta"); 
        yield(); 
    }

 

}
