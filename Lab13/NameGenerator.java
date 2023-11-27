package Lab13;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;  

public class NameGenerator {
    public static void main(String[] args) {
        final String inputFileName = "names.dat"; // name of input file
        String inputText = "";
        String[] peoples = {"Bob","Carol","Ted","Alice", "Victor", "Kassie", "Ben", 
                            "Lorenzo", "Adil", "Ria", "Amaryllis", "Diego", "Zach", "Julia", 
                            "Cindy", "Tyson", "Kira", "Oscar", "Lucy", "Finn", "Jared", "Will"}; // list of names
        List<String> names = Arrays.asList(peoples); //turn into list
        for(int i = 0; i < 10; i++){
            Collections.shuffle(names); // shuffle list
            for (String name : names) { 
                inputText = inputText + name + " "; // create input text 
            }   
            inputText += "\n";
        }

        // place names in a file
        try{
            File inputFile = new File(inputFileName); // creates file oject with input file name
            FileWriter fileWriter = new FileWriter(inputFileName); // create file writer object with input file name
            inputFile.createNewFile(); // creates new file if does not exist already
            fileWriter.write(inputText); // write input text into file
            fileWriter.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        // read names from file and display data
        try {
            File myObj = new File(inputFileName);
            Scanner myReader = new Scanner(myObj);
            int dupeCount = 0;
            HashMap<String,Integer> dupeMap = new HashMap<>();
            int i = 1;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] namesArr = data.split(" "); 
                for(String name : namesArr){ // find the duplicates on each line
                    if(dupeMap.containsKey(name)){
                        dupeMap.put(name, dupeMap.get(name)+1);
                        dupeCount++;
                    }
                    else{
                        dupeMap.put(name, 0);
                    }
                }
                List<String> noDupsList = new ArrayList<>(new HashSet<>(Arrays.asList(data.split(" ")))); // remove duplicates using hashset
                Collections.sort(noDupsList); // sort names list
                System.out.println("Line " + i + ": ");
                for (String name : noDupsList) { // print out sorted names with no duplicates
                    System.out.print(name + " ");
                }
                System.out.println();
                i++;
            }
            System.out.println("Number of duplicates found: " + dupeCount);
            System.out.println("Duplicate count by name");

            for(java.util.Map.Entry<String, Integer> entry : dupeMap.entrySet()){
                System.out.println(entry.getKey() + ": " + entry.getValue() + " duplicates");
            }

            myReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
