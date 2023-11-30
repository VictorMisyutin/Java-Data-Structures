/**
 * A virtual Cat.  Will need to implement a constructor and the abstract methods from Animal.
 * 
 * @author Your name here
 */

public class Cat extends Animal {
    
    public Cat(String name){
        super(name);
    }

    public void speak(){
        System.out.println(name + " says meow.");
    }

    public void play(){
        System.out.println(name + " watches the birds.");
    }
    
}
