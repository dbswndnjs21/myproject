package test.aop05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.aop01.MembersDao;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop5.xml");
        MembersDao dao = (MembersDao) ac.getBean("dao");
        dao.select("윤주원");
    }
}
