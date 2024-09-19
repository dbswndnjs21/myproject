package test.di07.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import test.di06.mybatis.MybatisDao;
import test.vo.MembersVo;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac= new ClassPathXmlApplicationContext("di07.xml");
        JdbcDao dao = (JdbcDao) ac.getBean("dao");
        int n = dao.insert(new MembersVo(6, "kimjava", "1231", "ses", null));
        dao.select().stream().forEach(mem-> System.out.println(mem));

        try{
            MembersVo vo = dao.select(3);
            System.out.println(vo);
        } catch (EmptyResultDataAccessException e ) {
            System.out.println(e.getMessage());
            System.out.println("검색된 회원이없어욤");
        }

    }
}
