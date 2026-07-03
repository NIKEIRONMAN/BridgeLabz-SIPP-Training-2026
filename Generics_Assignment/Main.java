import java.util.*;
public class Main{
    public static void main(String[] args){
        Pair<String,Integer> p=new Pair<>("Age",21);
        System.out.println(p);
        GenericStack<Integer> st=new GenericStack<>();
        st.push(10);st.push(20);
        System.out.println(st.pop());
        Integer[] arr={4,7,2,9};
        System.out.println(GenericUtils.findMax(arr));
        Repository<String> repo=new Repository<>();
        repo.add("Hello");
        GenericUtils.printList(repo.getAll());
    }
}