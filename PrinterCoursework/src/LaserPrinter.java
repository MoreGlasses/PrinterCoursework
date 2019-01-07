/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Pedro
 */

import java.util.Scanner;

public class LaserPrinter implements ServicePrinter{
    
    public Document doc;
    private String PrinterID = "";
    private Integer PaperLevel = 50;
    private Integer TonerLevel = 100;
    private Integer NumberDocumentsPrinted = 0;
    private String LaserPrinterStatus = "";
    
    private String FullDescription = "[ PrinterID: " + PrinterID + ", Paper Level: " + PaperLevel.toString() + ", Toner Level: " + TonerLevel.toString() + ", Documents Printed: " + NumberDocumentsPrinted.toString() + " ]";
    Scanner reader = new Scanner(System.in);

    public LaserPrinter(){
        
    }    
    
    public int getTonerLevel(){
        return TonerLevel;
    }
    
    public int getPaperLevel(){
        return PaperLevel;
    }
    
    public void refillPaper(){
        if(PaperLevel > 200){
            System.out.println("This printer cannot be refilled yet.");
        } else {
            PaperLevel += 50;
        }
    }
    
    public void replaceTonerCartridge(){
        if (TonerLevel <= 10){
            TonerLevel = 500;
            //wait 5 seconds before checking it can be replaced again
        } else {
            System.out.println("Toner Cartridge doesn't need to be replaced yet. Toner Level = " + TonerLevel);
        }
    }

    public void printerStatus(){
       System.out.println(LaserPrinterStatus.toString());
    }

    @Override
    public void printDocument(Document document) {
                //0 will be document pages
        if(PaperLevel > 0 && TonerLevel > 0){
            int input = document.getNumberOfPages();

            if(PaperLevel < input || TonerLevel < input){
                System.out.println("An error as occurred. You tried to print " + input + " pages but the printer only has " + PaperLevel + " Paper Level and " + TonerLevel + " Toner Level.");
            } else {
                PaperLevel = PaperLevel - input;
                TonerLevel = TonerLevel - input;
                NumberDocumentsPrinted += 1;
                System.out.println("TonerLevel = " + TonerLevel);
                System.out.println("PaperLevel = " + PaperLevel);
                System.out.println("");
            }
            
        } 
    }   
}
