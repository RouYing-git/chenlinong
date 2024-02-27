
package cln.rhy.test;

import java.util.*;


/**
 * @description:
 * @author: 15262726991
 * @since: 2023/9/20
 */

public class Main {

    private static String staticString = "static string";

    /**
     * 滑动窗口解法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> checkDupSet = new HashSet<>();
        int length = s.length();
        int end = -1;
        int max = 0;
        for (int i = 0; i < length; ++i) {
            if (i>0) {
                checkDupSet.remove(s.charAt(i-1));
            }
            while (end + 1 <length && !checkDupSet.contains(s.charAt(end+1))) {
                checkDupSet.add(s.charAt(end+1));
                ++end;
            }
            max = Math.max(max, end - i + 1);
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
       /* int re = lengthOfLongestSubstring("abcabcbb");
        int re2 = lengthOfLongestSubstring("bbbbb");
        int re3 = lengthOfLongestSubstring("pwwkew");
        System.out.println(re);
        System.out.println(re2);
        System.out.println(re3);*/
       /* String s1=new String("go")+new String("od");
        s1.intern();   //将 堆中新建的对象"hello" 存入字符串常量池
        String s2="good";
        System.out.println(s1==s2);//输出是true。

        String s3=new String("he")+new String("llo");//地址是char[5]@503
        String s4=new String("h")+new String("ello");//地址是char[5]@504
        String s5=s3.intern();//地址是char[5]@503
        String s6=s4.intern();//地址是char[5]@503
        System.out.println(s3==s5);//true 比较引用地址
        System.out.println(s3==s6);//true 比较引用地址  *因为s3先调用了.intern方法将hello字符串和其引用对象的地址绑定起来存入了常量池中，所以在此行代码之后的所有值为hello的字符串地址都是s3的地址。*/

     /*   try{
            int i = 0;
            int j = 4;
            double b = j /i;

        } catch (Exception e) {
            System.out.println("有异常");
            throw new Exception("除法异常");
        }*/


/*
        List<String> list1 = new ArrayList<>();
        list1.add("qq");
        list1.add("ww");
        list1.add("ee");
        List<String> newList = list1;
        newList.add("rr");
        System.out.println(list1);
*/
    }


}
