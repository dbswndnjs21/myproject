package test.aop03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuizMain {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("aop3.xml");
        UserDao dao = (UserDao) ac.getBean("userDao");
        dao.insert("윤주원");
    }
}
