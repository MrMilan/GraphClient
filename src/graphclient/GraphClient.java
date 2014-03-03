/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphclient;

/**
 *
 * @author User
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class GraphClient extends JPanel {

    private static final int SIZE = 400;
    private final GeneralPath path = new GeneralPath();

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(SIZE, SIZE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        double dt = Math.PI / 180;
        int w = getWidth() / 2;
        int h = getHeight() / 2;
        path.reset();
        path.moveTo(w, h);
        for (double t = 0; t < 2 * Math.PI; t += dt) {
            double x = w * Math.sin(5 * t) + w;
            double y = h * Math.sin(4 * t) + h;
            path.lineTo(x, y);
        }
        g2d.setColor(Color.blue);
        g2d.draw(path);
    }

    public static void main(String[] args) {
        /*EventQueue.invokeLater(new Runnable() {

         @Override
         public void run() {
         JFrame f = new JFrame();
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         f.add(new GraphClient());
         f.pack();
         f.setVisible(true);
         }
         });*/
        int portNumber = 2233;
        String hostName = "147.32.84.225";
        short[] readA;
        short[] readB;
        short[] readC;
        short[] readD;
        int length = 1437020/5;
        int count = 0;
        try {
            Socket clientSocket = new Socket(hostName, portNumber);

            System.err.println("Otviram vstupy vystupy");

            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());

            readB = new short[length];
            count = 0;
            try {
            while (true) {
                readB[count] = (short) (dis.readByte() & 0xFF);
                //System.out.println(readB[count]);
                count++;
            }
             } catch (EOFException exc) {
            }
            dis.close();
            System.err.println("Zaviram vstupy vystupy");

            clientSocket.close();
        } catch (IOException exc) {
            System.err.println("Umrel jsem na spojeni ->" + exc.getMessage());
        }
        System.out.println(count);
    }
}
