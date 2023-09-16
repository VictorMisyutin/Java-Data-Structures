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
        // String is the animal and first integer in the list is the bonus health
        //  and the second number is the new max distance the player can travel 
        HashMap<String, List<Integer>> animalMap= new HashMap<>();
        animalMap.put("dog", Arrays.asList(70,45));
        animalMap.put("cat", Arrays.asList(60,42));
        animalMap.put("bird", Arrays.asList(40,39));
        animalMap.put("wolf", Arrays.asList(112,49));
        animalMap.put("horse", Arrays.asList(98, 120));
        animalMap.put("mule", Arrays.asList(91, 137));
        animalMap.put("hedgehog", Arrays.asList(26, 29));
        animalMap.put("griffin", Arrays.asList(150, 150));
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
        // variable to use to supplement player / game interaction
        int randInteract = 0;
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
                Integer bonusHealth = animalMap.get(animal).get(0);
                maxDistance = animalMap.get(animal).get(1);

                System.out.println("You see a wild " + animal + " and you tried to tame it.");
                if(randomGen.nextBoolean() == true){
                    System.out.println("You succesfully tamed the " + animal + ".");
                    System.out.println("You gained " + bonusHealth + " health.");
                    System.out.println("You will now travel faster.");
                    health += bonusHealth;
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
                randDistToMove = 1 + randomGen.nextInt(maxDistance);
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