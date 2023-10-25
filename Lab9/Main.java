package Lab9;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String args[]) {
        PriorityQueue<Flight> flights = new PriorityQueue<Flight>(10, new SortQueue());
        flights.add(new Flight(new Data("0001", 2002), 1));
        flights.add(new Flight(new Data("0002", 200), 1));
        flights.add(new Flight(new Data("0003", 330), 2));
        flights.add(new Flight(new Data("0004", 300), 3));
        flights.add(new Flight(new Data("0005", 200), 1));
        flights.add(new Flight(new Data("0006", 550), 1));
        flights.add(new Flight(new Data("0007", 3000), 2));
        flights.add(new Flight(new Data("0008", 1130), 3));
        flights.add(new Flight(new Data("0009", 1220), 3));
        flights.add(new Flight(new Data("0010", 757), 3));
        // Printing all elements
        System.out.println("The queue elements listed from longest to shortest distance by priority sequence:");
        Data[] dataRecs = new Data[10];
        int i = 0;
        while (!flights.isEmpty()) {
            // store data
            dataRecs[i++] = new Data(flights.poll());
        }

        for (Data recs : dataRecs)
            System.out.println(recs.getName() + " " + recs.getMiles() + " " + recs.getPriority());


    }
}

class SortQueue implements Comparator<Flight> {
    @Override
    public int compare(Flight f1, Flight f2)
    {
        int res = f1.getPriority() - f2.getPriority();
        if (res == 0){
           res = f2.getData().getMiles() - f1.getData().getMiles(); 
        }
        return res;
    }
}

class Flight {
    Data data;
    private final int priority;
    
    public Data getData() {
        return data;
    }
    
    public void setData(Data data) {
        this.data = data;
    }
    
    Flight(Data data2, int priority) {
        this.data = data2;
        this.priority = priority;
    }
    
    public Flight() { priority = 0; }
    
    public int getPriority() { return priority; }
    
    @Override
    public String toString() {
        return "Flight{ priority = " + priority + ", miles = " + data.getMiles() + ", Flight name = " + data.getName() + " }";
    }
}
