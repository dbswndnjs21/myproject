package test.aop01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop1.xml");
        MembersDao dao = (MembersDao) ac.getBean("membersDao");
        System.out.println("dao : " + dao.getClass());
        dao.insert("홍길동");
        dao.update("홍길동");
        dao.delete("홍길동");
        dao.select("홍길동");
    }
}
