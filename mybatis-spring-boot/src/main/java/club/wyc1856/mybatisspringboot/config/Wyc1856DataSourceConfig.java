package club.wyc1856.mybatisspringboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author wyc1856
 * @date 2019/2/17 16:10
 * @description wyc1856数据源配置
 **/
@Configuration
@MapperScan(basePackages = Wyc1856DataSourceConfig.MAPPER_PACKAGE, sqlSessionFactoryRef = "wyc1856SqlSessionFactory")
public class Wyc1856DataSourceConfig {

    static final String MAPPER_MXL_LOCATION = "classpath:mapper/wyc1856/*.xml";
    static final String MAPPER_PACKAGE = "club.wyc1856.mybatisspringboot.mapper.wyc1856";

    @Bean
    @ConfigurationProperties(prefix = "wyc1856.datasource")
    public DataSource wyc1856DataSource(){
        return new DruidDataSource();
    }

    @Bean
    public DataSourceTransactionManager wyc1856TransactionManager(){
        return new DataSourceTransactionManager(wyc1856DataSource());
    }

    @Bean
    public SqlSessionFactory wyc1856SqlSessionFactory(@Qualifier("wyc1856DataSource") DataSource wyc1856DataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(wyc1856DataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_MXL_LOCATION));
        return sqlSessionFactoryBean.getObject();
    }
}
