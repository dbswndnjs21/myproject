package test.di06.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.vo.MembersVo;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac= new ClassPathXmlApplicationContext("di06.xml");
        MybatisDao dao = (MybatisDao) ac.getBean("dao");
        int n1 = dao.insert(new MembersVo(123, "김자바", "010", "부산", null));
        int n2 = dao.update(new MembersVo(123, "김자바2", "0102", "부산", null));
        int n3 = dao.delete(123);
        System.out.println(n1 + n2 + n3);
        dao.selectAll().stream().forEach(mem-> System.out.println(mem));
    }
}
