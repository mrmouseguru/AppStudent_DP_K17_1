package vn.edu.giadinh;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class StudentListViewUseCase {
	private StudentListViewDAO listViewDAO;
	private StudentListViewUI listViewUI;
	
	
	public StudentListViewUseCase(StudentListViewDAO listViewDAO, 
			StudentListViewUI listViewUI) {
		super();
		this.listViewDAO = listViewDAO;
		this.listViewUI = listViewUI;
	}
	
	public void execute() throws SQLException, ParseException {
		List<Student> list = null;
		list = listViewDAO.getAll();
		
		listViewUI.showList(list);
	}
	
	

}
