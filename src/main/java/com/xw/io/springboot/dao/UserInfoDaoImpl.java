package com.xw.io.springboot.dao;

import com.xw.io.springboot.model.UserInfo;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by xiaowei.liu on 13/11/2017.
 */
@Repository
public class UserInfoDaoImpl implements UserInfoDao {
    @Autowired
    @Setter
    private JdbcTemplate jdbcTemplate;


    @Override
    public void create(UserInfo userInfo) {
        jdbcTemplate.update("insert into user_info(user_name, user_password, user_id) values(?, ?, ?)", userInfo.getUserName(), userInfo.getUserPassword(), userInfo.getUserId());
    }

    @Override
    public List<UserInfo> read(int userId) {
        return jdbcTemplate.query("select user_name, user_password, user_id from user_info where user_id=?", new Object[]{userId}, new RowMapper<UserInfo>() {
            @Override
            public UserInfo mapRow(ResultSet resultSet, int i) throws SQLException {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(resultSet.getInt("user_id"));
                userInfo.setUserName(resultSet.getString("user_name"));
                userInfo.setUserPassword(resultSet.getString("user_password"));
                return userInfo;
            }
        });
    }

    @Override
    public void update(UserInfo userInfo) {

    }

    @Override
    public void delete(int userId) {

    }
}
