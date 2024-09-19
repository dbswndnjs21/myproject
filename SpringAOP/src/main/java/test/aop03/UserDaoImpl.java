package test.aop03;

public class UserDaoImpl implements UserDao {

    @Override
    public int insert(Object data) {
        System.out.println("UserDaoImpl.insert : " + data);
        return 0;
    }

    @Override
    public int update(Object data) {
        System.out.println("UserDaoImpl.update : " + data);
        return 0;
    }

    @Override
    public int delete(Object data) {
        System.out.println("UserDaoImpl.delete : " + data);
        return 0;
    }

    @Override
    public Object select(Object data) {
        System.out.println("UserDaoImpl.select : " + data);
        return null;
    }
}
