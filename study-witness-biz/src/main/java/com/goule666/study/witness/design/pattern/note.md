# 设计模式
设计模式是一个长期学习的过程，不需要迫切的去记一些东西，需要理解，然后进行模仿，加深印象并可以熟练运用。
我认为以下这些设计模式需特殊注意（源码出场率较高）：
1. 单例模式（spring中的bean）
2. 简单工厂模式、工厂模式（driver、connection，iterable、iterator）、抽象工厂模式（List.iterator、List.listIterator）
3. 策略模式（不同协议不同算法（处理器）、会员价格和满减活动）
️4. 责任链模式（不同的渠道获取水站）
5. 代理模式（）
6. 模板方法模式（classLoader）
7. 适配器模式（spring aop的advice相关 advisorAdapter（target）、advice（adaptee）、AfterReturningAdviceAdapter（adapter），
spring MVC的dispatcherServlet的 HandlerAdapter（target）、controller（adaptee）、SimpleControllerHandlerAdapter（adapter））

这些设计模式都很重要，这里只列出了我目前认为比较重要的几种设计模式，后续会把所有的设计模式对应的实际应用场景的demo写出来。

这周任务，把已经学了的设计模式，目前除了代理模式，观察者模式没有实际的应用场景以外，都有对应的源码，以及自己深刻的理解，这周结束，目标把这些设计模式对应的每一篇文章发出来，希望认真对待每一个字。