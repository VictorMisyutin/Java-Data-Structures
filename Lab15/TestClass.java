package Lab15;

import java.util.ArrayList;
import Lab15.Instructors.Level;
import Lab15.Instructors.Location;

public class TestClass {
    public static void main(String[] args){
        Instructors instructor = new Instructors();
        Spartans spartan = new Spartans();
        Athenians athenian = new Athenians();
        instructor.addMaterial("Texts");
        spartan.addMaterial("Computers");
        athenian.addMaterial("Software");

        int totalBudget = instructor.getBudget() + spartan.getBudget() + athenian.getBudget();
        ArrayList<String> allMaterials = new ArrayList<>();
        allMaterials.addAll(instructor.getMaterials());
        allMaterials.addAll(spartan.getMaterials());
        allMaterials.addAll(athenian.getMaterials());
        
        System.out.println("Instructor Budget: " + instructor.getBudget() + "\nInstructor class location: " + instructor.getLocation() + "\nInstructor knowledge level: " + instructor.getKnowledgeLevel() + "\n");
        System.out.println("Spartan Budget: " + spartan.getBudget() + "\nSpartan class location: " + spartan.getLocation() + "\nSpartan knowledge level: " + spartan.getKnowledgeLevel() + "\n");
        System.out.println("Athenian Budget: " + athenian.getBudget() + "\nAthenian class location: " + athenian.getLocation() + "\nAthenian knowledge level: " + athenian.getKnowledgeLevel() + "\n");
        
        System.out.println("Total teaching budget allocation for each teacher: $"+totalBudget + "\n");
        System.out.println("Location areas for each instructor:\n" 
            + Location.EAST + " location occupancy for Spartans instructors\n"
            + Location.WEST + " location for occupanct for Athenian instructors\n"
            + Location.NORTH + " location for standard instructors\n"
            + Location.SOUTH + " location for standard instructors\n");

        System.out.println("Levels of knowledge-\n" + Level.BEGINNER + "\n" + Level.INTERMEDIATE + "\n" + Level.ADVANCED + "\n");

        System.out.println("Teaching materials needed-");
        for (String material : allMaterials) {
            System.out.println(material);
        }

        


    }
}
