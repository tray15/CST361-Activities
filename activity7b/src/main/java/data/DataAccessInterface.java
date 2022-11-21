package data;

public interface DataAccessInterface<T> {
	T create(T t);
	T findBy(T t);
}
