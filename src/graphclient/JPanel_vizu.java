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
public class JPanel_vizu extends JPanel {

    List<Short> pole;
    int step;

    public JPanel_vizu(List<Short> pole,int step) {
        super();
        this.pole = pole;
        this.step=step;

    }

    @Override
    public void paint(Graphics g) {
        int size = pole.size();
        int max = 255; //max aplituda
        for (int i = 0; i < size - 1; i+=step) {
            g.drawLine(
                    (int)((getWidth()/(double)size)*i), 
                    (int)((getHeight()/(double)max)*pole.get(i).intValue()),
                    (int)((getWidth()/(double)size)*(i+1)), 
                    (int)((getHeight()/(double)max)*pole.get(i+1).intValue())
            );
        }
    }


}
