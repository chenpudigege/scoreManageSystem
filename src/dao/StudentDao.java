package dao;

import java.util.Set;

import domin.Student;
import domin.Studentcourse;

public interface StudentDao extends Dao<Student> {
	public Set<Studentcourse> queryAllScore(int studentId);
}
