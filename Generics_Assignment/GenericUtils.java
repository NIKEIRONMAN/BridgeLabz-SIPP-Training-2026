import java.util.*;
public class GenericUtils{
    public static <T extends Comparable<T>> T findMax(T[] arr){
        if(arr.length==0) return null;
        T max=arr[0];
        for(T x:arr) if(x.compareTo(max)>0) max=x;
        return max;
    }
    public static void printList(List<?> list){
        for(Object o:list) System.out.println(o);
    }
}