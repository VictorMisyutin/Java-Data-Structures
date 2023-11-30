/**
 * A virtual dog
 * 
 * @author Cynthia Taylor
 */

public class Dog extends Animal{


    public Dog(String name){
        super(name);
    }

    public void speak(){
        System.out.println(name + " says woof woof.");
    }

    public void play(){
        System.out.println(name + " chases the stick.");
    }
    
}
