package club.wyc1856.mybatisspringboot.config;

import club.wyc1856.mybatisspringboot.utils.ReflectHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import sun.awt.AppContext;

import java.sql.Connection;
import java.util.Properties;

/**
 * todo
 *
 * @author wyc1856
 * @date 2020/9/4
 **/
@Slf4j
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class Wyc1856Interceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (invocation.getTarget() instanceof RoutingStatementHandler) {
            RoutingStatementHandler statementHandler = (RoutingStatementHandler) invocation.getTarget();
            //反射获取需要的属性
            BaseStatementHandler baseStatementHandler = (BaseStatementHandler) ReflectHelper.getFieldValue(statementHandler, "delegate");
            MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getFieldValue(baseStatementHandler, "mappedStatement");
            //判断是查询语句
            if (mappedStatement.getSqlCommandType().equals(SqlCommandType.SELECT)) {
                //取原始 SQL
                BoundSql boundSql = statementHandler.getBoundSql();
                String sql = boundSql.getSql();
                //反射重新设置 sql
                ReflectHelper.setFieldValue(boundSql, "sql", sql);
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler){
            //创建代理对象
            target = Plugin.wrap(target, this);
        }
        return target;
    }

    @Override
    public void setProperties(Properties properties) {}
}
