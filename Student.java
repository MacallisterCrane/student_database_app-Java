package studentdatabaseapp;

import java.util.Scanner;

public class Student{
    private String firstName;
    private String lastName;
    private String gradeYear;
    private String courses = null;
    private int tuition_balance = 0;
    private String studentID;
    private static int course_cost = 700;
    private static int id = 100;

    public Student(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Student First Name: ");
        this.firstName = in.nextLine();
        System.out.println("Enter Student Last Name: ");
        this.lastName = in.nextLine();
        System.out.println("1 - Freshman\n 2 - Sophmore\n 3 - Junior\n 4 - Senior\n Enter Student class level: ");
        this.gradeYear = in.nextLine();

        setstudentID();
        System.out.println("Student ID: " + studentID);

    }
    //Generate ID with grade year
    private void setstudentID(){
        id++;
        this.studentID = lastName + gradeYear + id;
    }
    //Enroll in courses
    public void enroll(){
        do {
            System.out.print("Press Q to exit.\n Enter course to enroll: ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("Q")) {
                courses = course;
                tuition_balance = tuition_balance + course_cost;
                System.out.println("Enrolled Course: " + course);
            }
            else {break;}
        } while (1 != 0);
    }
    //View balance
    public void viewBalance(){
        System.out.println("Your balance is: $" + tuition_balance);
    }
    //Pay Tuition
    public void payTuition(){
        viewBalance();
        if (tuition_balance == 0){
            System.out.println("You have not enrolled in any courses");
        } else {
            System.out.print("Enter your payment: ");
            Scanner in = new Scanner(System.in);
            int payment = in.nextInt();
            tuition_balance = tuition_balance - payment;
            System.out.println("Thank you for your payment of: $" + payment);
            viewBalance();  
        }
    }
    //Show status
    public String showInfo(){
        return "Welcome to Georgia Tech " + firstName + " " + lastName + " !" +
                "\n Student ID: " + studentID +
                "\n Current Courses: " + courses +
                "\n Current Tuition Balance: $" + tuition_balance;
    }
}