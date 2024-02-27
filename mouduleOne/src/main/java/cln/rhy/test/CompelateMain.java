package cln.rhy.test;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author: 15262726991
 * @since: 2023/11/1
 */
public class CompelateMain {


    public static void main(String[] args) {

        CompletableFuture.runAsync(() -> {
            for (int i = 1; i <= 10; ++i) {
                System.out.println(LocalTime.now() + Thread.currentThread().getName() + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

}
