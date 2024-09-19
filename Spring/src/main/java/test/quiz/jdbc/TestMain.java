package test.quiz.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import test.di07.jdbc.JdbcDao;
import test.quiz.vo.BoardVo;
import test.vo.MembersVo;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac= new ClassPathXmlApplicationContext("quiz/jdbc.xml");
        MboardDao dao = (MboardDao) ac.getBean("dao");
//        dao.select().stream().forEach(mem-> System.out.println(mem));

        try{
            BoardVo vo = dao.select(181);
            System.out.println(vo);
        } catch (EmptyResultDataAccessException e ) {
            System.out.println(e.getMessage());
            System.out.println("검색된 회원이없어욤");
        }

    }
}
