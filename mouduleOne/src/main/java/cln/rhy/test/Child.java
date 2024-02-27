package cln.rhy.test;

import org.springframework.stereotype.Service;

@Service
public class Child extends Parent {
    public String name = "Child";


    public void childMethod(String param){
        System.out.println(name);
        System.out.println(init);//因为子类中没有init属性，所以自动获取父类的init属性值，所以不需要写super
        System.out.println(super.name); // 因为子类中也有name属性，所以使用super.才能区分开获取父类的name属性值

        parentMethod("456");// 为什么不用写super.的原因是子类中没有这个方法就会自动去调用父类的
        super.allhaveMethod(); // 调用父类的display()方法
    }
    public void allhaveMethod() {
        System.out.println("Child's allhaveMethod method");
    }

    public static void main(String[] args) {
        Parent child = new Child();
        child.allhaveMethod(); //因为new的是子类，所以会调用子类的这个方法体
        child.parentMethod("890");// 子类对象可直接调用 子类无但父类有 的方法

        Parent parent = new Parent();
        parent.allhaveMethod();

    }
}