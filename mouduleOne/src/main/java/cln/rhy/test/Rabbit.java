package cln.rhy.test;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: 15262726991
 * @since: 2023/11/30
 */
@Component
public class Rabbit extends Animal {
    @Override
    public void wise() {
        System.out.println("Rabbit's wise method");
    }

}
