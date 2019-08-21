package com.goule666.study.witness.service.impl;

import com.goule666.study.witness.dao.GlUserMapper;
import com.goule666.study.witness.entity.GlUser;
import com.goule666.study.witness.service.GlUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wlnie
 * @date 2018/12/13 15:28
 * @description 用户service
 **/
@Service
public class GlUserServiceImpl implements GlUserService {
    @Resource
    private GlUserMapper glUserMapper;

    @Override
    public GlUser selectByPrimaryKey(Integer id) {
        return glUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据ID更新
     *
     * @param record record
     * @return 1 or 0
     */
    @Override
    public int updateByPrimaryKeySelective(GlUser record) {
        return glUserMapper.updateByPrimaryKeySelective(record);
    }

}
