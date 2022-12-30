package com.ggs.seatastock;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Collections;

class SeataOrderApplicationTests {

    @Test
    public void contextLoads() {
        // E:\workspace\backend\practice-spring-cloud-alibaba\seata-stock
        String url = "jdbc:mysql://123.56.154.63:3306/order_alibaba_demo?serverTimezone=GMT%2B8&characterEncoding=utf8";
        String username = "root";
        String password = "9695f03978804617955a6643b6b49601";
        String javaCodePath = "/src/main/java/";
        String resourceCodePath = "/src/main/resources/";
        String projectPath = new File("").getAbsolutePath();

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("starbug") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(projectPath + javaCodePath); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.ggs") // 设置父包名
                            .moduleName("seataorder") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, projectPath + resourceCodePath + "mapper/")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("order", "order_item"); // 设置需要生成的表名
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
