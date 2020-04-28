package com.zzw.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zzw.mapper.StudentMapper;
import com.zzw.pojo.Student;

public class MyBatisTest01 {

	public static void main(String[] args) throws IOException {
		String resourcePath = "mybatis.xml";
		InputStream is = Resources.getResourceAsStream(resourcePath);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		SqlSession session = factory.openSession();
		
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		
		List<Student> selectALl = studentMapper.selectList();
		for (Student student : selectALl) {
			System.out.println(student);
		}
		
		System.out.println("--------------------");
		Student stu = studentMapper.selectOneById(1);
		System.out.println(stu);
		
		System.out.println("--------------------");
		Map<String, Object> selectMap = studentMapper.selectMap();
		System.out.println(selectMap);
		
		System.out.println("--------------------");
		Map<Object, Object> selectMap2 = session.selectMap("com.zzw.mapper.StudentMapper.selectMap2", "id");
		System.out.println(selectMap2);
		
		System.out.println("--------------------");
		Map<Object, Object> selectMap3 = session.selectMap("com.zzw.mapper.StudentMapper.selectMap3", "name");
		System.out.println(selectMap3);
	}
	
	public void test() {
		System.out.println("---++++---");
	}
	
	public void test2() {
		System.out.println("------");
	}
}
