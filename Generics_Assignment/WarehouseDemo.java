import java.util.*;
abstract class WarehouseItem{
    String name;
    WarehouseItem(String name){this.name=name;}
    public String toString(){return name;}
}
class Electronics extends WarehouseItem{Electronics(String n){super(n);}}
class Groceries extends WarehouseItem{Groceries(String n){super(n);}}
class Furniture extends WarehouseItem{Furniture(String n){super(n);}}
class Storage<T extends WarehouseItem>{
    private List<T> items=new ArrayList<>();
    void add(T t){items.add(t);}
    List<T> getItems(){return items;}
}
public class WarehouseDemo{
    static void display(List<? extends WarehouseItem> items){
        for(WarehouseItem i:items) System.out.println(i);
    }
    public static void main(String[] args){
        Storage<Electronics> s=new Storage<>();
        s.add(new Electronics("Laptop"));
        display(s.getItems());
    }
}