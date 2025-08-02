package vn.edu.giadinh.business;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import vn.edu.giadinh.persistence.StudentDTO;
import vn.edu.giadinh.persistence.StudentListViewDAO;
import vn.edu.giadinh.presentation.StudentListViewUI;
import vn.edu.giadinh.presentation.StudentViewItem;

public class StudentListViewUseCase {
	private StudentListViewDAO listViewDAO;
	
	
	public StudentListViewUseCase(StudentListViewDAO listViewDAO) {
		super();
		this.listViewDAO = listViewDAO;
	}
	
	public List<StudentViewDTO> execute() throws SQLException, ParseException {
		List<StudentDTO> listDTO = null;
		List<Student> students = null;
		listDTO = listViewDAO.getAll();
		
		//convert StudentDTO => Student
		students = convertToBusinessObjects(listDTO);
		//convert students business to StudentViewModel
		return this.convertToViewDTO(students);
	}
	
	private List<Student> convertToBusinessObjects(List<StudentDTO> dtos) {
		List<Student> students = new ArrayList<>();
		for (StudentDTO dto : dtos) {
			Student student = StudentFactory.createStudent(dto);
			students.add(student);
		}
		return students;
	}
	
	private List<StudentViewDTO> convertToViewDTO(List<Student> students) {
		List<StudentViewDTO> itemList = new ArrayList<StudentViewDTO>();
		for (Student student : students) {
			StudentViewDTO dto = new StudentViewDTO();
			dto.id = student.getId();
			dto.name = student.getName();
			dto.birthDate = student.getBirthDate();
			dto.major = student.getMajor();
			dto.gpa = student.calculateGPA();
			dto.academicRank = student.classifyAcademic();
			itemList.add(dto);
		}
		
		return itemList;
		
	}
	
	
	

}
