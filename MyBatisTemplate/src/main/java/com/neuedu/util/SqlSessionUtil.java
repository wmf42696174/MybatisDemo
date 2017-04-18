package com.neuedu.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017-04-18.
 */
public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSessionFactory getSqlSessionFactory(){
        InputStream in=null;
        if(sqlSessionFactory==null){
            try {
                in= Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(in!=null){
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return sqlSessionFactory;
    }
    public static SqlSession openSession () {
        return openSession (false);
    }

    public static SqlSession openSession (boolean autoCommit) {
        return getSqlSessionFactory().openSession(autoCommit);
    }
}
