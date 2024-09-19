package test.di08.javaconfig.mybatis;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisAppConfig {

    @Autowired ApplicationContext applicationContext;
    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("oracle.jdbc.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        ds.setUsername("c##java");
        ds.setPassword("c##java");
        return ds;
    }

    // SqlSession 설정
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:mybatis/MembersMapper.xml"));
        SqlSessionFactory factory = (SqlSessionFactory) sqlSessionFactoryBean.getObject();
        return factory;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sqlSessionTemplate;
    }

    @Bean
    public MybatisDao mybatisDao() throws Exception {
        return new MybatisDao(sqlSessionTemplate());
//        MybatisDao dao = new MybatisDao();
//        dao.setSqlSession(sqlSessionTemplate());
//        return dao;
    }
}
