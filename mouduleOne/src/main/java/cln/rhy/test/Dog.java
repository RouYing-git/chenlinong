package cln.rhy.test;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: 15262726991
 * @since: 2023/12/1
 */
@Component
public class Dog extends Animal{
    @Override
    public void wise() {
        System.out.println("Dog's wise method");
    }
}
