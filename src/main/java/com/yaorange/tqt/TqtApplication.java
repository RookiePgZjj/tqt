package com.yaorange.tqt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

//启动类
@SpringBootApplication(scanBasePackages = {"com.yaorange.tqt"})
@MapperScan("com.yaorange.tqt.mapper")
public class TqtApplication {
    public static void main(String[] args) {
        SpringApplication.run(TqtApplication.class, args);
    }
}
