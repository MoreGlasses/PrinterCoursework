
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

    public PaperTechnician(String TechName, int TechId, ThreadGroup techGroup, LaserPrinter techPrinter, Semaphore sem) {

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

        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(techName + " : requesting Printer access");
//                System.out.println(techName + " : available Semaphore permits now: "
//                        + semaphore.availablePermits());

                semaphore.acquire();
                System.out.println(techName + " : has the Printer access!");

                try {
                    Random r = new Random();
                    System.out.println(techName + " : is attempting to refill the paper!");
//                            + ", available Semaphore permits : "
//                            + semaphore.availablePermits());

                    refillPaper();
                    System.out.println("");
                    sleep(5);

                } finally {

                    // calling release() after a successful acquire()
                    System.out.println(techName + " : releasing lock...");
                    semaphore.release();
//                    System.out.println(techName + " : available Semaphore permits now: "
//                            + semaphore.availablePermits());

                }
            }
            System.out.println("The Paper Technician has refilled the Paper Sheets and is heading home for the day.");
        } catch (InterruptedException e) {

            e.printStackTrace();

        }
    }

}
