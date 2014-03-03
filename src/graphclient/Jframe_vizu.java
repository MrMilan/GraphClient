/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphclient;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class Jframe_vizu extends JPanel{
    
    short [] pole;
    
    public Jframe_vizu(short [] pole)
    {
        super();
        this.pole=pole;
    
    }
    @Override
    public void paint(Graphics g)
    {
    g.drawLine(1,1, 100, 100);
    }
    
}
