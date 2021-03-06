package exercise.exercise0;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Create a List (ArrayList or LinkedList), add elements to it and print all of them using ListIterator
 *             for loop and foreach loop.
 *
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughList(){

        // TODO Exercise #0 a) Create a list (ArrayList or LinkedList) and add elements to it
        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)

        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements

        // TODO Exercise #0 c) Iterate through the list using classic for loop and print all its elements

        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements

        List<Integer> intList=new ArrayList<Integer>();
        intList.add(5);
        intList.add(6);
        intList.add(10);
        intList.add(8);

        ListIterator<Integer> listIterator=intList.listIterator();
        System.out.print("Iterate through the List using ListIterator: ");
        while(listIterator.hasNext()){
            Integer intNumber=listIterator.next();
            System.out.print(intNumber+", ");
        }
        System.out.println();
        System.out.print("Iterate through the List using classic for loop: ");
        for(int i=0; i<intList.size(); i++){
            System.out.print(intList.get(i)+", ");
        }
        System.out.println();
        System.out.print("Iterate through the List using foreach loop: ");
        for(Integer number: intList){
            System.out.print(number+", ");
        }
    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
        Exercise0 exercise0=new Exercise0();
        exercise0.iterateThroughList();
    }
}
