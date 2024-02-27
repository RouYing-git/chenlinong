package cln.rhy.test;

import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: 15262726991
 * @since: 2023/11/30
 */
@Service
public class Circle implements Shape{
    @Override
    public void area() {
        System.out.println("Circle's area method");
    }

    @Override
    public void volume() {
        System.out.println("Circle's volume method");
        System.out.println(name);
    }

    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.area();
        circle.volume();

    }
}
