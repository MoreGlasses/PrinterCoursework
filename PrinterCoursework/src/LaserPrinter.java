/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Pedro
 */
public class LaserPrinter implements ServicePrinter{
    
    public Document doc;
    private String PrinterID = "";
    private Integer PaperLevel = 10;
    private Integer TonerLevel = 10;
    private Integer NumberDocumentsPrinted = 0;
    
    private String FullDescription = "[ PrinterID: " + PrinterID + ", Paper Level: " + PaperLevel.toString() + ", Toner Level: " + TonerLevel.toString() + ", Documents Printed: " + NumberDocumentsPrinted.toString() + " ]";
    
    public LaserPrinter(Document Doc){
        this.doc = Doc;
        System.out.println(FullDescription); 
    }
    
    public void printDocument(){
       
        //0 will be document pages
        if(PaperLevel > 0 && TonerLevel > 0){
            System.out.println("Prints Document");
        } 
    }
    
    public void refillPaper(){
        
    }
    
    public void replaceTonerCartridge(){
        
    }

    @Override
    public void printDocument(Document document) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
