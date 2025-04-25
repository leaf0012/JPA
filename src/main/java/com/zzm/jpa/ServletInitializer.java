package com.zzm.jpa;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @ClassName: ServletInitializer
 * @Description: TODO
 * @Author: 邹智敏
 * @Date: 2018/8/13   15:00
 * @Version: 1.0
 */
public class ServletInitializer  extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JPAApplication.class);
    }
}
