/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphclient;


import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class Visu_tester {
    
    public static void main(String[] args)
    {
        //Ziskani a vykresleni dat
        InputFacade readedData = Client();
        Jframe_vizu panelA = new Jframe_vizu(readedData.canalA);
//        Jframe_vizu panelB = new Jframe_vizu(readedData.canalB);
//        Jframe_vizu panelC = new Jframe_vizu(readedData.canalC);
//        Jframe_vizu panelD = new Jframe_vizu(readedData.canalD);
//        
        //prace s okenkem
        JFrame f = new JFrame("Vykresleni dat");
        f.setSize(800, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(true);
        
        //nastavovani layoutu
        BorderLayout b = new BorderLayout();
        f.setLayout(b);
        f.add(panelA,b.CENTER);
//        f.add(panelB,b.NORTH);
//        f.add(panelC,b.SOUTH);
//        f.add(panelD,b.SOUTH);
        
        
        f.setVisible(true);
    }
    
    /**
     *
     * @return
     */
    @SuppressWarnings("empty-statement")
    public static InputFacade Client ()
    {
        
         int portNumber = 2233;
        String hostName = "147.32.84.225";
        InputFacade readVector = new InputFacade();
//        List <Short> readA = new ArrayList <> ();
//        List <Short> readB= new ArrayList <> ();
//        List <Short> readC= new ArrayList <> ();
//        List <Short> readD= new ArrayList <> ();

        int count;
//        
//        int countA;
//        int countB;
//        int countC;
//        int countD;
        byte value;
        try {
            Socket clientSocket = new Socket(hostName, portNumber);

            System.err.println("Otviram vstupy vystupy");

            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());

            count = 0;
//            Inicializace kontrolnich counteru
//            countA = 0;
//            countB = 0;
//            countC = 0;
//            countD = 0;

            try {
                while (true) {
                    value = dis.readByte();
                    if (count % 5 == 1) {
                        readVector.canalA.add((short)(value & 0xFF));
//                        Vypis a pripocet kontrolniho countu
//                        System.out.println(readA[countA]);
//                        countA++;
                    }
                    if (count % 5 == 2) {
                        readVector.canalB.add((short)(value & 0xFF));
                        //System.out.println(readB[countB]);
//                        countB++;
                    }
                    if (count % 5 == 3) {
                        readVector.canalC.add((short)(value & 0xFF));
                        //System.out.println(readC[countC]);
//                        countC++;
                    }
                    if (count % 5 == 4) {
                        readVector.canalD.add((short)(value & 0xFF));
                        //System.out.println(readD[countD]);
//                        countD++;
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
        System.out.println("Data zpravovana");
        return (readVector);
    } 
    
   
}
