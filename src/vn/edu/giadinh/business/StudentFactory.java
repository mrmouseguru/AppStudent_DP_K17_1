package vn.edu.giadinh.business;

import vn.edu.giadinh.persistence.StudentDTO;

public class StudentFactory {
	
	public static Student createStudent(StudentDTO dto) {
		if ("Software".equalsIgnoreCase(dto.major)) {
			return new SoftwareStudent(
				dto.id, dto.name, dto.birthDate,
				dto.javaScore != null ? dto.javaScore : 0,
				dto.htmlScore != null ? dto.htmlScore : 0,
				dto.cssScore != null ? dto.cssScore : 0
			);
		} else if ("Economics".equalsIgnoreCase(dto.major)) {
			return new EconomicsStudent(
				dto.id, dto.name, dto.birthDate,
				dto.marketingScore != null ? dto.marketingScore : 0,
				dto.salesScore != null ? dto.salesScore : 0
			);
		}
		
		return null;
	}

}
