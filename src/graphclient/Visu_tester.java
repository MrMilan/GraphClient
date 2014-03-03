/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphclient;

import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class Visu_tester {
    
    public static void main(String[] args)
    {
        short[]pole=new short[1];
        Jframe_vizu frame = new Jframe_vizu(pole);
        JFrame f = new JFrame("Test");
        f.add(frame);//pridani na 4 panely
        //layout manager
        f.setVisible(true);
    }
    
}
