package com.xiaowen.javatest;

import java.math.BigInteger;

public class Box <T> {
	
	private T t;          

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
    
    static Box createBox() {   // warning: Box is a raw type. References to generic type Box<T> should be parameterized
        return new Box();
    }

    public <U extends Number> void inspect(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.set(new Integer(10));
        integerBox.inspect(BigInteger.valueOf(1000000));
        
        
        Box rawBox = new Box();        // rawBox is a raw type of Box<T>
        Box<Integer> intBox = rawBox;  // warning: unchecked conversion
        
        Box<Integer> bi;
        bi = createBox();              // warning: unchecked conversion
    }

}
