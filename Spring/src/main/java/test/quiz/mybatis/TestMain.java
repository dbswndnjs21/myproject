package test.quiz.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.di06.mybatis.MybatisDao;
import test.vo.MembersVo;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("quiz/mybatis.xml");
        MboardDao dao = (MboardDao) ac.getBean("dao");
        dao.selectAll().stream().forEach(board-> System.out.println(board));
    }
}
