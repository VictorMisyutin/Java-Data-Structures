import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Arrays;

public class SeizeTheStation
{
    public static void main(String args[])
    {
        // Create HashMap of random animals
        HashMap<String, List<Integer>> animalMap= new HashMap<>();
        // String is the animal and first integer in the list is the bonus health
        //  and the second number is the bonus distance 
        animalMap.put("dog", Arrays.asList(90,85));
        animalMap.put("cat", Arrays.asList(95,69));
        animalMap.put("bird", Arrays.asList(80,81));
        animalMap.put("wolf", Arrays.asList(112,78));
        animalMap.put("horse", Arrays.asList(98, 170));
        animalMap.put("mule", Arrays.asList(91, 150));
        animalMap.put("hedgehog", Arrays.asList(100, 67));
        animalMap.put("griffin", Arrays.asList(150, 200));
        List<String> keyList = new ArrayList<>(animalMap.keySet());
        
        // max distance player can travel in one turn
        int maxDistance = 20;
        // declare a Scanner class object and Random class object
        Scanner scan = new Scanner(System.in);
        Random randomGen = new Random();
        // variable to decrease distance to target
        int randAddDist = 0;
        // variable to track remaining distance to target
        int randDistToMove = 0;
        // variable to define player obstacle
        char interact = '\0';
        // variable to allow player to proceed to target
        char again = '\0';
        // variable to set initial distance to goal
        int goal = 300;
        // variable to set initial player health
        int health = 100;
        // variable to count number of loops
        int loopCount = 0;
        // variable to see total distance traveled
        int distanceTraveled = 0;
        // while loop variable
        boolean continueLoop = true;
        // define a loop for at most twenty actions
        while (continueLoop)
        {
            loopCount++;
            // determine if player will be joined by a companion
            if (loopCount == 6) {
                System.out.println("\n-----------------------------------\n");
                String animal = keyList.get(randomGen.nextInt(8));
                
                System.out.println("You see a wild " + animal + " and you tried to tame it.");
                if(randomGen.nextBoolean() == true){
                    int bonusHealth = animalMap.get(animal).get(0);
                    randAddDist = animalMap.get(animal).get(1);
                    System.out.println("You succesfully tamed the " + animal + ".");
                    System.out.println("You gained " + bonusHealth + " health and\ntraveled an extra " + randAddDist + " feet.");
                    health += bonusHealth;
                    distanceTraveled += randAddDist;
                }
                else{
                    System.out.println("You startled the " + animal + " and it ran away.");
                }
            
            }
            System.out.println("\n-----------------------------------");
            System.out.println("\nAre you ready to proceed? ( Y or N )");
            again = scan.next().charAt(0);
            if (again != 'Y') break;
            // signal the intention of the player
            // define an obstacle
            interact = (char)(randomGen.nextInt(26) + 'a');
            if (interact >= 'a' && interact <= 'm')
            {
                // random number sets distance to move toward the objective
                randDistToMove = 1 + randomGen.nextInt(20);
                distanceTraveled += randDistToMove;
                System.out.println("move forward " + randDistToMove + " ft");
            }
            else
            {
                System.out.println("circumvent the next obstacle");
                health -= 10;
            }
            if(health < 0){
                continueLoop = false;
                System.out.println("\nYou ran out of health and have passed out.");
            }
            else if(distanceTraveled >=300){
                continueLoop = false;
                System.out.println("\nCongratulaions you reached the objective.");
            }
        }
        System.out.println("You are " + (goal>distanceTraveled ?  goal-distanceTraveled : 0) + " feet away from the objective.");
        System.out.println("You finished with " + (health>0 ?  health : 0) + " health.");
        System.out.println("You completed " + (loopCount) + " loops");
    }
}