/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.lang.Thread;
import java.lang.ThreadGroup;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.Queue;
import java.util.LinkedList;

/**
 *
 * @author Pedro
 */
public class PrintingSystem {

    private static ThreadGroup StudentGroup;
    private static ThreadGroup TechGroup;
    static List<Document> DocumentsToPrint = new ArrayList<Document>();

    public static void main(String args[]) throws InterruptedException {
        LaserPrinter lp = new LaserPrinter();
        ThreadGroup StudentGroup = new ThreadGroup("Student Group");
        ThreadGroup TechGroup = new ThreadGroup("Technician Group");
        Semaphore semaphore = new Semaphore(1);

        StudentClass Student1 = new StudentClass(1, "Student 1", StudentGroup, lp, semaphore,
                new LinkedList<Document>() {
            {
                add(new Document(1, "1A", 10));
                add(new Document(1, "1B", 10));
                add(new Document(1, "1C", 10));
                add(new Document(1, "1D", 10));
                add(new Document(1, "1E", 10));
            }
        });
        StudentClass Student2 = new StudentClass(2, "Student 2", StudentGroup, lp, semaphore,
                new LinkedList<Document>() {
            {
                add(new Document(2, "2A", 10));
                add(new Document(2, "2B", 10));
                add(new Document(2, "2C", 10));
                add(new Document(2, "2D", 10));
                add(new Document(2, "2E", 10));
            }
        });
        StudentClass Student3 = new StudentClass(3, "Student 3", StudentGroup, lp, semaphore,
                new LinkedList<Document>() {
            {
                add(new Document(3, "3A", 10));
                add(new Document(3, "3B", 10));
                add(new Document(3, "3C", 10));
                add(new Document(3, "3D", 10));
                add(new Document(3, "3E", 10));
            }
        });
        StudentClass Student4 = new StudentClass(4, "Student 4", StudentGroup, lp, semaphore,
                new LinkedList<Document>() {
            {
                add(new Document(4, "4A", 10));
                add(new Document(4, "4B", 10));
                add(new Document(4, "4C", 10));
                add(new Document(4, "4D", 10));
                add(new Document(4, "4E", 10));
            }
        });

        PaperTechnician PaperTech1 = new PaperTechnician("Paper Man", 5, TechGroup, lp, semaphore);
        TonerTechnician TonerTech1 = new TonerTechnician("Toner Man", 6, TechGroup, lp, semaphore);
        
        //Student Thread stops after only 1 print
            Student1.start();
            Student2.start();
            Student3.start();
            Student4.start();
            PaperTech1.start();
            TonerTech1.start();
    }
}
