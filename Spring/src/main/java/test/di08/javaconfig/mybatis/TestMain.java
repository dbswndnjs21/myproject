package test.di08.javaconfig.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyBatisAppConfig.class);
        MybatisDao dao = (MybatisDao) ac.getBean("mybatisDao");
        dao.selectAll().forEach(m-> System.out.println(m));
    }
}
