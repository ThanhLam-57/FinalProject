package DAO;

import Database.Connect;
import jdk.jfr.Name;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BaseDAO<T> implements IBaseDAO<T>{
    private Class<T> tClass;
    public BaseDAO(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public List getAll() {
        Connection conn = null;
        List<T> list = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = String.format("SELECT * FROM %s", this.getClass().getSimpleName());
            PreparedStatement prst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = prst.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                T t = tClass.newInstance();
                for (Field field : tClass.getDeclaredFields()) {
                    String nameField = field.getAnnotation(Name.class).value();
                    System.out.println("Name field" + nameField);
                    field.setAccessible(true);
                    if (field.getType() == UUID.class) {
                        UUID id = UUID.fromString(rs.getString(nameField));
                        field.set(t, id);
                    } else {
                        field.set(t, rs.getObject(nameField));
                    }
                }
                list.add((T) rs);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean update(Object o, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
