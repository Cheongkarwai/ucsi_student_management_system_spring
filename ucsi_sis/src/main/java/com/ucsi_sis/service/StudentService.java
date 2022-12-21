package com.ucsi_sis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import javax.print.attribute.PrintJobAttribute;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.ucsi.dto.EnrolledCourseDto;
import com.ucsi.dto.ProgrammeDto;
import com.ucsi.dto.StudentDto;
import com.ucsi.dto.StudentProfileDto;
import com.ucsi_sis.entity.Address;
import com.ucsi_sis.entity.Course;
import com.ucsi_sis.entity.Programme;
import com.ucsi_sis.entity.Result;
import com.ucsi_sis.entity.Student;
import com.ucsi_sis.entity.Student_Course;
import com.ucsi_sis.repository.ProgrammeRepository;
import com.ucsi_sis.repository.StudentRepository;

@Service
public class StudentService {

	private StudentRepository studentRepository;

	private ProgrammeRepository programmeRepository;

	private PlatformTransactionManager platformTransactionManager;

	private TransactionTemplate transactionTemplate;

	public StudentService(StudentRepository studentRepository, ProgrammeRepository programmeRepository,
			PlatformTransactionManager platformTransactionManager) {
		this.studentRepository = studentRepository;
		this.programmeRepository = programmeRepository;
		this.platformTransactionManager = platformTransactionManager;
	}

	public List<StudentDto> getAllStudents() {

		transactionTemplate = new TransactionTemplate(platformTransactionManager);

		return transactionTemplate.execute(new TransactionCallback<List<StudentDto>>() {

			@Override
			public List<StudentDto> doInTransaction(TransactionStatus status) {

				List<StudentDto> studentDtos = new ArrayList<>();
				try {
					
					List<Student> students = studentRepository.findAll();
					
					for(int i = 0;i < students.size(); i++) {
						
						Student student = students.get(i);
						
						StudentDto studentDto = new StudentDto(student.getId(),
								student.getFirstName(),
								student.getLastName(),
								student.getNric(),
								student.getAge(),
								student.getContact(),
								student.getEmailAddress(),
								student.getUser(),
								student.getAddress(),
								new ProgrammeDto(student.getProgramme().getId(),
										student.getProgramme().getName()));
	
						for(int j = 0;j < students.get(i).getEnrolledCourses().size(); i++) {
							
							Student_Course studentCourse = students.get(i).getEnrolledCourses().get(j);
							
							studentDto.addEnrolledCourse(new EnrolledCourseDto(
									studentCourse.getId(),
									studentCourse.getCourse().getName(),
									studentCourse.getCourse().getCreditHour(),
									studentCourse.getCourse().getFees(),
									studentCourse.getDateFinished(),
									studentCourse.getDateEnrolled(),
									studentCourse.getResult()));
							
						}
						studentDtos.add(studentDto);
					}
					

				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return studentDtos;
			}

		});
	}

	public StudentDto getStudentById(String id) {

		transactionTemplate = new TransactionTemplate(platformTransactionManager);

		return transactionTemplate.execute(new TransactionCallback<StudentDto>() {

			@Override
			public StudentDto doInTransaction(TransactionStatus status) {

				Student student = studentRepository.findById(id);

				StudentDto studentDto = new StudentDto();
				studentDto.setId(student.getId());
				studentDto.setFirstName(student.getFirstName());
				studentDto.setLastName(student.getLastName());
				studentDto.setNric(student.getNric());
				studentDto.setAge(student.getAge());
				studentDto.setContact(student.getContact());
				studentDto.setEmailAddress(student.getEmailAddress());
				studentDto.setProgramme(
						new ProgrammeDto(student.getProgramme().getId(), student.getProgramme().getName()));
				studentDto.setAddress(student.getAddress());
				
				
				List<EnrolledCourseDto> enrolledCourseDtos = student.getEnrolledCourses().stream()
					.map((enrolledCourse)->{
						return new EnrolledCourseDto(
								enrolledCourse.getId(),
								enrolledCourse.getCourse().getName(),
								enrolledCourse.getCourse().getCreditHour(),
								enrolledCourse.getCourse().getFees(),
								enrolledCourse.getDateFinished(),
								enrolledCourse.getDateEnrolled(),
								enrolledCourse.getResult());
						
					}).collect(Collectors.toList());
				
				studentDto.setEnrolledCourses(enrolledCourseDtos);

				return studentDto;
			}
		});
	}

	public void saveStudent(Student student) {

		transactionTemplate = new TransactionTemplate(platformTransactionManager);

		transactionTemplate.executeWithoutResult(new Consumer<TransactionStatus>() {

			@Override
			public void accept(TransactionStatus t) {

				try {
					Long id = (long) 1;
					Programme programme = programmeRepository.findById(id);
					student.setProgramme(programme);
					studentRepository.save(student);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void updateStudent(Student studentBody,String id) {

		transactionTemplate = new TransactionTemplate(platformTransactionManager);

		 transactionTemplate.executeWithoutResult(new Consumer<TransactionStatus>() {


			@Override
			public void accept(TransactionStatus t) {
				try {
					Student student = studentRepository.findById(id);
					
					student.setFirstName(studentBody.getFirstName());
					student.setLastName(studentBody.getLastName());
					student.setAge(studentBody.getAge());
					//student.setProgramme(studentBody.getProgramme());
					student.setContact(studentBody.getContact());
					student.setDateOfBirth(studentBody.getDateOfBirth());
					student.setEmailAddress(studentBody.getEmailAddress());
					//student.setEnrolledCourse(studentBody.getEnrolledCourses());
					student.setUser(studentBody.getUser());
					
					
					studentRepository.update(student);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentProfileDto getStudentProfileById(String id) {

		transactionTemplate = new TransactionTemplate(platformTransactionManager);

		return transactionTemplate.execute(new TransactionCallback<StudentProfileDto>() {

			@Override
			public StudentProfileDto doInTransaction(TransactionStatus status) {

				StudentProfileDto studentProfileDto = null;

				try {

					Student student = studentRepository.findById(id);

					studentProfileDto = new StudentProfileDto(student.getId(), student.getFirstName(),
							student.getLastName(), student.getAge(), student.getContact(), student.getEmailAddress(),
							student.getDateOfBirth(), student.getNric(), student.getProgramme().getName());
				} catch (Exception e) {
					e.printStackTrace();
				}

				return studentProfileDto;
			}
		});
	}

	public void deleteStudentById(String id) {
		
		transactionTemplate = new TransactionTemplate(platformTransactionManager);
		
		transactionTemplate.executeWithoutResult(new Consumer<TransactionStatus>() {
			
			@Override
			public void accept(TransactionStatus status) {
				
				try {
					studentRepository.deleteById(id);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
