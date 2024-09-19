package test.aop04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.aop01.MembersDao;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop4.xml");
        MembersDao dao = (MembersDao) ac.getBean("dao");
        dao.insert("1길동");
        dao.update("2길동");
        dao.delete("3길동");
        dao.select("4길동");
    }
}
