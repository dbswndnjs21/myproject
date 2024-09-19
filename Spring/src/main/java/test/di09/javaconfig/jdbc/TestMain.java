package test.di09.javaconfig.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(JdbcAppConfig.class);
        JdbcDao jdbcDao = (JdbcDao) ac.getBean("jdbcDao");
        jdbcDao.select().forEach(m-> System.out.println(m));
    }
}
