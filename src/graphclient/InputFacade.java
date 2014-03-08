/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphclient;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Milan
 */
 public class InputFacade
    {
        private static List <Short> canalA = new ArrayList <> ();
        private static List <Short> canalB= new ArrayList <> ();
        private static List <Short> canalC= new ArrayList <> ();
        private static List <Short> canalD= new ArrayList <> ();
        
        /**
         *
         * @param canalA
         * @param canalB
         * @param canalC
         * @param canalD
         */
        public static void InitialInputFacade(List <Short> canalA,
                                            List <Short> canalB,
                                            List <Short> canalC,
                                            List <Short> canalD)
        {
            InputFacade.canalA=canalA;
            InputFacade.canalB=canalB;
            InputFacade.canalC=canalC;
            InputFacade.canalC=canalC;
        }
        
        
    
    }
