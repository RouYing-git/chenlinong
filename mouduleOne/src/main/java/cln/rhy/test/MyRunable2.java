package cln.rhy.test;

import java.time.LocalTime;

/**
 * @description:
 * @author: 15262726991
 * @since: 2023/10/31
 */
public class MyRunable2 implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; ++i) {
                System.out.println(LocalTime.now() + Thread.currentThread().getName() + i);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
        }
    }
}
