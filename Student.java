package studentdatabaseapp;

import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID; //belongs to instance
	private String courses;
	private static int tuitionBalance = 0; //true for all objects.increment id by 1 [id++;]
	private int costOfCourse = 600;
	private static int id = 1000;
		//Constructor: The user should be prompted to enter the name and year for each student
	
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter student first name: ");
		this.firstName = in.nextLine();
		
		System.out.print("Enter student last name: ");
		this.lastName = in.nextLine();
		
		System.out.print("1 - First Year\n2- Second Year\n3 - Third Year\n4 - Final Year\nEnter student class level: ");
		this.gradeYear = in.nextInt();
		System.out.println(firstName + " " + lastName + " " + gradeYear);
		
		setStudentID();
		
		
	}
	//The student should have a 5-digit unique ID, with the first number being their grade level
	
	private void setStudentID() {
		//grade level + static ID
		id++;//increment by 1
		this.studentID = gradeYear + "" + id; //will treat this as a string
		
	}
	
	//(implement enrollment method) A student can enroll in the following courses:History 101,Mathematics 101,English 101,Chemistry 101,Computer Science 101
	
	public void enroll() {
		
		//get inside a loop, user hits zero
		do {
		
		
		System.out.print("Enter course to enroll (Q to quit): ");
		Scanner in = new Scanner(System.in);
		String course = in.nextLine();
		if (!course.equals("Q")) {
			courses = courses + "\n" + course;
			tuitionBalance = tuitionBalance + costOfCourse;
			}
			else { 
				break; }
		} while (1 != 0);
		
		//System.out.println("Enrolled in: " + courses);
		//System.out.println("Tuition balance: " + tuitionBalance);
	}
	
	//Each course costs $600 to enroll, view balance, 
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
		
	}
	
	//pay tuition
	public void payTuition() {
		viewBalance();
		System.out.print("Enter your payment: £");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for your payment of £" + payment);
		viewBalance();
	}
	
	//To see the status of the student, we should see their name, ID, courses enrolled, and balance

	public String toString() {
		return "Name: " + firstName + " " + lastName + 
				"\nGrade Level: " + studentID +
				"\nCourses Enrolled: " + courses + "\nBalance: £" + tuitionBalance;
	}

}
