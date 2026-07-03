import java.util.*;
public class GenericStack<T>{
    private List<T> list=new ArrayList<>();
    public void push(T item){list.add(item);}
    public T pop(){if(list.isEmpty()) throw new EmptyStackException(); return list.remove(list.size()-1);}
    public boolean isEmpty(){return list.isEmpty();}
}