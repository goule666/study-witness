package com.goule666.study.witness.design.pattern.command;

/**
 * @author wlnie
 * @date 2019/9/14 23:26
 * @description bug 任务
 **/
public class Bug implements Task {
    private Programmer programmer;

    public Bug(Programmer programmer) {
        this.programmer = programmer;
    }

    /**
     * 处理任务
     */
    @Override
    public void handle() {
        programmer.bug();
    }
}

class Demand implements Task{

    private Programmer programmer;

    public Demand(Programmer programmer) {
        this.programmer = programmer;
    }

    /**
     * 处理任务
     */
    @Override
    public void handle() {
        programmer.demand();
    }
}

class Problem implements Task{

    private Programmer programmer;

    public Problem(Programmer programmer) {
        this.programmer = programmer;
    }

    /**
     * 处理任务
     */
    @Override
    public void handle() {
        programmer.problem();
    }
}