/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalthread;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class Clock extends Thread{
    private int hora, minutos, segundos;
    private JTextField reloj;
    
    

    @Override
    public void run() {

        while(true){
        Calendar reloj = new GregorianCalendar();
        hora = reloj.get(Calendar.HOUR_OF_DAY);
        minutos = reloj.get(Calendar.MINUTE);
        segundos = reloj.get(Calendar.SECOND);
        System.out.println(hora + ":" + minutos + ":" + segundos);
        }

    }

    public int getHora() {
        return hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

}
