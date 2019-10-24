package demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @class Main
 * @Author Administrator
 * @Description //TODO
 * @Date 19-10-24 下午4:03
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig resourceService = context.getBean(ElConfig.class);
        resourceService.outputResource();
        context.close();
    }
}
