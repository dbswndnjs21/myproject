package test.aop03;

public interface UserDao {
    int insert(Object data);
    int update(Object data);
    int delete(Object data);
    Object select(Object data);
}
