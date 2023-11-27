package Lab13;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;  
import java.util.Scanner;
import java.util.Map.Entry;

public class NameGenerator {
    public static void main(String[] args) {
        final String fileName = "names.dat"; // name of input file
        String inputText = "";
        String[] peoples = {"Bob","Carol","Ted","Alice", "Victor", "Kassie", "Ben", 
                            "Lorenzo", "Adil", "Ria", "Amaryllis", "Diego", "Zach", "Julia", 
                            "Cindy", "Tyson", "Kira", "Oscar", "Lucy", "Finn", "Jared", "Will"}; // list of names
        List<String> names = Arrays.asList(peoples); //turn into list
        for(int i = 0; i < 10; i++){
            Collections.shuffle(names); // shuffle list
            for (int j = 0; j < 10; j++) { 
                inputText = inputText + names.get(j) + " "; // create input text 
            }   
            inputText += "\n";
        }

        try{
            // place names in a file
            File file = new File(fileName); // creates file oject with input file name
            FileWriter fileWriter = new FileWriter(fileName); // create file writer object with input file name
            file.createNewFile(); // creates new file if does not exist already
            fileWriter.write(inputText); // write input text into file
            fileWriter.close();

            System.out.println();
            
            // read from file
            Scanner fileReader = new Scanner(file); // create scanner to read from file
            String line = ""; // each line in file
            Hashtable<String, Integer> dups = new Hashtable<>(); // stores how many duplicates of each word
            int dupCount = 0; // stores number of duplicate names
            while(fileReader.hasNextLine()){ // iterate through data file
                line = fileReader.nextLine(); // get current line
                String[] newNames = line.split(" "); // turn line of names into array
                List<String> newNamesList = Arrays.asList(newNames);
                System.out.println("-----------LIST-------------" + newNamesList);
                for(String name: newNames){ // find the number of duplicates
                    if(dups.containsKey(name)){
                        dups.put(line, dups.get(name) + 1);
                        dupCount++;
                    }
                    else{
                        dups.put(name, 0);
                    }
                }
                List<String> noDupsList = new ArrayList<>(new HashSet<>(newNamesList)); // remove duplicates using hashset
                Collections.sort(noDupsList); // sort names list
                for (String n : noDupsList) { // print out sorted names with no duplicates
                    System.out.print(n + " ");
                }
                System.out.println();
            }

            // System.out.println("Numbet of duplicates: " + dupCount);
            // System.out.println("Number of duplicates by name:");

            // for (Entry<String, Integer> entry : dups.entrySet()) {
            //     System.out.println (entry.getKey() + ": " + entry.getValue());
            // }

        }
        catch(IOException e){
            e.printStackTrace();
        }

        


        // // code for removing duplicates
        // System.out.println();
        // List<String> noDupsList = new ArrayList<>(new HashSet<>(names)); // remove duplicates using hashset
        // Collections.sort(noDupsList); // sort names list
        // for (String name : noDupsList) { // print out sorted names with no duplicates
        //     System.out.println(name + " ");
        // }
    }
}