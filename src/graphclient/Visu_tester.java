/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphclient;

import java.awt.GridLayout;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class Visu_tester {

    public static void main(String[] args) {
        //Ziskani a vykresleni dat
        InputFacade readedData = Client();
        int step=1;

        JPanel_vizu panelA = new JPanel_vizu(readedData.canalA,step);
        JPanel_vizu panelB = new JPanel_vizu(readedData.canalB,step);
        JPanel_vizu panelC = new JPanel_vizu(readedData.canalC,step);
        JPanel_vizu panelD = new JPanel_vizu(readedData.canalD,step);

        //prace s okenkem
        JFrame f = new JFrame("Vykresleni dat");
        f.setSize(800, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(true);

        JPanel main = new JPanel(new GridLayout(4, 1));

        //pridani panelu
        main.add(panelA);
        main.add(panelB);
        main.add(panelC);
        main.add(panelD);

        f.add(main);

        f.setVisible(true);
        f.repaint();
    }

    @SuppressWarnings("empty-statement")
    public static InputFacade Client() {

        int portNumber = 2233;
        String hostName = "147.32.84.225";
        InputFacade readVector = new InputFacade();

        int count;
        byte value;
        try {
            Socket clientSocket = new Socket(hostName, portNumber);
            System.err.println("Otviram vstupy vystupy");
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            count = 0;
            try {
                while (true) {
                    value = dis.readByte();
                    if (count % 5 == 1) {
                        readVector.canalA.add((short) (value & 0xFF));
                    }
                    if (count % 5 == 2) {
                        readVector.canalB.add((short) (value & 0xFF));
                    }
                    if (count % 5 == 3) {
                        readVector.canalC.add((short) (value & 0xFF));
                    }
                    if (count % 5 == 4) {
                        readVector.canalD.add((short) (value & 0xFF));
                    }
                    count++;
                }
            } catch (EOFException exc) {/*jen pro ukonceni whilu */            } finally {
                System.err.println("Zaviram vstupy vystupy");
                dis.close();
                clientSocket.close();
            }
        } catch (IOException exc) {
            System.err.println("Umrel jsem na spojeni ->" + exc.getMessage());
        }
        System.out.println("Data zpravovana");
        return (readVector);
    }
}
