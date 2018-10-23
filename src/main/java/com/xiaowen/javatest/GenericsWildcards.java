package com.xiaowen.javatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsWildcards {
	
	//Upper Bounded Wildcards
    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }
    
    //Unbounded Wildcards
    public static void printList(List<?> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
        System.out.println();
    }
    
    //Lower Bounded Wildcards
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
    
    private static void foo(List<?> i) {
    	 fooHelper(i);
    }
    
    //Wildcard Helper Methods
    private static <T> void fooHelper(List<T> l) {
        l.set(0, l.get(1));
    }
    
    public static void main(String[] args) {

        List<Integer> li = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sumOfList(li));

        List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
        System.out.println("sum = " + sumOfList(ld));
        
        printList(li);
        printList(ld);
        
        List<Integer> li2 = new ArrayList<>();
        addNumbers(li2);
        printList(li2);
        
        foo(li2);
        printList(li2);
    }

}
