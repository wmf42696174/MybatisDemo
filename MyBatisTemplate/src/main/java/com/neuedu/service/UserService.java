package com.neuedu.service;

import com.neuedu.dao.mappers.UserMapper;
import com.neuedu.entity.User;
import com.neuedu.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by Administrator on 2017-04-18.
 */
public class UserService {

    public List<User> FindAllUser(){
        SqlSession sqlSession= SqlSessionUtil.openSession();
        List<User> users=null;
        try {
            UserMapper mapper=sqlSession.getMapper(UserMapper.class);
            users=mapper.FindAllUser();
        }finally {
            sqlSession.close();
        }
      return users;
    }

}
