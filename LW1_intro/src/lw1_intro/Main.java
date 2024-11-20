/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw1_intro;

import models.Student;
import utils.*;
import models.Collectors;
import models.Stamp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Mindaugas
 */
public class Main
{
    private static void performTests(List<Student> students)
    {
        System.out.println("Initial students list:");

        for(Student student : students)
        {
            System.out.println(student);
        }


//Perform Task
        System.out.println("===================Tests with some method implementation==================");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Perform Specified Task");
        System.out.println("Remove Only Once(Specific task)");
        System.out.println(students.Remove(new Student("Tomas", "Tomaitis", 22, "IF-7/1")));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for(Student student : students)
        {
            System.out.println(student);
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        Student snew= new Student("FirstName","LastNAme",200,"IFU-1");
        System.out.println("The set element is : "+  students.set(2,snew));

        System.out.println("\nAfter set method");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        for(Student student : students)
        {
            System.out.println(student);
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(students.remove(new Student("Tomas", "Tomaitis", 22, "IF-7/1")));
        System.out.println(students.remove(new Student("Jonas", "Jonaitis", 19, "IFF-9/3")));
        System.out.println(students.remove(new Student("Vardenis", "Pavardenis", 99, "XX-XX")));

        System.out.println("\nAfter removal:");

        for(Student student : students)
        {
            System.out.println(student);
        }

        students.add(new Student("Ona", "Onaite", 20,"IFF-8/1"));


        System.out.println("\nAfter addition at the end and insertion at the start:");

        for(Student student : students)
        {
            System.out.println(student);
        }

        System.out.println("\nTesting get() method:");

        for(int i = 0; i < 2; i++)
        {
            System.out.println(students.get(i));

        }

    }
    private static void performStackTests(Stack<Student> students,String header)
    {
        System.out.println("Initial students of"+header);
        System.out.println(students.isEmpty());
        System.out.println(students.peek());//Peek
        System.out.println(students.pop()); //Remove

        System.out.println(students.pop());
        System.out.println(students.pop());

        System.out.println(students.isEmpty());

        students.push(new Student("Ona", "Onaite", 20,"IFF-8/1"));
        System.out.println(students.peek());

    }
    private static void performQueueTests(Queue<Student> students,String header)
    {

        System.out.println("Initial students of "+header);
        System.out.println();
        System.out.println(students.peek());//Peek
        System.out.println(students.Dequeue()); //Remove

        System.out.println(students.Dequeue());
        students.Enqueue(new Student("Ona", "Onaite", 20,"IFF-8/1"));
        System.out.println(students.Dequeue());

        System.out.println(students.isEmpty());
        System.out.println(students.peek());

    }

    //Task1
    private static Collectors MostPopularStamp(LinkedList<Collectors> M)
    {
        Collectors C=null;
        int Counter;
        int StampCount = 0;

        for(Collectors m : M)
        {
            Counter = 0;
            for(Collectors n : M)
            {

                if(m.GetStampName().equals(n.GetStampName()))
                {
                    Counter++;
                }
            }
            if(Counter > StampCount)
            {
                StampCount = Counter;
                C = m;
            }
        }
        return C;
    }

    //Task2
    private static void PopularList(LinkedList<Collectors> Popular,String p,LinkedList<Collectors> NotPopular,LinkedList<Collectors> C)
    {
        for(Collectors c : C)
        {
            if(c.StampName.equals(p) && c.NumberOfStamps>0)   //at least 1 unit of stamp
            {
                Popular.add(c);
            }
            else {
                NotPopular.add(c);
            }
        }
    }

    //Task3
    private static LinkedList<Collectors> SpecifiedStamp(String Entered,LinkedList<Collectors> C,LinkedList<Stamp> St)
    {
        double avg=0.0;
        LinkedList<Collectors> newContainer =new LinkedList<Collectors>();

        for (Stamp s : St)
        {
            if (s.StampName.equalsIgnoreCase(Entered))
            {
                avg = s.AvgPrice;
                for(Collectors p : C)
                {
                    if ((s.StampName.equalsIgnoreCase(p.StampName)) && (p.Price <= avg))
                    {
                        newContainer.add(p);
                    }
                }
            }
        }
        return newContainer;
    }

    //Print to result
    public static void PrintToResultFile(LinkedList<Collectors> C,LinkedList<Stamp> S, LinkedList<Collectors> newC )
    {
        LinkedList<Collectors> p= new LinkedList<Collectors>();
        LinkedList<Collectors> np= new LinkedList<Collectors>();

        FileWriter fw =null;
        PrintWriter pw=null;
        File file =new File("Results.txt");
        try {
            fw = new FileWriter(file);
            pw = new PrintWriter(fw);

            IOUtils.DisplayResultCollector("Collectors", C, pw);
            IOUtils.DisplayResultStamp("Stamp", S, pw);

            pw.println("\nTask1(MostPopular Stamp)");
            if(MostPopularStamp(C)!=null)
            {
                pw.println("The Most Popular Stamp is: "+MostPopularStamp(C).StampName);
            }
            else {
                pw.println("Popular Stamp Not Found!");
            }

            //task2
            pw.println("\nTask2(MostPopular Stamp Collector List)");
            PopularList(p,MostPopularStamp(C).StampName,np,C);
            if(!p.isEmpty())
            {
                pw.println("List of Collectors who have at least one unit of popular stamp:");
                p.Sort();
                IOUtils.DisplayResultCollector("Collectors(Sorted by the name of the Stamp & price in ascending)", p,pw);

            }
            else {
                pw.println("List of popular stamps is not found!");
            }

            if(!np.isEmpty())
            {
                pw.println("\nList of Collectors who doesn't have at least one unit of popular stamp:");
                np.Sort();
                IOUtils.DisplayResultCollector("Collectors(Sorted by the name of the Stamp & price in ascending)", np, pw);
            }
            else {
                pw.println("\nList of Not-popular stamps is not found!");
                pw.println("Empty List!(Sorting cannot be done)");
            }

            //task3
            if(!newC.isEmpty())
            {
                IOUtils.DisplayResultCollector("Collectors who have the specified stamp & less than the average price offered at the auction", newC, pw);
            }
            else
            {
                pw.println("No Match");
            }
           pw.println("End of the program!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally
        {
            pw.close();
        }
    }
    public static void main(String[] args)
    {
        String filePath = "students_data.txt";

        String FileName1="U13a.txt";
        String FileName2="U13b.txt";

        Scanner scanner =new Scanner(System.in);
        Array<Student> students_arr = new Array<Student>();
        DataReader.readFromFile(filePath, students_arr);

        System.out.println("============Tests with array implementation============");
        performTests(students_arr);

        //LinkedList class implementations:
        LinkedList<Student> students_llist = new LinkedList<Student>();
         DataReader.readFromFile(filePath, students_llist);

        System.out.println("============Tests with linked list implementation============");
         performTests(students_llist);
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();



        //Stack implementation using Array:
        System.out.println("============Stack implementation with Arrays============");
        ArrayStack<Student> student_stack =new ArrayStack<Student>();
        DataReader.readForStack(filePath,student_stack);
        performStackTests(student_stack,"ArrayStack");

        //Stack implementation using LinkedList:
        System.out.println("============Stack implementation with LinkedList============");
        LinkedListStack<Student> student_linkedstack = new LinkedListStack<Student>();
        DataReader.readForStack(filePath,student_linkedstack);
        performStackTests(student_linkedstack,"LinkedListStack");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();

        //Queue implementation using Array
        System.out.println("============Queue implementation with Arrays============");
        ArrayQueue<Student> student_Queue =new ArrayQueue<Student>();
        DataReader.readForQueue(filePath,student_Queue);
        performQueueTests(student_Queue,"ArrayQueue");
        System.out.println();

        //Queue implementation using LinkedList
        System.out.println("============Queue implementation with LinkedList============");
        LinkedListQueue<Student> LinkedList_Queue= new LinkedListQueue<Student>();
        DataReader.readForQueue(filePath,LinkedList_Queue);
        performQueueTests(LinkedList_Queue,"LinkedList Queue");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();


        System.out.println("Enter the String :");
        String Brackets = scanner.nextLine();
        //LabA1(Optional)
        System.out.println(LabATask1.FindBrackets(Brackets.trim()));
        System.out.println("--------------------------------------------------------------------------------------------");









        //Lab1B(NO.13)
        System.out.println("=======================Lab1B(NO.13)=======================");


        LinkedList<Stamp> s =IOUtils.ReadStamp(FileName1);
        LinkedList<Collectors> c =IOUtils.ReadCollectors(FileName2);
        LinkedList<Collectors> p =new LinkedList<Collectors>();
        LinkedList<Collectors> np =new LinkedList<Collectors>();

         IOUtils.DisplayStamps("Initial Data of Stamp:",s);
         IOUtils.DisplayCollectors("Initial Data of Collectors:",c);

         //Task1
        System.out.println("\nTask1(MostPopular Stamp)");
        Collectors popular = MostPopularStamp(c);

        if(popular!=null)
        {
            System.out.println("The Most Popular Stamp is: "+popular.StampName);
        }
        else {
            System.out.println("Popular Stamp Not Found!");
        }

        //Task2
        System.out.println("\nTask2(MostPopular Stamp Collector List)");
        PopularList(p,popular.StampName,np,c);
        if(!p.isEmpty())
        {
            System.out.println("List of Collectors who have at least one unit of popular stamp:");

            p.Sort();
            IOUtils.DisplayCollectors("Collectors(Sorted by the name of the Stamp & price in ascending)", p);

        }
        else {
            System.out.println("List of popular stamps is not found!");
        }

        if(!np.isEmpty())
        {
            System.out.println("\nList of Collectors who doesn't have at least one unit of popular stamp:");

            np.Sort();
            IOUtils.DisplayCollectors("Collectors(Sorted by the name of the Stamp & price in ascending)", np);

        }
        else {
            System.out.println("\nList of Not-popular stamps is not found!");
            System.out.println("Empty List!(Sorting cannot be done)");
        }

        //Task3
            System.out.println("Enter a Stamp :");
            String stmp = scanner.nextLine().trim();

            LinkedList<Collectors> newC  = SpecifiedStamp(stmp,np,s);

            if(!newC.isEmpty())
            {
                IOUtils.DisplayCollectors("Collectors who have the specified stamp : "+stmp+" & less than the average price offered at the auction",newC);
            }
            else
            {
                System.out.println("No Match");
            }

            System.out.println("End of the program!!");

            PrintToResultFile(c,s,newC);
    }
}
