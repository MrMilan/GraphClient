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

    public void milansPaint(Graphics g, byte[] pole) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        path.reset();

        for (double t = 0; t < 10000000; t++) {
            /* path.moveTo(w, h);
             double x = w * Math.sin(5 * t) + w;
             double y = h * Math.sin(4 * t) + h;
             path.lineTo(x, y);*/
        }
        g2d.setColor(Color.blue);
        g2d.draw(path);
    }

    public static void main(String[] args) {

        int portNumber = 2233;
        String hostName = "147.32.84.225";
        short[] readA;
        short[] readB;
        short[] readC;
        short[] readD;
        int length = 10000000; //1437020 / 5;
        int count;
        int countA;
        int countB;
        int countC;
        int countD;
        byte value;
        try {
            Socket clientSocket = new Socket(hostName, portNumber);

            System.err.println("Otviram vstupy vystupy");

            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            readA = new short[length];
            readB = new short[length];
            readC = new short[length];
            readD = new short[length];
            count = 0;
            countA = 0;
            countB = 0;
            countC = 0;
            countD = 0;

            try {
                while (true) {
                    value = dis.readByte();
                    if (count % 5 == 1) {

                        readA[count / 5] = (short) (value & 0xFF);
                        System.out.println(readA[countA]);
                        countA++;
                    }
                    if (count % 5 == 2) {
                        readB[count / 5] = (short) (value & 0xFF);
                        //System.out.println(readB[countB]);
                        countB++;
                    }
                    if (count % 5 == 3) {
                        readC[count / 5] = (short) (value & 0xFF);
                        //System.out.println(readC[countC]);
                        countC++;
                    }
                    if (count % 5 == 4) {
                        readD[count / 5] = (short) (value & 0xFF);
                        //System.out.println(readD[countD]);
                        countD++;
                    }
                    //System.out.println(readB[count]);
                    count++;
                }
            } catch (EOFException exc) {/*jen pro ukonceni whilu */            }

            System.err.println("Zaviram vstupy vystupy");
            dis.close();
            clientSocket.close();
        } catch (IOException exc) {
            System.err.println("Umrel jsem na spojeni ->" + exc.getMessage());
        }
        System.out.println("cekej");

        
        /*EventQueue.invokeLater(new Runnable() {
         public void run() {
         new GraphClient().setVisible(true);
         }
         });*/
    }
}
