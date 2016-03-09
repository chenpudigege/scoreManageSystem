package test;

import java.io.Serializable;
import java.util.Set;

import org.junit.Test;

import dao.AdminDao;
import dao.ClassDao;
import dao.CourseDao;
import dao.StudentCourseDao;
import dao.StudentDao;
import dao.impl.AdminDaoImpl;
import dao.impl.ClassDaoImpl;
import dao.impl.CourseDaoImpl;
import dao.impl.StudentCourseDaoImpl;
import dao.impl.StudentDaoImpl;
import domin.Admin;
import domin.Classes;
import domin.Course;
import domin.Student;
import domin.Studentcourse;
import domin.User;

public class DaoTest {
	@Test
	public void addStudent() {
		ClassDao cDao = new ClassDaoImpl();
		Classes c = cDao.findById(2012211303);

		StudentDao sDao = new StudentDaoImpl();
		Student s = new Student();
		s.setClasses(c);
		s.setAge(12);
		s.setName("hjcjb");
		//s.setPassword("123456");
		s.setSex("ÄÐ");
		sDao.add(s);

	}

	@Test
	public void chooseCourse() {
		CourseDao cDao = new CourseDaoImpl();
		Course c = cDao.findById(2);

		StudentDao sDao = new StudentDaoImpl();
		Student s = sDao.findById(2013256785);

		Studentcourse sc = new Studentcourse();
		sc.setCourse(c);
		sc.setStudent(s);

		StudentCourseDao scDao = new StudentCourseDaoImpl();
		scDao.update(sc);
	}

	@Test
	public void queryScore() {
		StudentDao sDao = new StudentDaoImpl();
		Set<Studentcourse> scores = sDao.queryAllScore(1243);
		for (Studentcourse s : scores) {
			System.out.println(s.getCourse().getCourseName() + " " + s.getStudent().getName() + " " + s.getScore());
		}
	}
	
	@Test
	public void addAdmin() {
		AdminDao aDao = new AdminDaoImpl();
		Admin a =new Admin();
		User u=new User();
		u.setPassword("123456");
		u.setRole("admin");
		u.setUsername("HandsomeChan");
		a.setUser(u);
		a.setName("³Âè±µÏ");
		aDao.add(a);
	}

}
