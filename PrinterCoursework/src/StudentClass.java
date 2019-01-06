
import java.lang.Thread;
import java.lang.ThreadGroup;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.Queue;

public class StudentClass extends Thread implements Printer //This is threadable
{

    //Use the Document class.
    //Represent a document that students request the printer to be printed.
    private Queue<Document> studentDocuments;
    private int studentID;
    private String studentName = "";
    private ThreadGroup threadGroup;
    private LaserPrinter AssignedPrinter;
    private static Semaphore semaphore;

    public StudentClass(int ID, String Name, ThreadGroup ThreadGroup, LaserPrinter studentPrinter, Semaphore sem, Queue<Document> StudentDocs) {
        studentID = ID;
        studentName = Name;
        threadGroup = ThreadGroup;
        AssignedPrinter = studentPrinter;
        semaphore = sem;
        studentDocuments = StudentDocs;
        //
    }

    @Override
    public void printDocument(Document document) {
        //When a print is issued a thread starts a request to the printer a print action
        AssignedPrinter.printDocument(document);
    }

    public void run() {

        try {
            while (!studentDocuments.isEmpty()) {
                System.out.println(studentName + " : requesting Printer access");
//                System.out.println(studentName + " : available Semaphore permits now: "
//                        + semaphore.availablePermits());

                semaphore.acquire();
                System.out.println(studentName + " : has the Printer access!");

                try {
                    Random r = new Random();
                    System.out.println(studentName + " : is printing " + studentDocuments.element().getDocumentName() + " that has " + studentDocuments.element().getNumberOfPages() + " number of pages");
//                    + ", available Semaphore permits : "
//                            + semaphore.availablePermits());
                    if(AssignedPrinter.getTonerLevel() < studentDocuments.element().getNumberOfPages() || AssignedPrinter.getPaperLevel() < studentDocuments.element().getNumberOfPages()){
                        System.out.println("Not enough Toner Level or Paper Level to print Document " + studentDocuments.element().getDocumentName());
                        sleep(r.nextInt(10) * 1000);
                    } else {
                        System.out.println(studentName + " has printed Document " + studentDocuments.element().getDocumentName());
                        printDocument(studentDocuments.remove());
                        sleep(r.nextInt(10) * 1000);
                    }
                    

                } finally {

                    // calling release() after a successful acquire()
                    System.out.println(studentName + " : releasing lock...");
                    semaphore.release();
//                    System.out.println(studentName + " : available Semaphore permits now: "
//                            + semaphore.availablePermits());

                }
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
