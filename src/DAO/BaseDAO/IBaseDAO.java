package DAO.BaseDAO;

import java.util.List;

public interface IBaseDAO<T> {
    List<T> getAll();
    boolean add(T t);
    boolean update(T t,int id);
    boolean delete(int id);
}
