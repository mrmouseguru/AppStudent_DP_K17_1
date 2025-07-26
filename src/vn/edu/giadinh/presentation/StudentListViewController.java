package vn.edu.giadinh.presentation;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import vn.edu.giadinh.business.StudentListViewUseCase;
import vn.edu.giadinh.business.StudentViewItem;
import vn.edu.giadinh.business.StudentViewModel;

public class StudentListViewController {
	private StudentViewModel model;
	private StudentListViewUI view;
	private StudentListViewUseCase listViewUseCase;
	
	
	
	public StudentListViewController(StudentViewModel model, StudentListViewUI view) {
		super();
		this.model = model;
		this.view = view;
	}
	
	public void setListViewUseCase(StudentListViewUseCase listViewUseCase) {
		this.listViewUseCase = listViewUseCase;
	}

	public void execute() throws SQLException, ParseException {
//		List<StudentViewItem> list = 
//				new ArrayList<StudentViewItem>();
//		StudentViewItem item1 =
//		new StudentViewItem();
//		item1.stt = 1;
//		item1.id = "1111";
//		item1.name = "Tèo 111";
//		
//		list.add(item1);
		List<StudentViewItem> newList = listViewUseCase.execute();
		//gửi thông điệp đến Model
		//yêu cầu model cập nhật dữ liệu mới
		model.studentList = newList;
		//gửi thông điệp cho View ###########[THỦ CÔNG]
		//yêu cầu View lấy dữ liệu từ Model trình diễn
		view.showList(model);
		
	}

}
