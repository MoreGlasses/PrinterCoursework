
import java.lang.Thread;
import java.lang.ThreadGroup;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class StudentClass extends Thread implements Printer //This is threadable
{

    //Use the Document class.
    //Represent a document that students request the printer to be printed.
    private List<Document> studentDocuments;
    private int studentID;
    private String studentName = "";
    private ThreadGroup threadGroup;
    private LaserPrinter AssignedPrinter;

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

    @Override
    public void run() {
        /*
         Create and print five documents with different lengths and names.
         He/she should "sleep" for a random amount of time between each printing request.
         When he/she has finished printing, print out a message. 
         */


        for (Document d : studentDocuments) {
            Random r = new Random();
            printDocument(d);
            try{
            sleep(r.nextInt(10)*1000);
            }
            catch(Exception e){
                throw new UnsupportedOperationException("Not supported yet.");
        }
            
        System.out.println("Printing done for student "+studentName);
        System.out.println("");
    }
    }
}
