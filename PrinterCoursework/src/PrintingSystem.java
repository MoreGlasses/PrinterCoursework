/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.lang.Thread;
import java.lang.ThreadGroup;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class PrintingSystem {

    private static ThreadGroup StudentGroup;
    private static ThreadGroup TechGroup;
    static List<Document> DocumentsToPrint = new ArrayList<Document>();

    public static void main(String args[])throws InterruptedException
    {
        LaserPrinter lp = new LaserPrinter();
        ThreadGroup StudentGroup = new ThreadGroup("Student Group");
        ThreadGroup TechGroup = new ThreadGroup("Technician Group");

        StudentClass Student1 = new StudentClass(1, "Student 1", StudentGroup, lp,
                new ArrayList<Document>() {
                    {
                        add(new Document(1, "LifeOfBrain", 1));
                        add(new Document(1, "TheHolyGrail", 3));
                        add(new Document(1, "FlyingCircus", 5));
                        add(new Document(1, "DawrkKnight", 2));
                        add(new Document(1, "Merlin", 8));
                    }
                });
        StudentClass Student2 = new StudentClass(2, "Student 2", StudentGroup, lp,
                new ArrayList<Document>() {
                    {
                        add(new Document(2, "LifeOfBrain", 1));
                        add(new Document(2, "TheHolyGrail", 3));
                        add(new Document(2, "FlyingCircus", 5));
                        add(new Document(2, "DawrkKnight", 2));
                        add(new Document(2, "Merlin", 8));
                    }
                });
        StudentClass Student3 = new StudentClass(3, "Student 3", StudentGroup, lp,
                new ArrayList<Document>() {
                    {
                        add(new Document(3, "LifeOfBrain", 1));
                        add(new Document(3, "TheHolyGrail", 3));
                        add(new Document(3, "FlyingCircus", 5));
                        add(new Document(3, "DawrkKnight", 2));
                        add(new Document(3, "Merlin", 8));
                    }
                });
        StudentClass Student4 = new StudentClass(4, "Student 4", StudentGroup, lp,
                new ArrayList<Document>() {
                    {
                        add(new Document(4, "LifeOfBrain", 1));
                        add(new Document(4, "TheHolyGrail", 3));
                        add(new Document(4, "FlyingCircus", 5));
                        add(new Document(4, "DawrkKnight", 2));
                        add(new Document(4, "Merlin", 8));
                    }
                });

        PaperTechnician PaperTech1 = new PaperTechnician("Pedro", 5, TechGroup, lp);
        TonerTechnician TonerTech1 = new TonerTechnician("Tio Miguel", 6, TechGroup, lp);
        Student1.run();
        Student2.run();
        Student3.run();
        Student4.run();
    }

}
