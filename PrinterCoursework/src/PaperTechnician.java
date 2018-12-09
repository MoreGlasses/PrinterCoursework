import java.lang.Thread;
import java.lang.ThreadGroup;

public class PaperTechnician extends Thread implements ServicePrinter {    
    
    //Properties
    private int techID;
    private String techName;
    private ThreadGroup threadGroup;
    private Printer printer;
    
    
    public PaperTechnician(){
        //cenas
    }




    @Override
    public void refillPaper() {
        //Refill the paper
    }

    @Override
    public void replaceTonerCartridge() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printDocument(Document document) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}