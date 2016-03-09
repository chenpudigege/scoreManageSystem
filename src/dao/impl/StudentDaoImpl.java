package dao.impl;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.StudentDao;
import domin.Student;
import domin.Studentcourse;
import utils.HibernateUtil;

public class StudentDaoImpl extends BaseDao<Student> implements StudentDao {

	@Override
	public Set<Studentcourse> queryAllScore(int studentId) {
		Set<Studentcourse> scores=null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Student s=(Student)session.get(Student.class, studentId);
		scores=s.getStudentcourses();
		scores.size();//ясЁы╪сть
		transaction.commit();
		session.close();
		return scores;
	}
	
}
