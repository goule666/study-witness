package com.goule666.study.witness.design.pattern.command;

/**
 * @author wlnie
 * @date 2019/9/14 23:18
 * @description 业务
 **/
public class Salesman {
    private ProductManager productManager;

    public Salesman(ProductManager productManager) {
        this.productManager = productManager;
    }

    public void demand() {
        productManager.receive(new Demand(productManager.chooseProgrammer()));
    }

    public void bug() {
        productManager.receive(new Bug(productManager.chooseProgrammer()));
    }

    public void problem() {
        productManager.receive(new Problem(productManager.chooseProgrammer()));
    }


}
