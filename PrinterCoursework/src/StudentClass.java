import java.lang.ThreadGroup;

public class StudentClass extends Thread implements ServicePrinter
//This is threadable
{

    //Use the Document class.
    //Represent a document that students request the printer to be printed.
    private Document studentDocument;
    private int studentID;
    private String studentName ="";
    private ThreadGroup threadGroup = 0;
    private String printerBeingUsed;
    

    

    public StudentClass(int ID,String Name,ThreadGroup ThreadGroup,String PrinterName,String DocumentName, int PagesAmount){
        studentID = ID;
        studentName = Name;
        threadGroup = ThreadGroup;
        printerBeingUsed = PrinterName;
        studentDocument = new Document(studentID,DocumentName,PagesAmount);
        printDocument(studentDocument);
    }


    //Interface Methods
    @Override
    public void replaceTonerCartridge() {
        throw new UnsupportedOperationException("Students don't replace toners"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void refillPaper() {
        throw new UnsupportedOperationException("Students don't refill paper"); //To change body of generated methods, choose Tools | Templates.
    }
    //TODO: This needs to be rethinked
    public void printDocument(Document document) {
        //When a print is issued a thread starts a request to the printer a print action

        ServicePrinter.printDocument(document);
    }


    



















}