package com.goule666.study.witness.design.pattern.command;

/**
 * @author wlnie
 * @date 2019/9/14 23:28
 * @description
 **/
public class Test {
    public static void main(String[] args) {
        //三个程序员
        Programmer programmer = new Programmer("goule666");
        Programmer programmer1 = new Programmer("goule777");
        Programmer programmer2 = new Programmer("goule888");

        //一个产品经理
        ProductManager productManager = new ProductManager(programmer, programmer1, programmer2);

        //一个业务员
        Salesman salesman = new Salesman(productManager);

        //业务处理三个需求
        salesman.demand();
        salesman.bug();
        salesman.problem();

        //产品经理分配任务
        productManager.assign();
    }
}
