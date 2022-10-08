package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import character.*;


public class Game extends JPanel implements KeyListener {

    int gameSpeed = 30;
    Dog dog = new Dog(50,300,50);
    Wave wave = new Wave(800,300,30,40,30,this);
    public Game() {
        this.setBounds(0,0,1000,600);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setLayout(null);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.drawRect(dog.x, dog.y, dog.dogSize);
        g2.setColor(Color.brack);
        g2.drawRect(wave.x, wave.y, wave.width, wave.hegth);
    }
    @Override
    public void KeyType(KeyEvent e) {
        //TODO auto-genered method stub
    }
    @Override
    public void KeyPressed(KeyEvent e) {
        if(e.getKeyCode()==38||e.getKeyCode()==32) {
            dog.jump(this);
            this.repaint();
    }
    @Override
    public void KeyReased (KeyEvent e) {
        //TODO auto-genered method stub
    }
}
