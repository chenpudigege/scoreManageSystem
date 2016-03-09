package dao;

import java.io.Serializable;

public interface Dao<T> {
	void add(T t);

	void update(T t);

	T findById(Serializable id);

	void deleteById(Serializable id);
}
