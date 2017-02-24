package com.action;

import lombok.Data;


@Data
public class Test {
    private int id;
    private String name;
    public void abc(){
        System.out.println(id);
        System.out.println(name);
        System.out.println("This.abc()......");
    }
    public void delete(){
        System.out.println(id);
        System.out.println(name);
        System.out.println("This.delete()......");
    }
    public void save(){
        System.out.println(id);
        System.out.println(name);
        System.out.println("This.save()......");
    }
    public void execute(){
        System.out.println(id);
        System.out.println(name);
        System.out.println("This.execute()......");
    }
}
