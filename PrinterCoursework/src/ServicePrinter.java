/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro
 */
//This interface defines the complete interface to the printer for both students and technicians. 

public interface ServicePrinter extends Printer
{

    

    public final int Full_Paper_Tray  = 250 ;
    public final int Full_Toner_Level = 500 ;

    public final int Minimum_Toner_Level = 10 ;

    public final int SheetsPerPack = 50 ;

    public final int PagesPerTonerCartridge = 500 ;

    //Student Methods
    //public void printDocument( Document document ) ;

    // Technician methods
    public void replaceTonerCartridge( ) ;

    public void refillPaper( ) ;
    
} // ServicePrinter
