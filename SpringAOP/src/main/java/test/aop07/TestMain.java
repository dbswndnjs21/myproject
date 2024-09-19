package test.aop07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.aop03.UserDao;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop7.xml");
        UserDao dao = (UserDao) ac.getBean("dao");
        dao.insert("윤길동");
    }
}
