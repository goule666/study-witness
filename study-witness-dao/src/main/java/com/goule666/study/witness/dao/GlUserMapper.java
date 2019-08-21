package com.goule666.study.witness.dao;

import com.goule666.study.witness.entity.GlUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Mybatis Generator 2018/12/13
 *
 * @author wlnie
 */
@Mapper
public interface GlUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GlUser record);

    int insertSelective(GlUser record);

    GlUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GlUser record);

    int updateByPrimaryKey(GlUser record);
}