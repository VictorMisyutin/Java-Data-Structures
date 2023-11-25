package Lab13;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.io.File; 
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

        


        // // code for removing duplicates
        // System.out.println();
        // List<String> noDupsList = new ArrayList<>(new HashSet<>(names)); // remove duplicates using hashset
        // Collections.sort(noDupsList); // sort names list
        // for (String name : noDupsList) { // print out sorted names with no duplicates
        //     System.out.println(name + " ");
        // }
    }
}