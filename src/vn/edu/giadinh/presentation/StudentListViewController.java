package vn.edu.giadinh.presentation;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import vn.edu.giadinh.business.StudentListViewUseCase;
import vn.edu.giadinh.business.StudentViewDTO;

public class StudentListViewController {
	private StudentViewModel model;
	// private StudentListViewUI view;
	private StudentListViewUseCase listViewUseCase;

	public StudentListViewController(StudentViewModel model /*
															 * , StudentListViewUI view
															 */) {
		super();
		this.model = model;
		// this.view = view;
	}

	public void setListViewUseCase(StudentListViewUseCase listViewUseCase) {
		this.listViewUseCase = listViewUseCase;
	}

	public void execute() throws SQLException, ParseException {

		List<StudentViewDTO> dtoList = listViewUseCase.execute();

		// chuyển từ DTO sang dữ liệu trình bày presenter StudentViewItem
		List<StudentViewItem> presenterList = 
				this.convertToPresenter(dtoList);
		// gửi thông điệp đến Model
		// yêu cầu model cập nhật dữ liệu mới
		model.studentList = presenterList;
		// model gửi thông điệp đến tất cả các subscribers
		model.notifySubscribers();
		// gửi thông điệp cho View ###########[THỦ CÔNG]
		// yêu cầu View lấy dữ liệu từ Model trình diễn
		// view.showList(model);

	}

	private List<StudentViewItem> convertToPresenter(List<StudentViewDTO> dtos) {
		List<StudentViewItem> listViewItem = new ArrayList<StudentViewItem>();
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		int stt = 1;
		for (StudentViewDTO dto : dtos) {
				StudentViewItem item = new StudentViewItem();
				item.stt = stt++;
				item.id = dto.id;
				item.name = dto.name;
				item.birthDate = fmt.format(dto.birthDate);
				item.major = dto.major;
				item.gpa = String.format("%.2f", dto.gpa);
				item.academicRank = dto.academicRank;
				listViewItem.add(item);
		}
		return listViewItem;
	}

}
