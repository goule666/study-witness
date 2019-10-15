package com.goule666.study.witness.design.pattern.strategy.memberPrice;

import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author wlnie
 * @date 2019/9/8 21:11
 * @description 创建CalPrice接口的工厂类 单例
 **/
public class CreateCalPriceFactory {
    private static final String PACKAGE_NAME = "com.goule666.study.witness.design.pattern.strategy.memberPrice";
    /**
     * 得到类加载器
     */
    private ClassLoader classLoader = getClass().getClassLoader();

    /**
     * 存放所有计算策略
     */
    private List<Class<? extends CalPrice>> clazzList;

    /**
     * 得到CalPrice实现类
     *
     * @param customer 顾客类
     * @return CalPrice实现类
     */
    public CalPrice getCalPrice(Customer customer) {
        if (!CollectionUtils.isEmpty(clazzList)) {
            SortedMap<Integer, Class<? extends CalPrice>> sortedMap = new TreeMap<>();
            for (Class<? extends CalPrice> clazz : clazzList) {
                Annotation annotation = handleClass(clazz);
                if (annotation == null) {
                    continue;
                }
                if (annotation instanceof TotalValidRegion) {
                    if (customer.getTotalAmount().intValue() >= ((TotalValidRegion) annotation).value().min()
                            && customer.getTotalAmount().intValue() < ((TotalValidRegion) annotation).value().max()) {
                        sortedMap.put(((TotalValidRegion) annotation).value().order(), clazz);
                    }
                } else if (annotation instanceof OnceValidRegion) {
                    if (customer.getAmount().intValue() >= ((OnceValidRegion) annotation).value().min()
                            && customer.getAmount().intValue() < ((OnceValidRegion) annotation).value().max()) {
                        sortedMap.put(((OnceValidRegion) annotation).value().order(), clazz);
                    }
                }
            }
            return CalPriceProxy.getProxy(sortedMap);
        }
        return null;
    }

    /**
     * 根据class得到注解是TotalValidRegion的类
     *
     * @param clazz class
     * @return TotalValidRegion
     */
    private Annotation handleClass(Class<? extends CalPrice> clazz) {
        Annotation[] annotations = clazz.getAnnotations();
        if (annotations == null || annotations.length == 0) {
            return null;
        }
        for (Annotation a : annotations) {
            if (a instanceof TotalValidRegion || a instanceof OnceValidRegion) {
                return a;
            }
        }
        return null;
    }

    private CreateCalPriceFactory() {
        //初始化
        init();
    }

    private void init() {
        try {
            clazzList = new ArrayList<>(10);
            File[] files = getResources();
            if (files == null || files.length == 0) {
                return;
            }
            Class<CalPrice> calPriceClass = CalPrice.class;
            Class<? extends CalPrice> clazz;
            for (File f : files) {
                clazz = (Class<? extends CalPrice>) classLoader.loadClass((PACKAGE_NAME + "." + f.getName()).replace(".class", ""));
                if (calPriceClass.isAssignableFrom(clazz) && clazz != calPriceClass) {
                    clazzList.add(clazz);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    /**
     * 得到所有存放策略的class的文件名称
     *
     * @return File[]
     */
    private File[] getResources() {
        try {
            File file = new File(classLoader.getResource(PACKAGE_NAME.replace(".", "/")).toURI());
            return file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if (pathname.getName().endsWith(".class")) {
                        return true;
                    }
                    return false;
                }
            });
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static class GetSingleTon {
        private static CreateCalPriceFactory createCalPriceFactory = new CreateCalPriceFactory();
    }

    public static CreateCalPriceFactory getInstance() {
        return GetSingleTon.createCalPriceFactory;
    }


}
