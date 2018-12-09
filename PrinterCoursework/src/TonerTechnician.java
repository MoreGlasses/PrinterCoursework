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
import java.lang.ThreadGroup;

public class TonerTechnician extends Thread implements ServicePrinter {    
    
    //Properties
    private int techID;
    private String techName;
    private ThreadGroup threadGroup;
    private Printer printer;
    
    
    public TonerTechnician(){
        //cenas
    }

    @Override
    public void printDocument(Document document) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void replaceTonerCartridge() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void refillPaper() {
        
    }
    
    
    
}