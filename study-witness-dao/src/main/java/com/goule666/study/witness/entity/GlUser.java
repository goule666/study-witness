package com.goule666.study.witness.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Mybatis Generator 2018/12/13
 *
 * @author wlnie
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GlUser {
    /**
     *
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 余额
     */
    private Integer balance;
}