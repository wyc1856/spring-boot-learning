package club.wyc1856.mybatisspringboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author wyc1856
 * @date 2019/2/17 16:40
 * @description wyc1995数据源配置
 **/
@Configuration
@MapperScan(basePackages = Wyc1995DataSourceConfig.MAPPER_PACKAGE, sqlSessionFactoryRef = "wyc1995SqlSessionFactory")
public class Wyc1995DataSourceConfig {

    static final String MAPPER_XML_LOCATION = "classpath:mapper/wyc1995/*.xml";
    static final String MAPPER_PACKAGE = "club.wyc1856.mybatisspringboot.mapper.wyc1995";

    @Value("${wyc1995.datasource.url}")
    private String url;
    @Value("${wyc1995.datasource.username}")
    private String userName;
    @Value("${wyc1995.datasource.password}")
    private String password;
    @Value("${wyc1995.datasource.driverClassName}")
    private String driverClassName;

    @Bean
    public DataSource wyc1995DataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager wyc1995TransactionManager(){
        return new DataSourceTransactionManager(wyc1995DataSource());
    }

    @Bean
    public SqlSessionFactory wyc1995SqlSessionFactory(@Qualifier("wyc1995DataSource") DataSource wyc1995DataSource) throws Exception{
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(wyc1995DataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_XML_LOCATION));
        return sqlSessionFactoryBean.getObject();
    }
}
