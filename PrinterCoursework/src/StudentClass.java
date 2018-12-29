
import java.lang.Thread;
import java.lang.ThreadGroup;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class StudentClass extends Thread implements Printer //This is threadable
{

    //Use the Document class.
    //Represent a document that students request the printer to be printed.
    private List<Document> studentDocuments;
    private int studentID;
    private String studentName = "";
    private ThreadGroup threadGroup;
    private LaserPrinter AssignedPrinter;
    private static Semaphore semaphore = new Semaphore(1);

    public StudentClass(int ID, String Name, ThreadGroup ThreadGroup, LaserPrinter studentPrinter, List<Document> StudentDocs) {
        studentID = ID;
        studentName = Name;
        threadGroup = ThreadGroup;
        AssignedPrinter = studentPrinter;
        studentDocuments = StudentDocs;
    }

    @Override
    public void printDocument(Document document) {
        //When a print is issued a thread starts a request to the printer a print action
        AssignedPrinter.printDocument(document);
    }

    public void run() {

        try {

            System.out.println(studentName + " : acquiring lock...");
            System.out.println(studentName + " : available Semaphore permits now: "
                    + semaphore.availablePermits());

            semaphore.acquire();
            System.out.println(studentName + " : got the permit!");

            try {

                for (int i = 1; i <= 5; i++) {

                    System.out.println(studentName + " : is performing operation " + i
                            + ", available Semaphore permits : "
                            + semaphore.availablePermits());

                    // sleep 1 second
                    Thread.sleep(1000);

                }

            } finally {

                // calling release() after a successful acquire()
                System.out.println(studentName + " : releasing lock...");
                semaphore.release();
                System.out.println(studentName + " : available Semaphore permits now: "
                        + semaphore.availablePermits());

            }

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

    }

//    @Override
//    public void run() {
//        /*
//         Create and print five documents with different lengths and names.
//         He/she should "sleep" for a random amount of time between each printing request.
//         When he/she has finished printing, print out a message. 
//         */
//
//
//        for (Document d : studentDocuments) {
//            Random r = new Random();
//            printDocument(d);
//            try{
//            sleep(r.nextInt(10)*1000);
//            }
//            catch(Exception e){
//                throw new UnsupportedOperationException("Not supported yet.");
//        }
//            
//        System.out.println("Printing done for student "+studentName);
//        System.out.println("");
//    }
//    }
}
