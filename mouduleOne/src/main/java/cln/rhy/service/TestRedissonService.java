package cln.rhy.service;

import cln.rhy.test.Animal;
import cln.rhy.test.Rabbit;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: 15262726991
 * @since: 2023/11/27
 */
@Service
public class TestRedissonService {

    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private Animal rabbit;


    public Integer write(String code) {
        boolean s = false;
        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock(code);
        readWriteLock.writeLock().lock(20, TimeUnit.SECONDS);
        System.out.println("写锁获得时间"+ LocalDateTime.now());
        try {
            if (!s) {
                return null;
            }
            redisTemplate.opsForValue().set("rhy:" + code, "RRRRRR");
        } finally {
            System.out.println("写锁放开时间"+ LocalDateTime.now());
            readWriteLock.writeLock().unlock();
        }
        return 2;
    }

    public void read(String code) {
        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock(code);
        readWriteLock.readLock().lock(5, TimeUnit.SECONDS);
        Object value = redisTemplate.opsForValue().get("rhy:" + code);
        System.out.println("读到值时间***" + code + "***" + value + "***" + LocalDateTime.now());

    }
    public void eee(String code) {
        Object value = redisTemplate.opsForValue().get("rhy:" + code);
        System.out.println("读到值时间***" + code + "***" + value + "***" + LocalDateTime.now());
    }
    public void testAbstract() {
        Animal rabbit = new Rabbit();
        String animalName = rabbit.name;//子类对象可获得抽象父类的属性值（子类无父类有）
        System.out.println(animalName);
        rabbit.animalMethod();//子类对象可调用抽象父类的正常方法（子类无父类有）
        rabbit.wise();
    }

    public void tt() {
        String animalName = rabbit.name;//子类对象可获得抽象父类的属性值（子类无父类有）
        System.out.println(animalName);
        rabbit.animalMethod();//子类对象可调用抽象父类的正常方法（子类无父类有）
        rabbit.wise();
    }
}
