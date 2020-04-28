package com.zzw.mapper;

import java.util.List;
import java.util.Map;

import com.zzw.pojo.Student;

public interface StudentMapper {
	
	public List<Student> selectList();
	
	public Student selectOneById(int id);
	
	public Map<String, Object> selectMap();
	
	public Map<String, Map<String, Object>> selectMap2();

	public Map<String, Student> selectMap3();

}
