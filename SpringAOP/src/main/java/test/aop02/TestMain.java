package test.aop02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.aop01.MembersDao;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop2.xml");
        MembersDao dao = (MembersDao) ac.getBean("membersDao");
        System.out.println("dao : " + dao.getClass());
        dao.insert("홍길동");
        dao.update("홍길동");
        dao.delete("홍길동");
        dao.select("홍길동");
    }
}
