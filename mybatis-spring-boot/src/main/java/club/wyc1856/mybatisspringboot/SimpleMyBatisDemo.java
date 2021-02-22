package club.wyc1856.mybatisspringboot;


import club.wyc1856.mybatisspringboot.domain.User;
import club.wyc1856.mybatisspringboot.mapper.wyc1856.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis demo
 *
 * @author wyc1856
 * @date 2020/9/3
 **/
public class SimpleMyBatisDemo {

    public static void main(String[] args) {
        String resourceLocation = "config/mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resourceLocation);
            //解析 xml 配置文件，创建会话工厂
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //从工厂中获取会话实例
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //1. 指定 statement 查询
            Object result = sqlSession.selectOne("club.wyc1856.mybatisspringboot.mapper.wyc1856.UserMapper.findById", 1);
            sqlSession.commit();
            System.out.println(result);
            SqlSession sqlSession1 = sqlSessionFactory.openSession();
            Object result_cache = sqlSession1.selectOne("club.wyc1856.mybatisspringboot.mapper.wyc1856.UserMapper.findById", 1);
            sqlSession1.commit();
            System.out.println(result_cache);

            int update = sqlSession.update("club.wyc1856.mybatisspringboot.mapper.wyc1856.UserMapper.updateById", 1);
            sqlSession.commit();
            System.out.println("update result: " + update);

            Object result_cache_1 = sqlSession1.selectOne("club.wyc1856.mybatisspringboot.mapper.wyc1856.UserMapper.findById", 1);
            sqlSession1.commit();
            System.out.println(result_cache_1);

            //2.通过 Mapper 接口代理类查询
//            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//            List<User> user = mapper.findLastPage();
//            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
