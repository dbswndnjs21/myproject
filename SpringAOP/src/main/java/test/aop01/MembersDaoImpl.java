package test.aop01;

public class MembersDaoImpl implements MembersDao {

    public int insert(Object data) {
        System.out.println(data + "추가");
        return 1;
    }

    public int update(Object data) {
        System.out.println(data + "수정");
        return 1;
    }

    public int delete(Object data) {
        System.out.println(data + "삭제");
        return 1;
    }

    public Object select(Object data) {
        System.out.println(data + "조회");
        return data;
    }
}
