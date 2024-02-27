package cln.rhy.test;

import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: 15262726991
 * @since: 2023/11/30
 */
@Service
public class Fangxing implements Shape{
    @Override
    public void area() {
        System.out.println("Fangxing's area method");
    }

    @Override
    public void volume() {
        System.out.println("Fangxing's volume method");
    }
}
