/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphclient;

import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class Jframe_vizu extends JPanel {

    List<Short> pole;

    public Jframe_vizu(List<Short> pole) {
        super();
        this.pole = pole;

    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < pole.size()-1; i++) {
            g.drawLine(pole.get(i).intValue(), pole.get(i).intValue(), pole.get(i+1).intValue(), pole.get(i+1).intValue());
        }
    }


}
