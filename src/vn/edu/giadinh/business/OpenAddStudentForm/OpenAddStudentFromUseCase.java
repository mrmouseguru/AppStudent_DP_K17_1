package vn.edu.giadinh.business.OpenAddStudentForm;

import java.util.ArrayList;
import java.util.List;

import vn.edu.giadinh.persistence.OpenAddStudentForm.MajorDTO;
import vn.edu.giadinh.persistence.OpenAddStudentForm.OpenAddStudentFormGateway;

public class OpenAddStudentFromUseCase {
	private OpenAddStudentFormGateway gateway;
	
	
	
	public OpenAddStudentFromUseCase(OpenAddStudentFormGateway gateway) {
		this.gateway = gateway;
	}

	public List<ResMajorDTO> execute(){
		List<MajorDTO> listDTO = gateway.getAll();
		List<Major> majors = convertToBussiness(listDTO);
		return convertToResponseDTO(majors);
	}

	private List<ResMajorDTO> convertToResponseDTO(List<Major> majors) {
		List<ResMajorDTO> resMajors = new ArrayList<ResMajorDTO>();
		for (Major major : majors) {
			ResMajorDTO resDTO = new ResMajorDTO();
			resDTO.id = major.getId();
			resDTO.name = major.getName();
			resDTO.desscription = major.getDescription();
			
			resMajors.add(resDTO);
		}
		return resMajors;
	}

	private List<Major> convertToBussiness(List<MajorDTO> listDTO) {
		List<Major> majors = new ArrayList<Major>();
		for (MajorDTO majorDTO : listDTO) {
			Major major = new Major(majorDTO.id, majorDTO.name,
					majorDTO.description);
			majors.add(major);
		}
		
		
		return majors;
	}
	
	

}
