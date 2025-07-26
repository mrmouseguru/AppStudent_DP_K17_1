package vn.edu.giadinh.business;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import vn.edu.giadinh.persistence.StudentDTO;
import vn.edu.giadinh.persistence.StudentListViewDAO;
import vn.edu.giadinh.presentation.StudentListViewUI;

public class StudentListViewUseCase {
	private StudentListViewDAO listViewDAO;
	
	
	public StudentListViewUseCase(StudentListViewDAO listViewDAO) {
		super();
		this.listViewDAO = listViewDAO;
	}
	
	public List<StudentViewItem> execute() throws SQLException, ParseException {
		List<StudentDTO> listDTO = null;
		List<Student> students = null;
		listDTO = listViewDAO.getAll();
		
		//convert StudentDTO => Student
		students = convertToBusinessObjects(listDTO);
		//convert students business to StudentViewModel
		return convertToViewModel(students);
	}
	
	private List<Student> convertToBusinessObjects(List<StudentDTO> dtos) {
		List<Student> students = new ArrayList<>();
		for (StudentDTO dto : dtos) {
			if ("Software".equalsIgnoreCase(dto.major)) {
				students.add(new SoftwareStudent(
					dto.id, dto.name, dto.birthDate,
					dto.javaScore != null ? dto.javaScore : 0,
					dto.htmlScore != null ? dto.htmlScore : 0,
					dto.cssScore != null ? dto.cssScore : 0
				));
			} else if ("Economics".equalsIgnoreCase(dto.major)) {
				students.add(new EconomicsStudent(
					dto.id, dto.name, dto.birthDate,
					dto.marketingScore != null ? dto.marketingScore : 0,
					dto.salesScore != null ? dto.salesScore : 0
				));
			}
		}
		return students;
	}
	
	private List<StudentViewItem> convertToViewModel(List<Student> students) {
		List<StudentViewItem> itemList = new ArrayList<StudentViewItem>();
	    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

		int stt = 1;
		
		for (Student student : students) {
			StudentViewItem item = new StudentViewItem();
			item.stt = stt++;
			item.id = student.getId();
			item.name = student.getName();
			item.birthDate = fmt.format(student.getBirthDate());
			item.major = student.getMajor();
			item.gpa = String.format("%.2f",student.calculateGPA());
			item.academicRank = student.classifyAcademic();
			itemList.add(item);
		}
		
		
		return itemList;
		
	}
	
	
	

}
