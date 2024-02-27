
package cln.rhy.test;


/**
 * @description:
 * @author: 15262726991
 * @since: 2023/10/24
 */

public class MyRunable implements Runnable {

    int i;

    @Override
    public void run() {
        try {
          /*  for (int i = 1; i <= 10; ++i) {
                System.out.println(LocalTime.now() + Thread.currentThread().getName() + i);
                Thread.sleep(2000);
            }*/
            Thread.sleep(5000);
            i = 3;
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {
        try {
            MyRunable a = new MyRunable();
            Thread t = new Thread(a);
            t.start();
//            t.join();//将t线程的执行体插队到主线程main的执行中 等待t的执行体结束后才继续执行main线程后面的代码。
            Thread.sleep(6000);
//            t.wait();
//            t.notify();
//            t.interrupt();
            int j = a.i;
            System.out.println(j);
           /* MyRunable2 myRunable2 = new MyRunable2();
            Thread thread2 = new Thread(myRunable2, "thread_two");
            thread2.start();
            System.out.println(Thread.currentThread().getName() + "为当前主线程");*/

        } catch (Exception e) {
        }

    }


}

