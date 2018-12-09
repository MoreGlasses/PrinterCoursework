import java.lang.Thread;
import java.lang.ThreadGroup;

public class StudentClass extends Thread implements Printer
//This is threadable
{

    //Use the Document class.
    //Represent a document that students request the printer to be printed.
    private Document studentDocument;
    private int studentID;
    private String studentName ="";
    private ThreadGroup threadGroup;
    private String printerBeingUsed;
    

    

    public StudentClass(int ID,String Name,ThreadGroup ThreadGroup,String PrinterName,String DocumentName, int PagesAmount){
        studentID = ID;
        studentName = Name;
        threadGroup = ThreadGroup;
        printerBeingUsed = PrinterName;
        studentDocument = new Document(studentID,DocumentName,PagesAmount);
        printDocument(studentDocument);
    }


    @Override
    public void printDocument(Document document) {
        //When a print is issued a thread starts a request to the printer a print action
        
    }
}