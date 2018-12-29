
import java.lang.Thread;
import java.lang.ThreadGroup;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class PaperTechnician extends Thread implements ServicePrinter {

    //Properties
    private int techId;
    private String techName;
    private ThreadGroup assignedGroup;
    private LaserPrinter AssignedPrinter;
    private static Semaphore semaphore;

    public PaperTechnician(String TechName, int TechId, ThreadGroup techGroup, LaserPrinter techPrinter,Semaphore sem) {

        techName = TechName;
        techId = TechId;
        assignedGroup = techGroup;
        AssignedPrinter = techPrinter;
        semaphore = sem;
    }

    @Override
    public void refillPaper() {
        AssignedPrinter.refillPaper();
    }

    @Override
    public void replaceTonerCartridge() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printDocument(Document document) {
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
        Random r = new Random();
        for (int i = 0; i < 3; i++ ) {
            try
            {
                refillPaper();
                sleep(r.nextInt(10)*1000);
            } 
            catch (Exception e) 
            {
                
            }
        }
    }

}
