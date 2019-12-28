package com.goule666.study.witness;

import javax.management.*;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wlnie
 * @date 2019/10/15 13:37
 * @description
 **/
public class Test {

    private List<Integer> list = new ArrayList<>();

    private void test() {
        for (int i = 0; i < 100000000; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) throws MalformedObjectNameException, MBeanException, InstanceNotFoundException, ReflectionException {
        Object flags = ManagementFactory.getPlatformMBeanServer().invoke(
                ObjectName.getInstance("com.sun.management:type=DiagnosticCommand"),
                "vmFlags", new Object[] { null }, new String[] { "[Ljava.lang.String;" });
        for(String f: ((String)flags).split("\\s+"))
            if(f.contains("GC")) System.out.println(f);
        for(GarbageCollectorMXBean gc: ManagementFactory.getGarbageCollectorMXBeans())
            System.out.printf("%-20s%s%n", gc.getName(), Arrays.toString(gc.getMemoryPoolNames()));
    }
}
