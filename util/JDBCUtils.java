package com.hwua.util;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
 
/**
 * 编写通用的 JDBCUtils 工具类
 * @author Administrator
 *
 */
 
public class JDBCUtils {
 
    /** 使用 c3p0 数据源 */
     
    private static DataSource dataSource = null;
     
    /** 使用ThreadLocal 解决多线程并发访问问题 
     *  其中存放的是,事务处理相关的 Connection 对象*/
    private static ThreadLocal<Connection> locals = null;
     
    /** 创建对象 */
    static{
        dataSource = new ComboPooledDataSource("c3p0-config.xml");
        locals = new ThreadLocal<>();
    }
     
    /**
     * 获取 数据库连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
         
        // 获取当前线程对应的连接，也就是当前访问的数据库连接
        Connection conn = locals.get();
        // 如果为空，说明没有开启事务，则返回空闲 连接
        // 不为空，说明正在进行事务，所以必须是同一连接
        return (conn != null)?conn:dataSource.getConnection();
    }
     
    /**
     * 开始事务
     * @throws SQLException
     */
    public static void beginStraction() throws SQLException{
        Connection conn = locals.get();
        //如果本次访问，已经开始事务了，却再次开始事务，即上次事务还没有进行完，又开始事务，则抛出
        if(conn != null)throw new SQLException("已经开始了事务");
        conn = getConnection();
        conn.setAutoCommit(false);
        locals.set(conn); //向 ThreadLocal 填充 数据库连接
         
    }
     
    /**
     * 提交事务
     * @throws SQLException
     */
    public static void commitStraction() throws SQLException{
        Connection conn = locals.get();
        // 判断事务是否开始了，如果还没有开始事务，则不能提交
        if(conn == null)
            throw new SQLException("还没有开始事务");
        conn.commit();
        conn.close();
        locals.remove();//移走
    }
     
    /**
     * 回滚事务
     * @throws SQLException
     */
    public static void rollbackStraction() throws SQLException{
        Connection conn = locals.get();
        if(conn == null)
            throw new SQLException("无法回滚事务");
     
        conn.rollback();
        conn.close();
        locals.remove();
    }
     
    /**
     * 释放 连接，归还连接池
     * @param connection
     * @throws SQLException
     */
    public static void release(Connection connection) throws SQLException{
         
        Connection conn = locals.get();
        if(conn == null){
            connection.close();
        }
        if(conn != connection){
            connection.close();
        }
         
    }
    /**
     * 释放 连接，关闭结果集
     * @param connection
     * @throws SQLException
     */
    public static void relase(Connection connection,ResultSet rs) throws SQLException{
        release(connection);
        if(rs != null){
            rs.close();
        }
    }
     
}