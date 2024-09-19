package test.di05.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {

        // 자바설정 파일에서 스프링빈 객체 만들기
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyAppConfig.class);
        // 메소드 이름이 스프링빈객체의 name 이 된다.
        Person person = (Person) ac.getBean("person");
        System.out.println(person.getName() + "," + person.getAge());

        MembersDao dao = (MembersDao) ac.getBean("daoTest");
        dao.select("홍길동");

        MembersController controller = (MembersController) ac.getBean("controller");
        controller.service();

    }
}
