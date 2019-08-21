package com.goule666.study.witness.service;

import com.goule666.study.witness.entity.GlUser;

/**
 * @author wlnie
 * @date 2018/12/13 15:27
 * @description 用户service
 **/
public interface GlUserService {
    /**
     * 根据主键ID查询实体
     *
     * @param id id
     * @return glUser
     */
    GlUser selectByPrimaryKey(Integer id);

    /**
     * 根据ID更新
     *
     * @param record record
     * @return 1 or 0
     */
    int updateByPrimaryKeySelective(GlUser record);

}
