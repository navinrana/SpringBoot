package com.navin.SpringBootPro.service;

import java.util.HashMap;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.navin.SpringBootPro.SpringBootProApplication;
import com.navin.SpringBootPro.entity.Student;

@RestController
@RequestMapping(value = "/rest/student")
public class StudentService {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public HashMap<Long, Student> getAllStudent() {
		return SpringBootProApplication.mstudent;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Student addStudent(
			@RequestParam(value = "id") Long id,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "subject", defaultValue = "unknown") String subject) {
		Student student = new Student(id, name, subject);
		SpringBootProApplication.mstudent.put(new Long(student.getId()),
				student);
		return student;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student student) throws Exception {
		if (SpringBootProApplication.mstudent.containsKey(new Long(student
				.getId()))) {
			SpringBootProApplication.mstudent.put(new Long(student.getId()),
					student);
		} else {
			throw new Exception("Student" + student.getId()
					+ "student doesn't exist");
		}
		return student;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public Student deleteStudent(@PathParam("id") Long id) throws Exception {
		Student student;
		if (SpringBootProApplication.mstudent.containsKey(new Long(id))) {
			student = SpringBootProApplication.mstudent.get(new Long(id));
			SpringBootProApplication.mstudent.remove(new Long(id));
		} else {
			throw new Exception("Student" + id + "student does not exists");
		}
		return student;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("id") Long id) {
		return SpringBootProApplication.mstudent.get(new Long(id));
	}
}
