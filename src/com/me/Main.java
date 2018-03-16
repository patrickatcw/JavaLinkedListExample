package com.me;

//https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
//https://www.developer.com/java/data/working-with-java-linked-list.html
//https://docs.oracle.com/javase/7/docs/api/java/util/ListIterator.html
//https://mitchellkember.com/blog/post/tortoise-and-hare/
/*
not very different from the other List classes, such as ArrayList. But, the point of
difference is in how the list is maintained at the core
*/

import java.util.Iterator;
import java.util.LinkedList;

//step 1 class created
public class Main {

    public static void main(String[] args) {

        //step 2 create linkedlist
        LinkedList<String> placesToVisit = new LinkedList<String>();

        //step 3
        placesToVisit.add("Berea");
        placesToVisit.add("Chagrin Falls");
        placesToVisit.add("Lakewood");
        placesToVisit.add("Medina");
        placesToVisit.add("Akron");
        placesToVisit.add("Strongsville");
        placesToVisit.add("Shaker Heights");

        //step 4 calling method to print them out
        printList(placesToVisit);

        //step 7 add new element
        placesToVisit.add(1, "Westlake");
        printList(placesToVisit);
        //step 8 then run again

        //step 9 remove an element
        placesToVisit.remove(4);
        printList(placesToVisit);
        //step 10 then run again

    }

    //step 5 creating method to print out
    private static void printList(LinkedList<String> linkedList) {

        Iterator<String> i = linkedList.iterator();  //like a for loop

        while (i.hasNext()) {                         //has next checks for next entry

            System.out.println("Now visiting " + i.next());     //inext moves onto next entry

        }

        System.out.println("-------------------------------------------");

        //step 6 run program
        //got results; Now visiting Berea
        //etc.


    }

}



