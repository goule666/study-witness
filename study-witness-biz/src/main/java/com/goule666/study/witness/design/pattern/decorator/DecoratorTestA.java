package com.goule666.study.witness.design.pattern.decorator;

/**
 * @author wlnie
 * @date 2019/9/14 15:04
 * @description 具体装饰器
 **/
public class DecoratorTestA extends AbstractDecoratorTest {

    public DecoratorTestA(TestInterface testInterface) {
        super(testInterface);
    }

    @Override
    public void method() {
        System.out.println("针对该方法加一层包装A");
        super.method();
        System.out.println("A包装结束");
    }

    public void methodA() {
        System.out.println("新增的方法");
    }
}
