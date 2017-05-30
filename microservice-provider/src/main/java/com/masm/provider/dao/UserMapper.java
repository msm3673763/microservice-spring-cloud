package com.masm.provider.dao;

import com.masm.provider.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by simple on 2017/5/29.
 */
@Mapper
public interface UserMapper {

    User findById(@Param("id") int id);
}
