package demo;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;


/**
 * @class ElConfig
 * @Author Administrator
 * @Description //TODO
 * @Date 19-10-24 下午3:49
 * @Version 1.0
 */
@Configuration
@ComponentScan("demo")
@PropertySource("classpath:test.properties")
public class ElConfig {
    @Value("I LOVE YOU")
    private String normal;
    @Value("#{systemProperties['os.name']}")
    private String osName;
    @Value("#{T(java.lang.Math).random()*100.0}")
    private double randomNumber;
    @Value("#{demoService.another}")
    private String fromAnother;
    @Value("classpath:test.txt")
    private Resource testFile;
    @Value("http://www.baidu.com")
    private Resource testUrl;
    @Value("${book.name}")
    private String bookName;
    @Autowired
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource(){
        System.out.println(normal);
        System.out.println(osName);
        System.out.println(randomNumber);
        System.out.println(fromAnother);
        try {
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(environment.getProperty("book.author"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
