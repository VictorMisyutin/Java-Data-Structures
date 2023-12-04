package Lab15;
import java.util.ArrayList;

public class Instructors{
    enum Location{
        NORTH,
        EAST,
        SOUTH,
        WEST
    }
    enum Level{
        BEGINNER,
        INTERMEDIATE,
        ADVANCED
    }

    private int budget;
    private Location classLocation;
    private Level knowledgeLevel;
    private ArrayList<String> materials;

    public Instructors(){
        budget = 2000;
        classLocation = Location.NORTH;
        knowledgeLevel = Level.BEGINNER;
        materials = new ArrayList<>();
    }
    public Instructors(int budget, Location location, Level KL){
        this.budget = budget;
        classLocation = location;
        knowledgeLevel = KL;
        materials = new ArrayList<>();
    }

    public ArrayList<String> getMaterials(){
        return materials;
    }

    public void addMaterial(String item){
        materials.add(item);
    }

    public void removeMaterialByIndex(int i){
        materials.remove(i);
    }

    public int getBudget(){
        return budget;
    }

    public Location getLocation(){
        return classLocation;
    }

    public Level getKnowledgeLevel(){
        return knowledgeLevel;
    }
}
