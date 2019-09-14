package com.goule666.study.witness.design.pattern.command;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.util.CollectionUtils;

import javax.management.relation.RoleUnresolved;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wlnie
 * @date 2019/9/14 23:18
 * @description 产品经理
 **/
public class ProductManager {
    List<Task> taskList = new ArrayList<>(10);
    List<Programmer> programmerList = new ArrayList<>(10);

    public ProductManager(Programmer... programmers) {
        this.programmerList = Arrays.asList(programmers);
    }

    /**
     * 接受任务
     */
    public void receive(Task task) {
        taskList.add(task);
    }

    /**
     * 分配任务
     */
    public void assign() {
        if (!CollectionUtils.isEmpty(taskList)) {
            taskList.forEach(x -> {
                x.handle();
            });
        }
    }

    public Programmer chooseProgrammer() {
        return programmerList.get(RandomUtils.nextInt(0, programmerList.size()));
    }

    public static void main(String[] args) {
        System.out.println(RandomUtils.nextInt(0, 3));
    }

}
