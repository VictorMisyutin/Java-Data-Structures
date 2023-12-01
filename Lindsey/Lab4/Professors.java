import java.util.Iterator;
//iterables class is parent class
public class Professors implements Iterable<String> {
    
    private class ProfessorIterator implements Iterator<String> {
        private Professors profs;
        private int index;
        ProfessorIterator(Professors profs){
            this.profs = profs;
            this.index = 0;

        }
        public boolean hasNext(){
            if (this.index < this.profs.names.length){
                return true;
            }
            return false;
        }
        public String next(){
            String prof = "Professor " + this.profs.names[index];
            index++;
            return prof;
        }

    }

    public Iterator<String> iterator() {
        return new ProfessorIterator(this);
    }


//instance vatiable
    private String[] names;
    Professors(String[] names) {
        //makes list copy of names
        this.names = names.clone();
    }
    
    public static void main(String[] args){
        String[] names = new String[] {
            "Eck", 
            "Feldman", 
            "Levinson", 
            "Taylor"
        };
        
        Professors profs = new Professors(names);
        for (String prof : profs) {
            System.out.println(prof);
        }

    }
    
}
