package character;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

public class Dog {
    public int x,y,dogSize;
    private int jumpHigh = 50;

    public Dog(int x, int y, int dogSize) {
        this.x = x;
        this.y = y;
        this.dogSize = dogSize;
    }
    public void jump(JPanel game) {
        this.y -= jumpHigh;
        game.repaint();
        Time time = new Timer(450, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                y += jumpHigh;
                game.repaint();
            }
        });
        timer.setRepeats(false);
        time.start();
    }
}
