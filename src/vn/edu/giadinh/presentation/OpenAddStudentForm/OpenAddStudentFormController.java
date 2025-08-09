package vn.edu.giadinh.presentation.OpenAddStudentForm;

import java.util.ArrayList;
import java.util.List;

import vn.edu.giadinh.business.OpenAddStudentForm.OpenAddStudentFromUseCase;
import vn.edu.giadinh.business.OpenAddStudentForm.ResMajorDTO;

public class OpenAddStudentFormController {
	private OpenAddStudentFormModel model;
	private OpenAddStudentFromUseCase uc;
	
	public OpenAddStudentFormController(OpenAddStudentFormModel model, OpenAddStudentFromUseCase uc) {
		this.model = model;
		this.uc = uc;
	}
	
	
	public void execute() {
		//lấy dữ liệu danh sách ngành
		List<ResMajorDTO> resList =  uc.execute();
		model.majorItems = convertToPresenter(resList);
		model.notifySubscribers();
		
	}


	private List<MajorItem> convertToPresenter(List<ResMajorDTO> resList) {
		List<MajorItem> majorPresenters = new ArrayList<MajorItem>();
		for (ResMajorDTO resMajorDTO : resList) {
			MajorItem item = new MajorItem();
			item.id = String.valueOf(resMajorDTO.id);
			item.name = resMajorDTO.name;
			
			majorPresenters.add(item);
			
		}
		return majorPresenters;
	}
	

}
