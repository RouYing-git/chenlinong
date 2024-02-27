package cln.rhy.controller;

import cln.rhy.config.TestProperties;
import cln.rhy.entity.IaSyncUserRecord;
import cln.rhy.service.ITestService;
import cln.rhy.service.IaSyncUserRecordService;
import cln.rhy.service.TestRedissonService;
import cln.rhy.test.*;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: 15262726991
 * @since: 2023/11/15
 */
@RestController
@Slf4j
public class MyController {

    @Autowired
    private Class1 class1;
    @Autowired
    private TestRedissonService testRedissonService;
    @Autowired
    private TestProperties testProperties;
    //extends
    @Autowired
    private Child child;
    //implements
    @Autowired
    private Shape circle;
    //Abstract
    @Autowired
    private Animal dog;

    //dog和rabbit会自动赋值到animals中  加注解@Autowired和加构造方法 效果一样 选其一就行
    @Autowired
    private List<Animal> animals;
   /* public MyController(List<Animal> animals) {//dog和rabbit会自动赋值到animals中
        this.animals = animals;
    }*/

   @Value("${my.value.file2}")
   String ss;

   @Autowired
   private IaSyncUserRecordService iaSyncUserRecordService;

    @Autowired
    private ITestService testService;



    //测试自动配置属性
    @GetMapping("/hello")
    public String hello() {
        System.out.println(JSON.toJSONString(class1));//输出：{"s1":"huhuhuhu","s2":"123"}
        String pro1 = testProperties.getPro1();
        String pro2 = testProperties.getPro2();
        System.out.println(pro1 + pro2);//输出：pro1valuepro2value
        return "hello cln";
    }

    //这个接口同时既获取写锁又获取读锁，由于处于同一个线程且用的锁RReadWriteLock是可重入的，所以不用阻塞，意味着就算写锁没释放，读锁也能直接读。
    @GetMapping("/all")
    public String hello8() {
        testRedissonService.write("cc");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        testRedissonService.read("cc");
        return "hello cln";
    }

    //测试redisson的可重入读写锁RReadWriteLock
    @GetMapping("/testRead")
    public String hello2() {
        testRedissonService.read("yy");
        return "hello cln";
    }

    @GetMapping("/testWrite")
    public String hello3() {
        testRedissonService.write("yy");
        return "hello cln";
    }

    @GetMapping("/testExtends")
    public String testExtends() {
        String init = child.init;
        System.out.println(init);
        String name = child.name;
        System.out.println(name);
        child.parentMethod("qwer");
        child.childMethod("rty");
        child.allhaveMethod();
        return "hello cln";
    }

    @GetMapping("/testImplements")
    public String testImplements() {
        circle.area();
        circle.volume();
        return "hello cln";
    }

    @GetMapping("/testAbstract")
    public String testAbstract() {
        /*TestRedissonService testRedissonService1 = new TestRedissonService();//不一定非要用注入的service对象，也可以自己new出来，但是会很浪费资源所以才有依赖注入。
        testRedissonService1.testAbstract();*/
        /*String animalName = dog.name;
        System.out.println(animalName);
        dog.animalMethod();
        dog.wise();*/
        String name = animals.get(0).name;
        System.out.println(name);

        Animal rabbit = animals.get(0);
        rabbit.wise();
        Animal dog = animals.get(1);
        dog.wise();
        return "hello cln";
    }

    @GetMapping("/ss")
    public String ss() {
        String d = "file:/opt/sinitek/nasdata2/yui/hgf";
        String replace = d.replaceAll(ss, "https://test-ireswechat.mszq.com/wechat");
        System.out.println(replace);
        return "hello cln";
    }

    @GetMapping("/sees")
    public String sees() {
        try {
            testService.dd();
        } catch (Exception e) {
            log.error("yichang乐乐乐乐");
        }
        return "hello cln";
    }

    @GetMapping("/rhy")
    public String rhy() {
        IaSyncUserRecord iaSyncUserRecord = new IaSyncUserRecord();
        iaSyncUserRecord.setCreateTime(LocalDateTime.now());
        boolean b = iaSyncUserRecordService.updateById(iaSyncUserRecord);
        System.out.println(b);
        return "hello cln";
    }

    @GetMapping("/redis")
    public String redis() {
        return "hello cln";
    }

}
