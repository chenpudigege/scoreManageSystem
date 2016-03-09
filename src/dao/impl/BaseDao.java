package dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.Dao;
import utils.HibernateUtil;

public abstract class BaseDao<T> implements Dao<T> {
	private Class<?> clazz;

	public BaseDao() {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType pType = (ParameterizedType) type;
		clazz = (Class<?>) pType.getActualTypeArguments()[0];
	}

	@Override
	public void add(T t) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(t);
		transaction.commit();
		session.close();
	}

	@Override
	public void update(T t) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(t);
		transaction.commit();
		session.close();

	}

	@Override
	public T findById(Serializable id) {
		Session session = HibernateUtil.getSession();
		@SuppressWarnings("unchecked")
		T t = (T) session.get(clazz, id);
		session.close();
		return t;
	}

	@Override
	public void deleteById(Serializable id) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		@SuppressWarnings("unchecked")
		T t = (T) session.get(clazz, id);
		session.delete(t);
		transaction.commit();
		session.close();

	}

}
