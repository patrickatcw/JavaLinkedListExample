package com.me;

//https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
//https://www.developer.com/java/data/working-with-java-linked-list.html
//https://docs.oracle.com/javase/7/docs/api/java/util/ListIterator.html
//cycle detection....
//https://mitchellkember.com/blog/post/tortoise-and-hare/
//https://en.wikipedia.org/wiki/Cycle_detection
/*
not very different from the other List classes, such as ArrayList. But, the point of
difference is in how the list is maintained at the core
*/

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

//step 1 class created
public class Main {

    public static void main(String[] args) {

        //step 2 create linkedlist
        LinkedList<String> placesToVisit = new LinkedList<String>();

        //step 15 change some code here, calling that method
        addInOrder(placesToVisit, "Berea");
        //step 16 comment out below, then add other cities here
        addInOrder(placesToVisit, "Chagrin Falls");
        addInOrder(placesToVisit, "Lakewood");
        addInOrder(placesToVisit, "Medina");
        addInOrder(placesToVisit, "Akron");
        addInOrder(placesToVisit, "Strongsville");
        addInOrder(placesToVisit, "Shaker Heights");

        //step 17
        printList(placesToVisit);
        //results printout in alphabetical order

        //step 18 some testing here
        addInOrder(placesToVisit, "Aida");
        addInOrder(placesToVisit, "Lakewood");

        //step 19 run this
        printList(placesToVisit);
        //results were a note that lakewood is already a destination,
        //and added Aida

        //step 27 calling visit method
        visit(placesToVisit);

        //step 28 then run this
        //experiencing cycle detection problems, need to back to visit method to alter, step 29

    }
        /*//step 3
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

    }*/

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

    //step 11 manipulating elements to alphabetical order, creating method
    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {

        //step 12 create a list iterator
        ListIterator<String> stringListIterator = linkedList.listIterator();

        //step 13 while loop
        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison==0) {
                // equal, do not add
                System.out.println(newCity + " is already included as a destination");
                return false;
            } else if (comparison > 0) {
                // new City should appear before this one
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) {
                // move on next city
            }
        }

        //step 14 calling
        stringListIterator.add(newCity);
        return true;

        //step 15 go up to below step 2

        }

    //step 20 method visit
    private static void visit(LinkedList cities){

        //step 21 add scanner
        Scanner scanner = new Scanner(System.in);

        //step 22
        boolean quit = false;
        ListIterator<String> listIterator = cities.listIterator();

        //step 29 adding another variable to address cycle detection
        boolean goingForward = true;
        //now go down to under case 1 for step 30

        //step 23
        if(cities.isEmpty()){

            System.out.println("No cities in the itenery");
            return;

        }else{

            System.out.println("Now visiting " + listIterator.next());
            printMenu();  //calling a method we need to create

        }

        //step 24
        while(!quit){

            int action = scanner.nextInt();
            scanner.nextLine();

            //step 25 switch
            switch(action) {
                case 0:
                    System.out.println("Vacation is over");
                    quit = true;
                    break;

                case 1:
                    //step 30 testing for goingForward
                    if(!goingForward) {
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    //end of step 30, next under case 2, for going backwards

                    if(listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        //step 32
                        goingForward = false;
                    }
                    break;

                case 2:
                    //step 31 testing for going backwards
                    if(goingForward){
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    //end of step 31
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        //step 33
                        goingForward = true;
                        //step 34 now run it again to make sure we work
                    }
                    break;

                case 3:
                    printMenu();   //need to create method menu
                    break;

            }

        }

    }

    //step 26 printmenu method
    private static void printMenu(){
        System.out.println("Available actions: \npress ");
        System.out.println("0 - to quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous city\n" +
                "3 - print menu options");

        //step 27 go up and add code to start visit


    }


}



