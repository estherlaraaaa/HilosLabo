/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import animalthread.AnimalThread;
import animalthread.Clock;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class Gui extends JFrame {
    
private JLabel[] labels;
    public JTextField reloj;
    private JButton inicio;
    private JButton reiniciar;
    private String[] nombres = {"canguro", "tortuga", "dragon"};

    public Gui() {

        super("Carrera de animales");
        initialComponents();

        VerificadorMeta ver = VerificadorMeta.getInstance();
    }

    private void initialComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
//
        reloj = new JTextField();
        reloj.setBounds(550, 550, 120, 30);
        Clock hora = new Clock();
        hora.start();
        reloj.setText(Integer.toString(hora.getHora())+" : "+Integer.toString(hora.getMinutos())+" : "+Integer.toString(hora.getSegundos()));
        //reloj.setBounds(10, 100, 120, 30);
//
        labels = new JLabel[3];
        inicio = new JButton("Inicio");
        reiniciar = new JButton("Reiniciar");
        Container container = getContentPane();
//        
        container.add(reloj);
//        
        for (int i = 0; i < 3; i++) {
            labels[i] = new JLabel();
            labels[i].setIcon(new ImageIcon(getClass().getResource(nombres[i] + ".gif")));
            labels[i].setBounds(10, (i * 220) + 10, 200, 200);
            container.add(labels[i]);
        }
        inicio.setBounds(10, 0, 100, 30);
        container.add(inicio);

        reiniciar.setBounds(500, 0, 100, 30);
        container.add(reiniciar);
        //no muetra el boton reiniciar
        this.reiniciar.setVisible(false);
        inicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnimalThread canguro = new AnimalThread("canguro", labels[0].getX(), labels[0].getY(), 510, labels[0]);
                AnimalThread tortuga = new AnimalThread("tortuga", labels[1].getX(), labels[1].getY(), 510, labels[1]);
                AnimalThread dragon = new AnimalThread("canguro", labels[2].getX(), labels[2].getY(), 510, labels[2]);
                canguro.start();
                tortuga.start();
                dragon.start();
            }
        });

        this.reiniciar.setVisible(true);
        reiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 3; i++) {
                    labels[i].setLocation(10, (i * 220));

                }

            }
        });

        setSize(700, 650);
    }

    public int getLocations(int num) {
        return labels[num].getY();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }

    public JButton getInicio() {
        return inicio;
    }

    public JButton getReiniciar() {
        return reiniciar;
    }
}
