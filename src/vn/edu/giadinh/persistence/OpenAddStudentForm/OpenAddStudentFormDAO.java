package vn.edu.giadinh.persistence.OpenAddStudentForm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenAddStudentFormDAO implements OpenAddStudentFormGateway {

	private static Map<Integer, MajorDTO> majors;

	@Override
	public List<MajorDTO> getAll() {
		initData();
		 List<MajorDTO> list = null;
	        
        
        list = new ArrayList<>(majors.values());
   
    
     return list;
	}
	
	 private void initData() {
	        majors = new HashMap<>();
	        majors.put(1, new MajorDTO(1, "Công nghệ thông tin", "Công nghệ thông tin là ngành học về các công nghệ liên quan đến việc xử lý và truyền tải thông tin sử dụng các công nghệ mới nhất."));
	        majors.put(2, new MajorDTO(2, "Kinh tế", "Kinh tế là ngành học về việc quản lý và phân tích các vấn đề kinh tế."));
	        majors.put(3, new MajorDTO(3, "Ngôn ngữ Anh", "Ngôn ngữ Anh là ngành học về ngôn ngữ Anh."));
	    }

}
