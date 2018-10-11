package net.htmlonline.cglibs;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

public class CgLibTests {
    @Test
    public void run3() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CgDomain.class);
        enhancer.setCallback(new MyMethodInterceptor());
        CgDomain userService = (CgDomain)enhancer.create();
        userService.add();

    }
}
