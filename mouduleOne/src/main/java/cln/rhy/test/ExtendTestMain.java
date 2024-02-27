package cln.rhy.test;

/**
 * @description:
 * @author: 15262726991
 * @since: 2023/10/16
 */
public class ExtendTestMain {

    static int index = 1;
    static int foo[] = new int[3];
    static int bar1 = foo[index];
    static int bar2 = bar1 + index;


    public double ff(byte x, double y) {
        return (short)x/y*2;
    }

    public static void stringReplace(String text) {
        text = text.replace("j", "k");
        System.out.println(text);
    }

    public static void bufferReplace(StringBuffer text) {
        text = text.append("c");
        System.out.println(text);

    }


    public static void main(String[] args) {
        /*Child child = new Child();
        child.display();*/
       /* double c = ff(1.0, 0.3);
        System.out.println(c);*/

     /*   System.out.println(index);
        System.out.println(bar1);
        System.out.println(bar2);*/

       /* String textString = new String("java");
        StringBuffer textBuffer = new StringBuffer("java");
        stringReplace(textString);
        bufferReplace(textBuffer);
        System.out.println(textString+textBuffer);*/

       /* String foo = "blue";
        boolean[] b = new boolean[1];
        if (b[0]) {
            foo = "green";
        }
        System.out.println(foo);*/

        class foo{
            public int i = 3;
        }
        Object ooo = (Object)new foo();
        foo ffff = (foo)ooo;
        System.out.println(ffff.i);
    }







}
