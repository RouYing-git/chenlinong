package cln.rhy.test;

import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: 15262726991
 * @since: 2023/11/30
 */
@Service
public interface Shape {

    String name = "图形";

    void area();

    void volume();
}