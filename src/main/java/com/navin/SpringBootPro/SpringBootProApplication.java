package com.navin.SpringBootPro;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.navin.SpringBootPro.entity.Student;

@SpringBootApplication
public class SpringBootProApplication {

	public static HashMap<Long, Student> mstudent;

	public static void main(String[] args) {
		mstudent = new HashMap<Long, Student>();
		Student student1 = new Student(0, "Navin", "Java");
		mstudent.put(new Long(student1.getId()), student1);
		SpringApplication.run(SpringBootProApplication.class, args);

		Student student2 = new Student(0, "Rajendra", "PHP");
		mstudent.put(new Long(student2.getId()), student2);
	}
}
