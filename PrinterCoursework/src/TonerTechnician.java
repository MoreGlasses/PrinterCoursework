/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro
 */
 
// Define a class to represent a technician that replaces the printer's toner cartridge, called
// TonerTechnician.
// This class is very similar to the paper technician class, except it attempts to replace the toner
// three times, using the printer's replaceTonerCartridge( ) method. 

import java.lang.Thread;
import static java.lang.Thread.sleep;
import java.lang.ThreadGroup;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class TonerTechnician extends Thread implements ServicePrinter {    
    
    //Properties
    private int techId;
    private String techName;
    private ThreadGroup assignedGroup;
    private LaserPrinter AssignedPrinter;
    private static Semaphore semaphore;
    
    public TonerTechnician(String TechName,int TechId, ThreadGroup techGroup, LaserPrinter techPrinter,Semaphore sem){
        
        techName = TechName;
        techId = TechId;
        assignedGroup = techGroup;
        AssignedPrinter = techPrinter;
        semaphore = sem;
    }

    @Override
    public void printDocument(Document document) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
     public void replaceTonerCartridge() {
        AssignedPrinter.replaceTonerCartridge();
    }

    @Override
    public void refillPaper() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
        @Override
    public void run() {
        /*
         Attempt to refill the printer's paper trays three times, using the printer's
         refillPaper( ) method.
         He/she should "sleep" for a random amount of time between each attempt to refill the
         paper.
         When he/she has finished trying to refill the paper, print out a message.     
         */
        while (true) {
            Random r = new Random();
            for (int i = 0; i < 3; i++) {
                try {
                    replaceTonerCartridge();
                    sleep(r.nextInt(5) * 1000);
                } catch (Exception e) {

                }
            }
        }
    }
    
    
}