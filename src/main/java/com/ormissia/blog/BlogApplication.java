package com.ormissia.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ormissia.blog.dao")
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);

        System.out.println("   ___                       _               _             ______  __                 \n" +
                " .'   `.                    (_)             (_)           |_   _ \\[  |                \n" +
                "/  .-.  \\_ .--. _ .--..--.  __  .--.  .--.  __  ,--.  ______| |_) || |  .--.   .--./) \n" +
                "| |   | [ `/'`\\| `.-. .-. |[  |( (`\\]( (`\\][  |`'_\\ :|______|  __'.| |/ .'`\\ \\/ /'`\\; \n" +
                "\\  `-'  /| |    | | | | | | | | `'.'. `'.'. | |// | |,     _| |__) | || \\__. |\\ \\._// \n" +
                " `.___.'[___]  [___||__||__|___|\\__) )\\__) )___]'-;__/    |_______[___]'.__.' .',__`  \n" +
                "                                                                             ( ( __)) ");
    }

}
