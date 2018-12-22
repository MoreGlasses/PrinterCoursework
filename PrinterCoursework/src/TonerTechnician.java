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
    private int techId;
    private String techName;
    private ThreadGroup assignedGroup;
    private LaserPrinter AssignedPrinter;
    
    
    public TonerTechnician(String TechName,int TechId, ThreadGroup techGroup, LaserPrinter techPrinter){
        
        techName = TechName;
        techId = TechId;
        assignedGroup = techGroup;
        AssignedPrinter = techPrinter;
        
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
  
    
    
    
}