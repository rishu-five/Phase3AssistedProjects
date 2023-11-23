package com.example;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class StudentMain {

	public static void main(String[] args) {
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("Spring.xml");
		Student s=ac.getBean(Student.class);
		StudentDAO dao=ac.getBean(StudentDAO.class);
		/*Scanner sc= new Scanner(System.in);
		System.out.println("Enter The Student ID:");
		s.setSid(sc.nextInt());
		System.out.println("Enter The Student Name:");
		s.setSname(sc.next());
		System.out.println("Enter The Student Email");
		s.setSemail(sc.next());
		if(dao.insert(s)>0) {
			System.out.println("Record Inserted into Student Table......");
		}
		else {
			System.out.println("Insertion Failed!!!!!");
		}*/
		
		System.out.println("via preparedstatement");
		Student getstudent=dao.getDetails("Rishu");
		System.out.println(getstudent);
		System.out.println("via direct result ");
		System.out.println("Getting single from able using direct");
		Student getall1=dao.getDetails("Rishu");
		System.out.println(getall1);
		List<Student> getall=dao.getallstudents();
		for(Student student:getall) {
			System.out.println(student);



	}

}}