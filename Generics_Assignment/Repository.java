import java.util.*;
public class Repository<T>{
    private final List<T> data=new ArrayList<>();
    public void add(T obj){data.add(obj);}
    public List<T> getAll(){return data;}
}