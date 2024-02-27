package cln.rhy.test;

import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: 15262726991
 * @since: 2023/11/30
 */
@Service
public abstract class Animal {

    public String name = "动物";
    public void animalMethod(){
        System.out.println("Animal's wise method");
    }
    public abstract void wise();
}
