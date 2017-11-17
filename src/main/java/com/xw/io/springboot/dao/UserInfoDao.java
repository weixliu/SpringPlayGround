package com.xw.io.springboot.dao;

import com.xw.io.springboot.model.UserInfo;

import java.util.List;

/**
 * Created by xiaowei.liu on 13/11/2017.
 */
public interface UserInfoDao {
    public void create(UserInfo userInfo);

    public List<UserInfo> read(int userId);

    public void update(UserInfo userInfo);

    public void delete(int userId);
}
