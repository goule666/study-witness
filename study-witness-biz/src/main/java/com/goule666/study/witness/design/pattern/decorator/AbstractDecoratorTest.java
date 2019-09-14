package com.goule666.study.witness.design.pattern.decorator;

/**
 * @author wlnie
 * @date 2019/9/14 15:03
 * @description 父类装饰器
 **/
public abstract class AbstractDecoratorTest implements TestInterface {

    private TestInterface testInterface;

    public AbstractDecoratorTest(TestInterface testInterface) {
        this.testInterface = testInterface;
    }

    @Override
    public void method() {
        testInterface.method();
    }
}
