package cln.rhy.test;

import org.springframework.stereotype.Service;

@Service
public class Parent {
    public String init = "family";
    public String name = "Parent";
    
    public void allhaveMethod() {
        System.out.println("Parent's allhaveMethod method");
    }

    public void parentMethod(String code) {
        System.out.println("Parent's parentMethod method");
        System.out.println(code);
    }
}