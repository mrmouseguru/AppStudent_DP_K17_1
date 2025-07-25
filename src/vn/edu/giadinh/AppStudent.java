package vn.edu.giadinh;

import java.sql.SQLException;
import java.text.ParseException;

import vn.edu.giadinh.business.StudentListViewUseCase;
import vn.edu.giadinh.persistence.StudentListViewDAO;
import vn.edu.giadinh.presentation.StudentListViewUI;

public class AppStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentListViewUI listViewUI = new StudentListViewUI();
		StudentListViewUseCase listViewUseCase  = null;
		try {
			StudentListViewDAO listViewDAO = new StudentListViewDAO();
			listViewUseCase = new StudentListViewUseCase(listViewDAO,
					listViewUI);
			listViewUseCase.execute();
			listViewUI.setVisible(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
